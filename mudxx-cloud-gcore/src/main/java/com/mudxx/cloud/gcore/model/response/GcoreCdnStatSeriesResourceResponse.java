package com.mudxx.cloud.gcore.model.response;

import com.mudxx.cloud.gcore.model.entity.GcoreCdnStatSeriesMetricsModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求响应-CDN资源统计-仅对资源 ID 进行分组")
public class GcoreCdnStatSeriesResourceResponse implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;

    @ApiModelProperty(value = "资源，仅对资源 ID 进行分组，key=资源 ID，value=指标内容")
    private Map<String, GcoreCdnStatSeriesMetricsModel> resource;

    public Map<String, GcoreCdnStatSeriesMetricsModel> getResource() {
        return resource;
    }

    public void setResource(Map<String, GcoreCdnStatSeriesMetricsModel> resource) {
        this.resource = resource;
    }

}
