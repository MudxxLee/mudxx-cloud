package net.agilewing.phoenix.cdn.impl.cm.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/20 11:30
 */
@ApiModel("请求参数-增量修改域名配置")
public class CMCdnDomainModifyRequest implements Serializable {
    private static final long serialVersionUID = -1204006283464079544L;

    /*--------------------------------------------------------------基本配置--------------------------------------------------------------*/

    @ApiModelProperty(value = "域名", required = true, position = -99)
    private String domain;

    @ApiModelProperty(value = "产品类型", notes = "支持产品类型", position = -98)
    @JSONField(name = "product_code")
    private String productCode;

    @ApiModelProperty(value = "ipv6 启用", notes = "未传代表不修改，1（启用）； 2（关闭）", position = -97)
    @JSONField(name = "ipv6_enable")
    private Integer ipv6Enable;

    @ApiModelProperty(value = "共享缓存域名", notes = "传空字符串\"\"代表删除，未传代表不修改" +
            "在域名配置了共享缓存的情况下，使用主域名或者任意一个关联域名来提交刷新任务，都可以刷掉缓存。", position = -96)
    @JSONField(name = "shared_host")
    private String sharedHost;

    @ApiModelProperty(value = "回源信息", notes = "传空数组[]代表删除，未传代表不修改，有传代表整个数组全量修改", position = -89)
    private List<CMCdnOriginSingle> origin;
    /*--------------------------------------------------------------基本配置--------------------------------------------------------------*/


    /*--------------------------------------------------------------HTTPS配置--------------------------------------------------------------*/

    @ApiModelProperty(value = "https是否开启", notes = "未传代表不修改，取值：on、off，取值为on时，cert_name为必传字段", position = -95)
    @JSONField(name = "https_status")
    private String httpsStatus;

    @ApiModelProperty(value = "证书备注名", notes = "未传代表不修改", position = -94)
    @JSONField(name = "cert_name")
    private String certName;

    @ApiModelProperty(value = "ssl协议类型", notes = "传空字符串\"\"代表删除，未传代表不修改，" +
            "支持TLSv1 、TLSv1.1 、TLSv1.2 、TLSv1.3，默认值为\"\"，支持多选，多个用英文逗号分隔", position = -93)
    private String ssl;

    @ApiModelProperty(value = "ssl_stapling开关", notes = "未传代表不修改，on（开启），off（关闭）", position = -92)
    @JSONField(name = "ssl_stapling")
    private String sslStapling;

    @ApiModelProperty(value = "https基础信息", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改", position = -91)
    @JSONField(name = "https_basic")
    private CMCdnHttpsBasic httpsBasic;

    @ApiModelProperty(value = "http配置基础信息", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改", position = -90)
    @JSONField(name = "basic_conf")
    private CMCdnHttpsBasicConf basicConf;
    /*--------------------------------------------------------------HTTPS配置--------------------------------------------------------------*/


    /*--------------------------------------------------------------回源配置--------------------------------------------------------------*/

    @ApiModelProperty(value = "回源host设置", notes = "传空字符串\"\"代表删除，未传代表不修改，默认用加速域名作为回源host", position = -88)
    @JSONField(name = "req_host")
    private String reqHost;

    @ApiModelProperty(value = "主备源携带不同的回源host是否开启", notes = "未传代表不修改，0（关闭） ；1（开启）。" +
            "假设当设置origin_host_type=1，回源host里req_host配置的值会被清空；然后以origin_host_http生效；" +
            "当origin_host_http中有配置相应源站对应的回源host，则以origin_host_http中为准；origin_host_http中没定制配置的源站 默认用加速域名作为回源host", position = -87)
    @JSONField(name = "origin_host_type")
    private Integer originHostType;

    @ApiModelProperty(value = "http类型origin带不同的回源host", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改" +
            "传参格式： {\"回源信息origin配置的主源域名/IP\":\"主源对应的回源host\",\"回源信息origin配置的备源域名/IP\":\"备源对应的回源host\"}", position = -86)
    @JSONField(name = "origin_host_http")
    private Map<String, String> originHostHttp;

    @ApiModelProperty(value = "自定义回源请求头", notes = "传空数组[]代表删除，未传代表不修改，有传代表整个数组全量修改", position = -84)
    @JSONField(name = "req_headers")
    private List<CMCdnReqHeaders> reqHeaders;
    /*--------------------------------------------------------------回源配置--------------------------------------------------------------*/


    /*--------------------------------------------------------------缓存配置--------------------------------------------------------------*/

    @ApiModelProperty(value = "缓存类型设置", notes = "传空数组[]代表删除，未传代表不修改，有传代表整个数组全量修改", position = -85)
    @JSONField(name = "filetype_ttl")
    private List<CMCdnFiletypeTtl> filetypeTtl;

    @ApiModelProperty(value = "错误状态码缓存", notes = "传空数组[]代表删除，未传代表不修改，有传代表整个数组全量修改", position = -82)
    @JSONField(name = "error_code")
    private List<CMCdnErrorCode> errorCode;

    @ApiModelProperty(value = "缓存参数", notes = "传空数组[]代表删除，未传代表不修改，有传代表整个数组全量修改")
    @JSONField(name = "cachekey_args")
    private List<CMCdnCacheKeyArgs> cacheKeyArgs;

    @ApiModelProperty(value = "cachekey_args的condition配置", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改，" +
            "格式:{\"key\":[{\"mode\":类型, \"content\":\"配置内容，多个以逗号间隔\"}]}, " +
            "mode取值:默认0, 0:文件后缀 1:目录 2: 首页 3: 全部文件 4:全路径。key为cachekey_args中的id，" +
            "本参数仅适用于类型为新框架的域名，旧框架域名修改不生效")
    @JSONField(name = "cachekey_args_condition")
    private Map<String, List<CMCdnConditionContent>> cacheKeyArgsCondition;
    /*--------------------------------------------------------------缓存配置--------------------------------------------------------------*/


    /*--------------------------------------------------------------访问控制--------------------------------------------------------------*/

    @ApiModelProperty(value = "referer黑名单", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改，黑白名单只允许存在一个，若同时存在只处理黑名单")
    @JSONField(name = "black_referer")
    private CMCdnBlackReferer blackReferer;

    @ApiModelProperty(value = "referer黑名单condition", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改，删除black_referer数据的话condition也要删除，" +
            "格式:{\"black_referer\":[{\"mode\":类型,\"content\":\"配置内容，多个以逗号间隔\"}]},mode取值:默认0, 0:文件后缀 1:目录 2: 首页 3: 全部文件 4: 全路径。")
    @JSONField(name = "black_referer_condition")
    private Map<String, List<CMCdnConditionContent>> blackRefererCondition;

    @ApiModelProperty(value = "referer白名单", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改")
    @JSONField(name = "white_referer")
    private CMCdnWhiteReferer whiteReferer;

    @ApiModelProperty(value = "referer白名单condition", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改，删除white_referer数据的话condition也要删除，" +
            "格式:{\"white_referer\":[{\"mode\":类型,\"content\":\"配置内容，多个以逗号间隔\"}]},mode取值:默认0, 0:文件后缀 1:目录 2: 首页 3: 全部文件 4: 全路径。")
    @JSONField(name = "white_referer_condition")
    private Map<String, List<CMCdnConditionContent>> whiteRefererCondition;

    @ApiModelProperty(value = "ip黑名单", notes = "传空字符串\"\"代表删除，未传代表不修改，黑白名单只允许存在一个，" +
            "若同时存在只处理黑名单,支持ip段与ip，多个ip/ip段以逗号分割，示例：1.1.1.1,2.2.2.2,::1,3.3.3.3-4.4.4.4")
    @JSONField(name = "ip_black_list")
    private String ipBlackList;

    @ApiModelProperty(value = "ip白名单", notes = "传空字符串\"\"代表删除，未传代表不修改，黑白名单只允许存在一个，" +
            "若同时存在只处理黑名单,支持ip段与ip，多个ip/ip段以逗号分割，示例：1.1.1.1,2.2.2.2,::1,3.3.3.3-4.4.4.4")
    @JSONField(name = "ip_white_list")
    private String ipWhiteList;

    @ApiModelProperty(value = "限频自助参数", notes = "若传空数组[]删除entry_limits参数时，若entry_limits_condition有值，也需要entry_limits_condition传空对象{}删除")
    @JSONField(name = "entry_limits")
    private List<CMCdnEntryLimits> entryLimits;

    @ApiModelProperty(value = "entry_limits的condition配置", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改，" +
            "格式:{\"key\":[{\"mode\":类型, \"content\":\"配置内容，多个以逗号间隔\"}]}, " +
            "mode取值:默认0, 0:文件后缀 1:目录 2: 首页 3: 全部文件 4:全路径。key为entry_limits中的id，" +
            "本参数仅适用于类型为新框架的域名，旧框架域名修改不生效")
    @JSONField(name = "entry_limits_condition")
    private Map<String, List<CMCdnConditionContent>> entryLimitsCondition;

    @ApiModelProperty(value = "远程同步鉴权客户自助", notes = "传空数组[]代表删除，未传代表不修改，有传代表整个数组全量修改")
    @JSONField(name = "remote_sync_auth")
    private List<CMCdnRemoteSyncAuth> remoteSyncAuth;

    @ApiModelProperty(value = "remote_sync_auth的condition配置", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改，" +
            "格式:{\"key\":[{\"mode\":类型, \"content\":\"配置内容，多个以逗号间隔\"}]}, " +
            "mode类型为int，取值默认0,可以为：0(文件后缀),1(目录),2(首页),3(全部文件),4(全路径),key为remote_sync_auth中的id")
    @JSONField(name = "remote_sync_auth_condition")
    private Map<String, List<CMCdnConditionContent>> remoteSyncAuthCondition;
    /*--------------------------------------------------------------访问控制--------------------------------------------------------------*/


    /*--------------------------------------------------------------高级配置--------------------------------------------------------------*/

    @ApiModelProperty(value = "自定义响应请求头", notes = "传空数组[]代表删除，未传代表不修改，有传代表整个数组全量修改", position = -83)
    @JSONField(name = "resp_headers")
    private List<CMCdnRespHeaders> respHeaders;

    @ApiModelProperty(value = "文件压缩", notes = "传空数组[]代表删除，未传代表不修改，有传代表整个数组全量修改，" +
            "字段cus_gzip_single详细说明见下方，原来文件压缩的字段为gzip字段，现改成cus_gzip，两参数不能同时传，若之前用的是gzip字段建议迁移至cus_gzip")
    @JSONField(name = "cus_gzip")
    private List<CMCdnCusGzip> cusGzip;

    @ApiModelProperty(value = "cus_gzip的condition配置", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改，" +
            "格式:{\"key\":[{\"mode\":类型, \"content\":\"配置内容，多个以逗号间隔\"}]}, " +
            "mode取值:默认0, 0:文件后缀  1:目录  2:  首页  3:  全部文件  4:全路径。key为cus_gzip中的id，" +
            "本参数仅适用于类型为新框架的域名，旧框架域名修改不生效，且修改本参数时，cus_gzip必传")
    @JSONField(name = "cus_gzip_condition")
    private Map<String, List<CMCdnConditionContent>> cusGzipCondition;

    @ApiModelProperty(value = "基于url参数限速", notes = "传空数组[]代表删除，未传代表不修改，有传代表整个数组全量修改")
    @JSONField(name = "limit_speed_uri")
    private List<CMCdnLimitSpeedUri> limitSpeedUri;

    @ApiModelProperty(value = "limit_speed_uri的condition配置", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改，" +
            "格式:{\"{key}\":[{\"mode\":类型,\"content\":\"配置内容，多个以逗号间隔\"}]}，" +
            "mode类型为int，取值默认0,可以为：0(文件后缀),1(目录), 2(首页),3(全部文件),4(全路径),key为limit_speed_uri中的id." +
            "使用限制：一个key对应的数组大小只能是1，因为配置平台实际只支持配置一条；content必填，长度大于0，不能为空字符串或者空白字符串")
    @JSONField(name = "limit_speed_uri_condition")
    private Map<String, List<CMCdnConditionContent>> limitSpeedUriCondition;

    @ApiModelProperty(value = "基于固定值限速", notes = "传空数组[]代表删除，未传代表不修改，有传代表整个数组全量修改")
    @JSONField(name = "limit_speed_const")
    private List<CMCdnLimitSpeedConst> limitSpeedConst;

    @ApiModelProperty(value = "limit_speed_const的condition配置", notes = "传空对象{}代表删除，未传代表不修改，有传代表整个dict全量修改，" +
            "格式:{\"{key}\":[{\"mode\":类型,\"content\":\"配置内容，多个以逗号间隔\"}]}，" +
            "mode类型为int，取值默认0,可以为：0(文件后缀),1(目录), 2(首页),3(全部文件),4(全路径),key为limit_speed_const中的id。" +
            "使用限制：一个key对应的数组大小只能是1，因为配置平台实际只支持配置一条；content必填，长度大于0，不能为空字符串或者空白字符串")
    @JSONField(name = "limit_speed_const_condition")
    private Map<String, List<CMCdnConditionContent>> limitSpeedConstCondition;
    /*--------------------------------------------------------------高级配置--------------------------------------------------------------*/


    public CMCdnDomainModifyRequest() {
    }

    private CMCdnDomainModifyRequest(Builder builder) {
        setDomain(builder.domain);
        setProductCode(builder.productCode);
        setIpv6Enable(builder.ipv6Enable);
        setSharedHost(builder.sharedHost);
        setHttpsStatus(builder.httpsStatus);
        setCertName(builder.certName);
        setHttpsBasic(builder.httpsBasic);
        setBasicConf(builder.basicConf);
        setOrigin(builder.origin);
        setReqHost(builder.reqHost);
        setOriginHostType(builder.originHostType);
        setOriginHostHttp(builder.originHostHttp);
        setFiletypeTtl(builder.filetypeTtl);
        setBlackReferer(builder.blackReferer);
        setBlackRefererCondition(builder.blackRefererCondition);
        setWhiteReferer(builder.whiteReferer);
        setWhiteRefererCondition(builder.whiteRefererCondition);
        setIpBlackList(builder.ipBlackList);
        setIpWhiteList(builder.ipWhiteList);
        setReqHeaders(builder.reqHeaders);
        setRespHeaders(builder.respHeaders);
        setErrorCode(builder.errorCode);
        setLimitSpeedUri(builder.limitSpeedUri);
        setLimitSpeedUriCondition(builder.limitSpeedUriCondition);
        setLimitSpeedConst(builder.limitSpeedConst);
        setLimitSpeedConstCondition(builder.limitSpeedConstCondition);
        setRemoteSyncAuth(builder.remoteSyncAuth);
        setRemoteSyncAuthCondition(builder.remoteSyncAuthCondition);
        setSsl(builder.ssl);
        setSslStapling(builder.sslStapling);
        setCusGzip(builder.cusGzip);
        setCusGzipCondition(builder.cusGzipCondition);
        setEntryLimits(builder.entryLimits);
        setEntryLimitsCondition(builder.entryLimitsCondition);
        setCacheKeyArgs(builder.cacheKeyArgs);
        setCacheKeyArgsCondition(builder.cacheKeyArgsCondition);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getIpv6Enable() {
        return ipv6Enable;
    }

    public void setIpv6Enable(Integer ipv6Enable) {
        this.ipv6Enable = ipv6Enable;
    }

    public String getSharedHost() {
        return sharedHost;
    }

    public void setSharedHost(String sharedHost) {
        this.sharedHost = sharedHost;
    }

    public String getHttpsStatus() {
        return httpsStatus;
    }

    public void setHttpsStatus(String httpsStatus) {
        this.httpsStatus = httpsStatus;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public CMCdnHttpsBasic getHttpsBasic() {
        return httpsBasic;
    }

    public void setHttpsBasic(CMCdnHttpsBasic httpsBasic) {
        this.httpsBasic = httpsBasic;
    }

    public CMCdnHttpsBasicConf getBasicConf() {
        return basicConf;
    }

    public void setBasicConf(CMCdnHttpsBasicConf basicConf) {
        this.basicConf = basicConf;
    }

    public List<CMCdnOriginSingle> getOrigin() {
        return origin;
    }

    public void setOrigin(List<CMCdnOriginSingle> origin) {
        this.origin = origin;
    }

    public String getReqHost() {
        return reqHost;
    }

    public void setReqHost(String reqHost) {
        this.reqHost = reqHost;
    }

    public Integer getOriginHostType() {
        return originHostType;
    }

    public void setOriginHostType(Integer originHostType) {
        this.originHostType = originHostType;
    }

    public Map<String, String> getOriginHostHttp() {
        return originHostHttp;
    }

    public void setOriginHostHttp(Map<String, String> originHostHttp) {
        this.originHostHttp = originHostHttp;
    }

    public List<CMCdnFiletypeTtl> getFiletypeTtl() {
        return filetypeTtl;
    }

    public void setFiletypeTtl(List<CMCdnFiletypeTtl> filetypeTtl) {
        this.filetypeTtl = filetypeTtl;
    }

    public CMCdnBlackReferer getBlackReferer() {
        return blackReferer;
    }

    public void setBlackReferer(CMCdnBlackReferer blackReferer) {
        this.blackReferer = blackReferer;
    }

    public Map<String, List<CMCdnConditionContent>> getBlackRefererCondition() {
        return blackRefererCondition;
    }

    public void setBlackRefererCondition(Map<String, List<CMCdnConditionContent>> blackRefererCondition) {
        this.blackRefererCondition = blackRefererCondition;
    }

    public CMCdnWhiteReferer getWhiteReferer() {
        return whiteReferer;
    }

    public void setWhiteReferer(CMCdnWhiteReferer whiteReferer) {
        this.whiteReferer = whiteReferer;
    }

    public Map<String, List<CMCdnConditionContent>> getWhiteRefererCondition() {
        return whiteRefererCondition;
    }

    public void setWhiteRefererCondition(Map<String, List<CMCdnConditionContent>> whiteRefererCondition) {
        this.whiteRefererCondition = whiteRefererCondition;
    }

    public String getIpBlackList() {
        return ipBlackList;
    }

    public void setIpBlackList(String ipBlackList) {
        this.ipBlackList = ipBlackList;
    }

    public String getIpWhiteList() {
        return ipWhiteList;
    }

    public void setIpWhiteList(String ipWhiteList) {
        this.ipWhiteList = ipWhiteList;
    }

    public List<CMCdnReqHeaders> getReqHeaders() {
        return reqHeaders;
    }

    public void setReqHeaders(List<CMCdnReqHeaders> reqHeaders) {
        this.reqHeaders = reqHeaders;
    }

    public List<CMCdnRespHeaders> getRespHeaders() {
        return respHeaders;
    }

    public void setRespHeaders(List<CMCdnRespHeaders> respHeaders) {
        this.respHeaders = respHeaders;
    }

    public List<CMCdnErrorCode> getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(List<CMCdnErrorCode> errorCode) {
        this.errorCode = errorCode;
    }

    public List<CMCdnLimitSpeedUri> getLimitSpeedUri() {
        return limitSpeedUri;
    }

    public void setLimitSpeedUri(List<CMCdnLimitSpeedUri> limitSpeedUri) {
        this.limitSpeedUri = limitSpeedUri;
    }

    public Map<String, List<CMCdnConditionContent>> getLimitSpeedUriCondition() {
        return limitSpeedUriCondition;
    }

    public void setLimitSpeedUriCondition(Map<String, List<CMCdnConditionContent>> limitSpeedUriCondition) {
        this.limitSpeedUriCondition = limitSpeedUriCondition;
    }

    public List<CMCdnLimitSpeedConst> getLimitSpeedConst() {
        return limitSpeedConst;
    }

    public void setLimitSpeedConst(List<CMCdnLimitSpeedConst> limitSpeedConst) {
        this.limitSpeedConst = limitSpeedConst;
    }

    public Map<String, List<CMCdnConditionContent>> getLimitSpeedConstCondition() {
        return limitSpeedConstCondition;
    }

    public void setLimitSpeedConstCondition(Map<String, List<CMCdnConditionContent>> limitSpeedConstCondition) {
        this.limitSpeedConstCondition = limitSpeedConstCondition;
    }

    public List<CMCdnRemoteSyncAuth> getRemoteSyncAuth() {
        return remoteSyncAuth;
    }

    public void setRemoteSyncAuth(List<CMCdnRemoteSyncAuth> remoteSyncAuth) {
        this.remoteSyncAuth = remoteSyncAuth;
    }

    public Map<String, List<CMCdnConditionContent>> getRemoteSyncAuthCondition() {
        return remoteSyncAuthCondition;
    }

    public void setRemoteSyncAuthCondition(Map<String, List<CMCdnConditionContent>> remoteSyncAuthCondition) {
        this.remoteSyncAuthCondition = remoteSyncAuthCondition;
    }

    public String getSsl() {
        return ssl;
    }

    public void setSsl(String ssl) {
        this.ssl = ssl;
    }

    public String getSslStapling() {
        return sslStapling;
    }

    public void setSslStapling(String sslStapling) {
        this.sslStapling = sslStapling;
    }

    public List<CMCdnCusGzip> getCusGzip() {
        return cusGzip;
    }

    public void setCusGzip(List<CMCdnCusGzip> cusGzip) {
        this.cusGzip = cusGzip;
    }

    public Map<String, List<CMCdnConditionContent>> getCusGzipCondition() {
        return cusGzipCondition;
    }

    public void setCusGzipCondition(Map<String, List<CMCdnConditionContent>> cusGzipCondition) {
        this.cusGzipCondition = cusGzipCondition;
    }

    public List<CMCdnEntryLimits> getEntryLimits() {
        return entryLimits;
    }

    public void setEntryLimits(List<CMCdnEntryLimits> entryLimits) {
        this.entryLimits = entryLimits;
    }

    public Map<String, List<CMCdnConditionContent>> getEntryLimitsCondition() {
        return entryLimitsCondition;
    }

    public void setEntryLimitsCondition(Map<String, List<CMCdnConditionContent>> entryLimitsCondition) {
        this.entryLimitsCondition = entryLimitsCondition;
    }

    public List<CMCdnCacheKeyArgs> getCacheKeyArgs() {
        return cacheKeyArgs;
    }

    public void setCacheKeyArgs(List<CMCdnCacheKeyArgs> cacheKeyArgs) {
        this.cacheKeyArgs = cacheKeyArgs;
    }

    public Map<String, List<CMCdnConditionContent>> getCacheKeyArgsCondition() {
        return cacheKeyArgsCondition;
    }

    public void setCacheKeyArgsCondition(Map<String, List<CMCdnConditionContent>> cacheKeyArgsCondition) {
        this.cacheKeyArgsCondition = cacheKeyArgsCondition;
    }

    public static final class Builder {
        private String domain;
        private String productCode;
        private Integer ipv6Enable;
        private String sharedHost;
        private String httpsStatus;
        private String certName;
        private CMCdnHttpsBasic httpsBasic;
        private CMCdnHttpsBasicConf basicConf;
        private List<CMCdnOriginSingle> origin;
        private String reqHost;
        private Integer originHostType;
        private Map<String, String> originHostHttp;
        private List<CMCdnFiletypeTtl> filetypeTtl;
        private CMCdnBlackReferer blackReferer;
        private Map<String, List<CMCdnConditionContent>> blackRefererCondition;
        private CMCdnWhiteReferer whiteReferer;
        private Map<String, List<CMCdnConditionContent>> whiteRefererCondition;
        private String ipBlackList;
        private String ipWhiteList;
        private List<CMCdnReqHeaders> reqHeaders;
        private List<CMCdnRespHeaders> respHeaders;
        private List<CMCdnErrorCode> errorCode;
        private List<CMCdnLimitSpeedUri> limitSpeedUri;
        private Map<String, List<CMCdnConditionContent>> limitSpeedUriCondition;
        private List<CMCdnLimitSpeedConst> limitSpeedConst;
        private Map<String, List<CMCdnConditionContent>> limitSpeedConstCondition;
        private List<CMCdnRemoteSyncAuth> remoteSyncAuth;
        private Map<String, List<CMCdnConditionContent>> remoteSyncAuthCondition;
        private String ssl;
        private String sslStapling;
        private List<CMCdnCusGzip> cusGzip;
        private Map<String, List<CMCdnConditionContent>> cusGzipCondition;
        private List<CMCdnEntryLimits> entryLimits;
        private Map<String, List<CMCdnConditionContent>> entryLimitsCondition;
        private List<CMCdnCacheKeyArgs> cacheKeyArgs;
        private Map<String, List<CMCdnConditionContent>> cacheKeyArgsCondition;

        public Builder() {
        }

        public Builder domain(String val) {
            domain = val;
            return this;
        }

        public Builder productCode(String val) {
            productCode = val;
            return this;
        }

        public Builder ipv6Enable(Integer val) {
            ipv6Enable = val;
            return this;
        }

        public Builder sharedHost(String val) {
            sharedHost = val;
            return this;
        }

        public Builder httpsStatus(String val) {
            httpsStatus = val;
            return this;
        }

        public Builder certName(String val) {
            certName = val;
            return this;
        }

        public Builder httpsBasic(CMCdnHttpsBasic val) {
            httpsBasic = val;
            return this;
        }

        public Builder basicConf(CMCdnHttpsBasicConf val) {
            basicConf = val;
            return this;
        }

        public Builder origin(List<CMCdnOriginSingle> val) {
            origin = val;
            return this;
        }

        public Builder reqHost(String val) {
            reqHost = val;
            return this;
        }

        public Builder originHostType(Integer val) {
            originHostType = val;
            return this;
        }

        public Builder originHostHttp(Map<String, String> val) {
            originHostHttp = val;
            return this;
        }

        public Builder filetypeTtl(List<CMCdnFiletypeTtl> val) {
            filetypeTtl = val;
            return this;
        }

        public Builder blackReferer(CMCdnBlackReferer val) {
            blackReferer = val;
            return this;
        }

        public Builder blackRefererCondition(Map<String, List<CMCdnConditionContent>> val) {
            blackRefererCondition = val;
            return this;
        }

        public Builder whiteReferer(CMCdnWhiteReferer val) {
            whiteReferer = val;
            return this;
        }

        public Builder whiteRefererCondition(Map<String, List<CMCdnConditionContent>> val) {
            whiteRefererCondition = val;
            return this;
        }

        public Builder ipBlackList(String val) {
            ipBlackList = val;
            return this;
        }

        public Builder ipWhiteList(String val) {
            ipWhiteList = val;
            return this;
        }

        public Builder reqHeaders(List<CMCdnReqHeaders> val) {
            reqHeaders = val;
            return this;
        }

        public Builder respHeaders(List<CMCdnRespHeaders> val) {
            respHeaders = val;
            return this;
        }

        public Builder errorCode(List<CMCdnErrorCode> val) {
            errorCode = val;
            return this;
        }

        public Builder limitSpeedUri(List<CMCdnLimitSpeedUri> val) {
            limitSpeedUri = val;
            return this;
        }

        public Builder limitSpeedUriCondition(Map<String, List<CMCdnConditionContent>> val) {
            limitSpeedUriCondition = val;
            return this;
        }

        public Builder limitSpeedConst(List<CMCdnLimitSpeedConst> val) {
            limitSpeedConst = val;
            return this;
        }

        public Builder limitSpeedConstCondition(Map<String, List<CMCdnConditionContent>> val) {
            limitSpeedConstCondition = val;
            return this;
        }

        public Builder remoteSyncAuth(List<CMCdnRemoteSyncAuth> val) {
            remoteSyncAuth = val;
            return this;
        }

        public Builder remoteSyncAuthCondition(Map<String, List<CMCdnConditionContent>> val) {
            remoteSyncAuthCondition = val;
            return this;
        }

        public Builder ssl(String val) {
            ssl = val;
            return this;
        }

        public Builder sslStapling(String val) {
            sslStapling = val;
            return this;
        }

        public Builder cusGzip(List<CMCdnCusGzip> val) {
            cusGzip = val;
            return this;
        }

        public Builder cusGzipCondition(Map<String, List<CMCdnConditionContent>> val) {
            cusGzipCondition = val;
            return this;
        }

        public Builder entryLimits(List<CMCdnEntryLimits> val) {
            entryLimits = val;
            return this;
        }

        public Builder entryLimitsCondition(Map<String, List<CMCdnConditionContent>> val) {
            entryLimitsCondition = val;
            return this;
        }

        public Builder cacheKeyArgs(List<CMCdnCacheKeyArgs> val) {
            cacheKeyArgs = val;
            return this;
        }

        public Builder cacheKeyArgsCondition(Map<String, List<CMCdnConditionContent>> val) {
            cacheKeyArgsCondition = val;
            return this;
        }

        public CMCdnDomainModifyRequest build() {
            return new CMCdnDomainModifyRequest(this);
        }
    }
}
