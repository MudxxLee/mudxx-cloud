package net.agilewing.phoenix.cdn.impl.cm.services.bulider;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.agilewing.phoenix.cdn.dao.cert.CdnCertificate;
import net.agilewing.phoenix.cdn.dao.cert.mapper.CdnCertificateRepository;
import net.agilewing.phoenix.cdn.i.cdnconfig.vo.*;
import net.agilewing.phoenix.cdn.i.scheduler.bo.CdnSchedulerModel;
import net.agilewing.phoenix.cdn.impl.cm.common.enums.EnabledEnum;
import net.agilewing.phoenix.cdn.impl.cm.common.enums.OnOffEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.*;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnOriginProtocolEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnOriginRoleEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnDomainModifyRequest;
import net.agilewing.phoenix.common.model.util.BeanCopyUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author laiw
 * @date 2023/10/30 14:46
 */
@Component
public class CMCdnRequestBuilder {

    @Autowired(required = false)
    private CdnCertificateRepository cdnCertificateRepository;

    public CMCdnDomainModifyRequest buildCdnDomainModifyRequest(CdnSchedulerModel model) {

        CdnConfigVo cdnConfigVo = model.getCdnConfig();
        CdnCertificateApplyVo cdnCertificateVo = model.getCdnCertificateApply();
        CdnRestrictionVo cdnRestrictionVo = model.getCdnRestriction();
        List<CdnOriginVo> cdnOriginVos = model.getCdnOrigins();
        List<CdnErrorPageVo> cdnErrorPageVos = model.getCdnErrorPages();
        List<CdnSchedulerModel.DefaultSchedulerCdnCacheBehavior> cdnCacheBehaviors = BeanCopyUtil.copyListProperties(
                model.getCdnCacheBehaviors(), CdnSchedulerModel.DefaultSchedulerCdnCacheBehavior::new);
        if (cdnCacheBehaviors == null) {
            cdnCacheBehaviors = new ArrayList<>();
            cdnCacheBehaviors.add(model.getDefaultCdnCacheBehavior());
        }

        // 证书和SSL协议配置
        Map<String, String> certAndSslMap = this.buildCertAndSsl(cdnCertificateVo);

        // 回源host配置
        Map<String, Object> originHostMap = this.buildOriginHost(cdnConfigVo, cdnOriginVos);

        return new CMCdnDomainModifyRequest.Builder()
                .domain(cdnConfigVo.getDomain())
                // 加速类型
                .productCode(CMCdnConverter.turnIntoProductCode(cdnConfigVo.getConfigModel()).getCode())
                // ipv6 启用
                .ipv6Enable(CMCdnConverter.turnIntoIpv6Enable(cdnConfigVo.getIsIpv6Enabled()))
                // 共享缓存域名-未传代表不修改
                .sharedHost(null)
                // https是否开启
                .httpsStatus(certAndSslMap.get("httpsStatus"))
                // 证书备注名
                .certName(certAndSslMap.get("certName"))
                // ssl协议类型
                .ssl(certAndSslMap.get("ssl"))
                // ssl_stapling开关
                .sslStapling(certAndSslMap.get("sslStapling"))

                // https基础信息-未传代表不修改
                .httpsBasic(this.buildHttpsBasic(cdnOriginVos))
                // http配置基础信息
                .basicConf(this.buildHttpsBasicConf(cdnConfigVo))

                // 回源信息
                .origin(this.buildOriginList(cdnOriginVos))

                // 回源host
                .reqHost(MapUtils.getString(originHostMap, "reqHost"))
                .originHostType(MapUtils.getInteger(originHostMap, "originHostType"))
                .originHostHttp(MapUtils.getMap(originHostMap, "originHostHttp"))

                // 自定义回源请求头
                .reqHeaders(this.buildReqHeadersList(cdnOriginVos))

                // 缓存类型
                .filetypeTtl(this.buildFiletypeTtlList(cdnCacheBehaviors))

                // 错误状态码缓存
                .errorCode(this.buildErrorCodeList(cdnErrorPageVos))

                // 缓存参数
                .cacheKeyArgs(this.buildCacheKeyArgsList(cdnCacheBehaviors))
//                .cacheKeyArgsCondition()

                .build();
    }

    private Map<String, String> buildCertAndSsl(CdnCertificateApplyVo cdnCertificateVo) {
        Map<String, String> map = new HashMap<>();
        if (cdnCertificateVo == null) {
            map.put("httpsStatus", OnOffEnum.Off.getCode());
            map.put("certName", "");
            map.put("ssl", "");
            map.put("sslStapling", OnOffEnum.Off.getCode());
            return map;
        }

        if (cdnCertificateVo.getType() == 2) {
            CdnCertificate cdnCertificate = cdnCertificateRepository.getOne(cdnCertificateVo.getCdnCertificateId());
            map.put("httpsStatus", OnOffEnum.On.getCode());
            map.put("certName", cdnCertificate.getCertificateName());
        } else {
            // 未传代表不修改
            map.put("httpsStatus", null);
            map.put("certName", null);
        }
        map.put("ssl", CMCdnConverter.turnIntoSsl(cdnCertificateVo.getMinimumProtocolVersion()));
        map.put("sslStapling", Boolean.TRUE.equals(cdnCertificateVo.getSslSupportMethod()) ?
                OnOffEnum.On.getCode() : OnOffEnum.Off.getCode());
        return map;
    }

    private CMCdnHttpsBasic buildHttpsBasic(List<CdnOriginVo> cdnOriginVos) {
        CMCdnHttpsBasic httpsBasic = new CMCdnHttpsBasic();
        if (ObjectUtils.isEmpty(cdnOriginVos)) {
            // 传空对象{}代表删除
            return httpsBasic;
        }
        // 源站域名 (取默认原源作为回源host)
        CdnOriginVo cdnOriginVo = cdnOriginVos.stream()
                .filter(e -> new Integer(1).equals(e.getType()))
                .findFirst().get();
        httpsBasic.setForceStatus(null);
        httpsBasic.setHttpForce(null);
        httpsBasic.setHttpsForce(null);
        httpsBasic.setOriginProtocol(CMCdnConverter.turnIntoOriginProtocol(
                cdnOriginVo.getOriginProtocolPolicy()).getCode());
        return httpsBasic;
    }

    private CMCdnHttpsBasicConf buildHttpsBasicConf(CdnConfigVo cdnConfigVo) {
        CMCdnHttpsBasicConf basicConf = new CMCdnHttpsBasicConf();
        if (!"http2".equals(cdnConfigVo.getHttpVersion())) {
            // 传空对象{}代表删除
            return basicConf;
        }
        basicConf.setUseHttp2(EnabledEnum.Enable.getCode());
        basicConf.setFollow302(null);
        return basicConf;
    }

    private List<CMCdnOriginSingle> buildOriginList(List<CdnOriginVo> cdnOriginVos) {
        List<CMCdnOriginSingle> origins = new ArrayList<>();
        if (ObjectUtils.isEmpty(cdnOriginVos)) {
            // 传空数组[]代表删除
            return origins;
        }
        cdnOriginVos.forEach(e -> {
            CMCdnOriginSingle o = new CMCdnOriginSingle();
            o.setOrigin(e.getDomainName());
            o.setRole(new Integer(1).equals(e.getType()) ?
                    CMCdnOriginRoleEnum.master.getCode() : CMCdnOriginRoleEnum.slave.getCode());
            o.setWeight(50);
            CMCdnOriginProtocolEnum originProtocolEnum = CMCdnConverter.turnIntoOriginProtocol(e.getOriginProtocolPolicy());
            switch (originProtocolEnum) {
                case http:
                    o.setPort(e.getHttpPort());
                    o.setProtocol("http");
                    break;
                case https:
                    o.setPort(e.getHttpsPort());
                    o.setProtocol("https");
                default:
                    break;
            }
            origins.add(o);
        });
        return origins;
    }

    private Map<String, Object> buildOriginHost(CdnConfigVo cdnConfigVo, List<CdnOriginVo> cdnOriginVos) {
        String reqHost;
        Integer originHostType;
        Map<String, String> originHostHttp;
        switch (cdnConfigVo.getCustomHostType()) {
            case 1:
                // 加速域名（domain）
                reqHost = cdnConfigVo.getDomain();
                originHostType = EnabledEnum.Disable.getCode();
                originHostHttp = new HashMap<>();
                break;
            case 2:
                // 源站域名 (取默认原源作为回源host)
                CdnOriginVo cdnOriginVo = cdnOriginVos.stream()
                        .filter(e -> new Integer(1).equals(e.getType()))
                        .findFirst().get();
                reqHost = cdnOriginVo.getDomainName();
                originHostType = EnabledEnum.Disable.getCode();
                originHostHttp = new HashMap<>();
                break;
            case 3:
                // 3.自定义域名(其他域名)
                reqHost = cdnConfigVo.getCustomHost();
                originHostType = EnabledEnum.Disable.getCode();
                originHostHttp = new HashMap<>();
                break;
            default:
                // 默认
                reqHost = "";
                originHostType = EnabledEnum.Disable.getCode();
                originHostHttp = new HashMap<>();
                break;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("reqHost", reqHost);
        map.put("originHostType", originHostType);
        map.put("originHostHttp", originHostHttp);
        return map;
    }

    private List<CMCdnReqHeaders> buildReqHeadersList(List<CdnOriginVo> cdnOriginVos) {
        List<CMCdnReqHeaders> reqHeaders = new ArrayList<>();
        if (ObjectUtils.isEmpty(cdnOriginVos)) {
            // 传空数组[]代表删除
            return reqHeaders;
        }
        cdnOriginVos.forEach(e -> {
            try {
                List<JSONObject> array = JSONArray.parseArray(e.getOriginCustomHeader(), JSONObject.class);
                array.forEach(json -> {
                    CMCdnReqHeaders headers = new CMCdnReqHeaders();
                    headers.setKey(json.getString("headerName"));
                    headers.setValue(json.getString("headerValue"));
                    reqHeaders.add(headers);
                });
            } catch (Exception ignored) {
            }
        });
        return reqHeaders;
    }

    private List<CMCdnFiletypeTtl> buildFiletypeTtlList(List<CdnSchedulerModel.DefaultSchedulerCdnCacheBehavior> cdnCacheBehaviors) {
        if (ObjectUtils.isEmpty(cdnCacheBehaviors)) {
            // 传空数组[]代表删除
            return new ArrayList<>();
        }
        List<CMCdnFiletypeTtl> tempList = new ArrayList<>();
        cdnCacheBehaviors.forEach(e -> {
            // 行为
            CdnCacheBehaviorsVo behaviorsVo = e.getCdnCacheBehaviors();
            CdnCacheBehaviorsForwardVo behaviorsForwardVo = e.getCdnCacheBehaviorsForward();
            CMCdnFiletypeTtl o = new CMCdnFiletypeTtl();
            o.setCacheType(3);
            o.setPriority(10);
            o.setTtl(behaviorsVo.getDefaultTtl().intValue());
            o.setCacheWithArgs(CMCdnConverter.turnIntoCacheWithArgs(behaviorsForwardVo.getQueryString()));
            // 转变成-缓存文件类型
            Map<String, Object> map = CMCdnConverter.turnIntoModeAndFileType(behaviorsVo.getPathPattern());
            o.setMode(MapUtils.getInteger(map, "mode"));
            o.setFileType(MapUtils.getString(map, "fileType"));
            tempList.add(o);
        });

        Map<Integer, List<CMCdnFiletypeTtl>> listMap = tempList.stream()
                .collect(Collectors.groupingBy(CMCdnFiletypeTtl::getMode));
        if (listMap.containsKey(3)) {
            return Stream.of(listMap.get(3).get(0)).collect(Collectors.toList());
        }

        List<CMCdnFiletypeTtl> filetypeTtls = new ArrayList<>();
        for (Map.Entry<Integer, List<CMCdnFiletypeTtl>> entry : listMap.entrySet()) {
            switch (entry.getKey()) {
                case 0:
                case 1:
                case 4:
                    String fileType = entry.getValue().stream().map(CMCdnFiletypeTtl::getFileType)
                            .collect(Collectors.joining(","));
                    CMCdnFiletypeTtl filetypeTtl = entry.getValue().get(0);
                    filetypeTtl.setFileType(fileType);
                    filetypeTtls.add(filetypeTtl);
                    break;
                default:
                    filetypeTtls.addAll(entry.getValue());
                    break;
            }
        }
        return filetypeTtls;
    }

    private List<CMCdnErrorCode> buildErrorCodeList(List<CdnErrorPageVo> cdnErrorPageVos) {
        List<CMCdnErrorCode> errorCodes = new ArrayList<>();
        if (ObjectUtils.isEmpty(cdnErrorPageVos)) {
            // 传空数组[]代表删除
            return errorCodes;
        }
        cdnErrorPageVos.forEach(e -> {
            CMCdnErrorCode code = new CMCdnErrorCode();
            code.setCode(Stream.of(e.getErrorCode()).collect(Collectors.toList()));
            code.setTtl(e.getErrorCachingMinTtl().intValue());
        });
        return errorCodes;
    }

    private List<CMCdnCacheKeyArgs> buildCacheKeyArgsList(List<CdnSchedulerModel.DefaultSchedulerCdnCacheBehavior> cdnCacheBehaviors) {
        List<CMCdnCacheKeyArgs> cacheKeyArgs = new ArrayList<>();
        if (ObjectUtils.isEmpty(cdnCacheBehaviors)) {
            // 传空数组[]代表删除
            return cacheKeyArgs;
        }
        List<String> argsList = new ArrayList<>();
        cdnCacheBehaviors.forEach(e -> {
            // 行为
            CdnCacheBehaviorsForwardVo behaviorsForwardVo = e.getCdnCacheBehaviorsForward();
            if (new Integer(1).equals(behaviorsForwardVo.getQueryString())) {
                List<String> strings = JSON.parseArray(behaviorsForwardVo.getQueryStringCacheKeys()).toJavaList(String.class);
                argsList.addAll(strings);
            }
            if (new Integer(1).equals(behaviorsForwardVo.getHeaderType())) {
                List<String> strings = JSON.parseArray(behaviorsForwardVo.getHeader()).toJavaList(String.class);
                argsList.addAll(strings);
            }
        });
        if (ObjectUtils.isNotEmpty(argsList)) {
            CMCdnCacheKeyArgs args = new CMCdnCacheKeyArgs();
            args.setId(IdUtil.simpleUUID());
            args.setMode(0);
            args.setArgs(String.join(",", argsList));
            cacheKeyArgs.add(args);
        }
        return cacheKeyArgs;
    }

    private Map<String, List<CMCdnConditionContent>> buildCacheKeyArgsCondition(List<CMCdnFiletypeTtl> filetypeTtl,
                                                                                List<CMCdnCacheKeyArgs> cacheKeyArgs) {
        if (ObjectUtils.isEmpty(filetypeTtl)) {
            // 未传代表不修改
            return null;
        }
        Map<String, List<CMCdnConditionContent>> cacheKeyArgsCondition = new HashMap<>();
        if (ObjectUtils.isEmpty(cacheKeyArgs)) {
            // 传空对象{}代表删除
            return cacheKeyArgsCondition;
        }

        filetypeTtl.forEach(e -> {


        });


        cacheKeyArgs.forEach(e -> {


        });

        return cacheKeyArgsCondition;

    }

}
