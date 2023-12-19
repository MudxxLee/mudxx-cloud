package net.agilewing.phoenix.cdn.impl.cm.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求参数-日志列表")
public class CMCdnLogListRequest implements Serializable {
    private static final long serialVersionUID = -9162121926025210638L;

    @ApiModelProperty(value = "起始时间", required = true, notes = "时间戳(秒)")
    @JSONField(name = "start_time")
    private Integer startTime;

    @ApiModelProperty(value = "结束时间", required = true, notes = "时间戳(秒)")
    @JSONField(name = "end_time")
    private Integer endTime;

    @ApiModelProperty(value = "域名", required = true)
    private String domain;

    public CMCdnLogListRequest() {
    }

    private CMCdnLogListRequest(Builder builder) {
        setStartTime(builder.startTime);
        setEndTime(builder.endTime);
        setDomain(builder.domain);
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public static final class Builder {
        private Integer startTime;
        private Integer endTime;
        private String domain;

        public Builder() {
        }

        public Builder startTime(Integer val) {
            startTime = val;
            return this;
        }

        public Builder endTime(Integer val) {
            endTime = val;
            return this;
        }

        public Builder domain(String val) {
            domain = val;
            return this;
        }

        public CMCdnLogListRequest build() {
            return new CMCdnLogListRequest(this);
        }
    }
}
