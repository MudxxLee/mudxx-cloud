package net.agilewing.phoenix.cdn.impl.cm.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
@ApiModel("请求响应-查询域名配置信息")
public class CMCdnDomainGetResponse extends CMResponse {
    private static final long serialVersionUID = 5316669945009386300L;

    @ApiModelProperty(value = "域名")
    private String domain;

    @ApiModelProperty(value = "CNAME记录")
    private String cname;

    @ApiModelProperty(value = "备案号")
    @JSONField(name = "record_num")
    private String recordNum;

    @ApiModelProperty(value = "备案号状态", notes = "false（未备案）；ture（已备案）")
    @JSONField(name = "record_status")
    private String recordStatus;

    @ApiModelProperty(value = "域名状态", notes = "4（已启用）；6（已停止）。域名详情只返回域名的确定状态，过程中的状态不会返回")
    private Integer status;

    @ApiModelProperty(value = "产品类型")
    @JSONField(name = "product_code")
    private String productCode;

    @ApiModelProperty(value = "ipv6 启用")
    @JSONField(name = "ipv6_enable")
    private Integer ipv6Enable;

    @ApiModelProperty(value = "加速范围")
    @JSONField(name = "area_scope")
    private Integer areaScope;

    @ApiModelProperty(value = "共享缓存域名")
    @JSONField(name = "shared_host")
    private String sharedHost;

    @ApiModelProperty(value = "https是否开启")
    @JSONField(name = "https_status")
    private String httpsStatus;

    @ApiModelProperty(value = "证书备注名")
    @JSONField(name = "cert_name")
    private String certName;

    @ApiModelProperty(value = "https基础信息")
    @JSONField(name = "https_basic")
    private CMCdnHttpsBasic httpsBasic;

    @ApiModelProperty(value = "http配置基础信息")
    @JSONField(name = "basic_conf")
    private CMCdnHttpsBasicConf basicConf;

    @ApiModelProperty(value = "回源信息")
    private List<CMCdnOriginSingle> origin;

    @ApiModelProperty(value = "回源host设置")
    @JSONField(name = "req_host")
    private String reqHost;

    @ApiModelProperty(value = "主备源携带不同的回源host是否开启")
    @JSONField(name = "origin_host_type")
    private Integer originHostType;

    @ApiModelProperty(value = "http类型origin带不同的回源host")
    @JSONField(name = "origin_host_http")
    private Map<String, String> originHostHttp;

    @ApiModelProperty(value = "回源协议")
    @JSONField(name = "origin_protocol")
    private String originProtocol;

    @ApiModelProperty(value = "缓存类型设置", notes = "传空数组[]代表删除，未传代表不修改，有传代表整个数组全量修改")
    @JSONField(name = "filetype_ttl")
    private List<CMCdnFiletypeTtl> filetypeTtl;

    @ApiModelProperty(value = "referer黑名单")
    @JSONField(name = "black_referer")
    private CMCdnBlackReferer blackReferer;

    @ApiModelProperty(value = "referer黑名单condition")
    @JSONField(name = "black_referer_condition")
    private Map<String, String> blackRefererCondition;

    @ApiModelProperty(value = "referer白名单")
    @JSONField(name = "white_referer")
    private CMCdnBlackReferer whiteReferer;

    @ApiModelProperty(value = "referer白名单condition")
    @JSONField(name = "white_referer_condition")
    private Map<String, String> whiteRefererCondition;

    @ApiModelProperty(value = "ip黑名单")
    @JSONField(name = "ip_black_list")
    private String ipBlackList;

    @ApiModelProperty(value = "ip白名单")
    @JSONField(name = "ip_white_list")
    private String ipWhiteList;

    @ApiModelProperty(value = "自定义回源请求头")
    @JSONField(name = "req_headers")
    private List<CMCdnReqHeaders> reqHeaders;

    @ApiModelProperty(value = "自定义响应请求头")
    @JSONField(name = "resp_headers")
    private List<CMCdnRespHeaders> respHeaders;

    @ApiModelProperty(value = "错误状态码缓存")
    @JSONField(name = "error_code")
    private List<CMCdnErrorCode> errorCode;

    @ApiModelProperty(value = "基于url参数限速")
    @JSONField(name = "limit_speed_uri")
    private List<CMCdnLimitSpeedUri> limitSpeedUri;

    @ApiModelProperty(value = "limit_speed_uri的condition配置")
    @JSONField(name = "limit_speed_uri_condition")
    private Map<String, List<CMCdnConditionContent>> limitSpeedUriCondition;

    @ApiModelProperty(value = "基于固定值限速")
    @JSONField(name = "limit_speed_const")
    private List<CMCdnLimitSpeedConst> limitSpeedConst;

    @ApiModelProperty(value = "limit_speed_const的condition配置")
    @JSONField(name = "limit_speed_const_condition")
    private Map<String, List<CMCdnConditionContent>> limitSpeedConstCondition;

    @ApiModelProperty(value = "远程同步鉴权客户自助")
    @JSONField(name = "remote_sync_auth")
    private List<CMCdnRemoteSyncAuth> remoteSyncAuth;

    @ApiModelProperty(value = "remote_sync_auth的condition配置")
    @JSONField(name = "remote_sync_auth_condition")
    private Map<String, List<CMCdnConditionContent>> remoteSyncAuthCondition;

    @ApiModelProperty(value = "ssl协议类型")
    private String ssl;

    @ApiModelProperty(value = "ssl_stapling开关")
    @JSONField(name = "ssl_stapling")
    private String sslStapling;

    @ApiModelProperty(value = "文件压缩")
    @JSONField(name = "cus_gzip")
    private List<CMCdnCusGzip> cusGzip;

    @ApiModelProperty(value = "cus_gzip的condition配置")
    @JSONField(name = "cus_gzip_condition")
    private Map<String, List<CMCdnConditionContent>> cusGzipCondition;

    @ApiModelProperty(value = "限频自助参数")
    @JSONField(name = "entry_limits")
    private List<CMCdnEntryLimits> entryLimits;

    @ApiModelProperty(value = "entry_limits的condition配置")
    @JSONField(name = "entry_limits_condition")
    private Map<String, List<CMCdnConditionContent>> entryLimitsCondition;

    @ApiModelProperty(value = "缓存参数")
    @JSONField(name = "cachekey_args")
    private List<CMCdnCacheKeyArgs> cacheKeyArgs;

    @ApiModelProperty(value = "cachekey_args的condition配置")
    @JSONField(name = "cachekey_args_condition")
    private Map<String, List<CMCdnConditionContent>> cacheKeyArgsCondition;

    @ApiModelProperty(value = "md5安全时间")
    @JSONField(name = "md5_secure_time")
    private List<CMCdnMd5SecureTime> md5SecureTime;

    @ApiModelProperty(value = "md5_secure_time的condition配置")
    @JSONField(name = "md5_secure_time_condition")
    private Map<String, List<CMCdnConditionContent>> md5SecureTimeCondition;

    @ApiModelProperty(value = "回源uri重写")
    @JSONField(name = "backorigin_uri_rewrite")
    private List<Object> backoriginUriRewrite;

    @ApiModelProperty(value = "backorigin_uri_rewrite的condition配置")
    @JSONField(name = "backorigin_uri_rewrite_condition")
    private Map<String, List<CMCdnConditionContent>> backoriginUriRewriteCondition;

    @ApiModelProperty(value = "gzip")
    private CMCdnGzip gzip;

    @ApiModelProperty(value = "gzip的condition配置")
    @JSONField(name = "gzip_condition")
    private Map<String, List<CMCdnConditionContent>> gzipCondition;

    @ApiModelProperty(value = "黑白名单配置")
    @JSONField(name = "user_agent")
    private CMCdnUserAgent userAgent;

    @ApiModelProperty(value = "创建时间，单位毫秒")
    @JSONField(name = "insert_date")
    private String insertDate;

    @ApiModelProperty(value = "修改时间，单位毫秒")
    @JSONField(name = "status_date")
    private String statusDate;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getAreaScope() {
        return areaScope;
    }

    public void setAreaScope(Integer areaScope) {
        this.areaScope = areaScope;
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

    public String getOriginProtocol() {
        return originProtocol;
    }

    public void setOriginProtocol(String originProtocol) {
        this.originProtocol = originProtocol;
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

    public Map<String, String> getBlackRefererCondition() {
        return blackRefererCondition;
    }

    public void setBlackRefererCondition(Map<String, String> blackRefererCondition) {
        this.blackRefererCondition = blackRefererCondition;
    }

    public CMCdnBlackReferer getWhiteReferer() {
        return whiteReferer;
    }

    public void setWhiteReferer(CMCdnBlackReferer whiteReferer) {
        this.whiteReferer = whiteReferer;
    }

    public Map<String, String> getWhiteRefererCondition() {
        return whiteRefererCondition;
    }

    public void setWhiteRefererCondition(Map<String, String> whiteRefererCondition) {
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

    public List<CMCdnMd5SecureTime> getMd5SecureTime() {
        return md5SecureTime;
    }

    public void setMd5SecureTime(List<CMCdnMd5SecureTime> md5SecureTime) {
        this.md5SecureTime = md5SecureTime;
    }

    public Map<String, List<CMCdnConditionContent>> getMd5SecureTimeCondition() {
        return md5SecureTimeCondition;
    }

    public void setMd5SecureTimeCondition(Map<String, List<CMCdnConditionContent>> md5SecureTimeCondition) {
        this.md5SecureTimeCondition = md5SecureTimeCondition;
    }

    public List<Object> getBackoriginUriRewrite() {
        return backoriginUriRewrite;
    }

    public void setBackoriginUriRewrite(List<Object> backoriginUriRewrite) {
        this.backoriginUriRewrite = backoriginUriRewrite;
    }

    public Map<String, List<CMCdnConditionContent>> getBackoriginUriRewriteCondition() {
        return backoriginUriRewriteCondition;
    }

    public void setBackoriginUriRewriteCondition(Map<String, List<CMCdnConditionContent>> backoriginUriRewriteCondition) {
        this.backoriginUriRewriteCondition = backoriginUriRewriteCondition;
    }

    public CMCdnGzip getGzip() {
        return gzip;
    }

    public void setGzip(CMCdnGzip gzip) {
        this.gzip = gzip;
    }

    public Map<String, List<CMCdnConditionContent>> getGzipCondition() {
        return gzipCondition;
    }

    public void setGzipCondition(Map<String, List<CMCdnConditionContent>> gzipCondition) {
        this.gzipCondition = gzipCondition;
    }

    public CMCdnUserAgent getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(CMCdnUserAgent userAgent) {
        this.userAgent = userAgent;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }
}

