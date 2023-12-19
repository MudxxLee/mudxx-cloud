package net.agilewing.phoenix.cdn.impl.cm.model.response;

import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
@ApiModel("请求响应-日志列表")
public class CMCdnLogListResponse extends CMResponse {
    private static final long serialVersionUID = -6719913822362607593L;

    @ApiModelProperty(value = "域名")
    private String domain;

    @ApiModelProperty(value = "下载日志地址列表")
    private List<CMCdnLog> logs;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<CMCdnLog> getLogs() {
        return logs;
    }

    public void setLogs(List<CMCdnLog> logs) {
        this.logs = logs;
    }
}

