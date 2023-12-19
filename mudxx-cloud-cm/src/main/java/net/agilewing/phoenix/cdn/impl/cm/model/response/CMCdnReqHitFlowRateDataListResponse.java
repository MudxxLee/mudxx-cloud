package net.agilewing.phoenix.cdn.impl.cm.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnReqHitFlowRateDataInterval;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
@ApiModel("请求响应-查询流量，命中流量，流量命中率，回源流量数据")
public class CMCdnReqHitFlowRateDataListResponse extends CMResponse {
    private static final long serialVersionUID = -1756411372792559572L;

    @ApiModelProperty(value = "起始时间", notes = "时间戳(秒)")
    @JSONField(name = "start_time")
    private Integer startTime;

    @ApiModelProperty(value = "结束时间", notes = "时间戳(秒)")
    @JSONField(name = "end_time")
    private Integer endTime;

    @ApiModelProperty(value = "时间粒度")
    private String interval;

    @ApiModelProperty(value = "每个时间间隔的请求数数据")
    @JSONField(name = "req_hit_flow_rate_data_interval")
    private List<CMCdnReqHitFlowRateDataInterval> reqHitFlowRateDataInterval;

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

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public List<CMCdnReqHitFlowRateDataInterval> getReqHitFlowRateDataInterval() {
        return reqHitFlowRateDataInterval;
    }

    public void setReqHitFlowRateDataInterval(List<CMCdnReqHitFlowRateDataInterval> reqHitFlowRateDataInterval) {
        this.reqHitFlowRateDataInterval = reqHitFlowRateDataInterval;
    }
}

