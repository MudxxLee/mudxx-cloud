package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-远程同步鉴权客户自助信息")
public class CMCdnRemoteSyncAuth implements Serializable {
    private static final long serialVersionUID = -7714449214746301565L;

    @ApiModelProperty(value = "请求体", notes = "默认为空\"\"，请求方法为POST才生效")
    @JSONField(name = "auth_body_data")
    private String authBodyData;

    @ApiModelProperty(value = "连接空闲超时时间")
    @JSONField(name = "auth_connection_idle_time")
    private Integer authConnectionIdleTime;

    @ApiModelProperty(value = "鉴权服务端连接池大小")
    @JSONField(name = "auth_connection_pool_size")
    private Integer authConnectionPoolSize;

    @ApiModelProperty(value = "鉴权出错是否通过", notes = "取值：on：是，off：否")
    @JSONField(name = "auth_error_pass")
    private String authErrorPass;

    @ApiModelProperty(value = "鉴权源站", required = true, notes = "ip或者域名")
    @JSONField(name = "auth_host")
    private List<String> authHost;

    @ApiModelProperty(value = "请求方法", notes = "取值为：GET/POST/HEAD/OPTIONS，如选择POST，显示“请求体”输入框")
    @JSONField(name = "auth_method")
    private String authMethod;

    @ApiModelProperty(value = "请求端口", notes = "请求端口，http默认80，https默认443")
    @JSONField(name = "auth_port")
    private Integer authPort;

    @ApiModelProperty(value = "鉴权状态码黑白名单", notes = "鉴权状态码黑白名单,(白名单 “allow”或黑名单 “deny”)，默认deny")
    @JSONField(name = "auth_respond_action")
    private String authRespondAction;

    @ApiModelProperty(value = "状态码", notes = "可以为空")
    @JSONField(name = "auth_respond_status")
    private List<Integer> authRespondStatus;

    @ApiModelProperty(value = "请求协议", notes = "默认http,值为http/https")
    @JSONField(name = "auth_scheme")
    private String authScheme;

    @ApiModelProperty(value = "鉴权超时时间", notes = "鉴权设置，鉴权超时时间，单位秒，支持输入毫秒，最大值3600秒，小数位数最大3位")
    @JSONField(name = "auth_timeout")
    private Float authTimeout;

    @ApiModelProperty(value = "鉴权超时是否通过", notes = "鉴权逻辑,鉴权超时是否通过,取值：on：是，off：否")
    @JSONField(name = "auth_timeout_pass")
    private String authTimeoutPass;

    @ApiModelProperty(value = "固定状态码", notes = "当上面鉴权不通过时状态码设置为固定状态码的时候必填")
    @JSONField(name = "forbidden_code")
    private Integer forbiddenCode;

    @ApiModelProperty(value = "鉴权不通过时状态码设置", notes = "鉴权不通过时状态码设置，(跟随鉴权源站follow/固定状态码regular)，默认\"follow\"")
    @JSONField(name = "forbidden_code_state")
    private String forbiddenCodeState;

    @ApiModelProperty(value = "远程同步鉴权客户自助", required = true, notes = "主键id，condition使用")
    private String id;

    @ApiModelProperty(value = "pattern", notes = "鉴权请求uri，默认空")
    private String pattern;

    @ApiModelProperty(value = "优先级", notes = "默认10")
    private Integer priority;

    @ApiModelProperty(value = "replace", notes = "鉴权请求uri，默认空")
    private Integer replace;

    @ApiModelProperty(value = "基于json鉴权")
    @JSONField(name = "response_json_to_var")
    private CMCdnResponseJsonToVar responseJsonToVar;

    @ApiModelProperty(value = "subject", notes = "鉴权请求uri，默认值$uri")
    private String subject;

    @ApiModelProperty(value = "鉴权源站重试状态码", notes = "底层默认默认^5.+")
    @JSONField(name = "try_next_remote_server_when")
    private String tryNextRemoteServerWhen;

    @ApiModelProperty(value = "请求参数", notes = "可以为空")
    @JSONField(name = "use_main_request_args")
    private List<CMCdnUseMainRequestArgs> useMainRequestArgs;

    @ApiModelProperty(value = "使用原始请求参数类型", notes = "当上面是否使用原始请求参数选择否的时候，必填，" +
            "取值：继承并修改原参数inherit/全面替换原参数replace，默认继承")
    @JSONField(name = "use_main_request_args_type")
    private String useMainRequestArgsType;

    @ApiModelProperty(value = "请求头", notes = "可以为空")
    @JSONField(name = "use_main_request_headers")
    private List<CMCdnUseMainRequestHeaders> useMainRequestHeaders;

    @ApiModelProperty(value = "使用原始请求参数类型", notes = "当上面是否使用原始请求头选择否的时候，必填，" +
            "取值：继承并修改原参数inherit/全面替换原参数replace，默认继承")
    @JSONField(name = "use_main_request_headers_type")
    private String useMainRequestHeadersType;

    @ApiModelProperty(value = "是否使用原始请求参数", notes = "鉴权请求参数：是否使用原始请求参数，取值：on /off，没值不传，后端默认是")
    @JSONField(name = "use_original_request_args")
    private String useOriginalRequestArgs;

    @ApiModelProperty(value = "是否使用原始请求头", notes = "鉴权请求头：是否使用原始请求参数，取值：on /off，没值不传，后端默认是")
    @JSONField(name = "use_original_request_headers")
    private String useOriginalRequestHeaders;

    public String getAuthBodyData() {
        return authBodyData;
    }

    public void setAuthBodyData(String authBodyData) {
        this.authBodyData = authBodyData;
    }

    public Integer getAuthConnectionIdleTime() {
        return authConnectionIdleTime;
    }

    public void setAuthConnectionIdleTime(Integer authConnectionIdleTime) {
        this.authConnectionIdleTime = authConnectionIdleTime;
    }

    public Integer getAuthConnectionPoolSize() {
        return authConnectionPoolSize;
    }

    public void setAuthConnectionPoolSize(Integer authConnectionPoolSize) {
        this.authConnectionPoolSize = authConnectionPoolSize;
    }

    public String getAuthErrorPass() {
        return authErrorPass;
    }

    public void setAuthErrorPass(String authErrorPass) {
        this.authErrorPass = authErrorPass;
    }

    public List<String> getAuthHost() {
        return authHost;
    }

    public void setAuthHost(List<String> authHost) {
        this.authHost = authHost;
    }

    public String getAuthMethod() {
        return authMethod;
    }

    public void setAuthMethod(String authMethod) {
        this.authMethod = authMethod;
    }

    public Integer getAuthPort() {
        return authPort;
    }

    public void setAuthPort(Integer authPort) {
        this.authPort = authPort;
    }

    public String getAuthRespondAction() {
        return authRespondAction;
    }

    public void setAuthRespondAction(String authRespondAction) {
        this.authRespondAction = authRespondAction;
    }

    public List<Integer> getAuthRespondStatus() {
        return authRespondStatus;
    }

    public void setAuthRespondStatus(List<Integer> authRespondStatus) {
        this.authRespondStatus = authRespondStatus;
    }

    public String getAuthScheme() {
        return authScheme;
    }

    public void setAuthScheme(String authScheme) {
        this.authScheme = authScheme;
    }

    public Float getAuthTimeout() {
        return authTimeout;
    }

    public void setAuthTimeout(Float authTimeout) {
        this.authTimeout = authTimeout;
    }

    public String getAuthTimeoutPass() {
        return authTimeoutPass;
    }

    public void setAuthTimeoutPass(String authTimeoutPass) {
        this.authTimeoutPass = authTimeoutPass;
    }

    public Integer getForbiddenCode() {
        return forbiddenCode;
    }

    public void setForbiddenCode(Integer forbiddenCode) {
        this.forbiddenCode = forbiddenCode;
    }

    public String getForbiddenCodeState() {
        return forbiddenCodeState;
    }

    public void setForbiddenCodeState(String forbiddenCodeState) {
        this.forbiddenCodeState = forbiddenCodeState;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getReplace() {
        return replace;
    }

    public void setReplace(Integer replace) {
        this.replace = replace;
    }

    public CMCdnResponseJsonToVar getResponseJsonToVar() {
        return responseJsonToVar;
    }

    public void setResponseJsonToVar(CMCdnResponseJsonToVar responseJsonToVar) {
        this.responseJsonToVar = responseJsonToVar;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTryNextRemoteServerWhen() {
        return tryNextRemoteServerWhen;
    }

    public void setTryNextRemoteServerWhen(String tryNextRemoteServerWhen) {
        this.tryNextRemoteServerWhen = tryNextRemoteServerWhen;
    }

    public List<CMCdnUseMainRequestArgs> getUseMainRequestArgs() {
        return useMainRequestArgs;
    }

    public void setUseMainRequestArgs(List<CMCdnUseMainRequestArgs> useMainRequestArgs) {
        this.useMainRequestArgs = useMainRequestArgs;
    }

    public String getUseMainRequestArgsType() {
        return useMainRequestArgsType;
    }

    public void setUseMainRequestArgsType(String useMainRequestArgsType) {
        this.useMainRequestArgsType = useMainRequestArgsType;
    }

    public List<CMCdnUseMainRequestHeaders> getUseMainRequestHeaders() {
        return useMainRequestHeaders;
    }

    public void setUseMainRequestHeaders(List<CMCdnUseMainRequestHeaders> useMainRequestHeaders) {
        this.useMainRequestHeaders = useMainRequestHeaders;
    }

    public String getUseMainRequestHeadersType() {
        return useMainRequestHeadersType;
    }

    public void setUseMainRequestHeadersType(String useMainRequestHeadersType) {
        this.useMainRequestHeadersType = useMainRequestHeadersType;
    }

    public String getUseOriginalRequestArgs() {
        return useOriginalRequestArgs;
    }

    public void setUseOriginalRequestArgs(String useOriginalRequestArgs) {
        this.useOriginalRequestArgs = useOriginalRequestArgs;
    }

    public String getUseOriginalRequestHeaders() {
        return useOriginalRequestHeaders;
    }

    public void setUseOriginalRequestHeaders(String useOriginalRequestHeaders) {
        this.useOriginalRequestHeaders = useOriginalRequestHeaders;
    }
}
