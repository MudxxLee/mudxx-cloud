package com.mudxx.cloud.gcore.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("模型-CDN资源统计-指标内容")
public class GcoreCdnStatSeriesMetricsModel implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;

    @ApiModelProperty(value = "指标内容，key=统计数据的类型，value=数组(0:接收统计信息时 UNIX 时间戳中的时间 1:数值)")
    private Map<String, List<List<BigDecimal>>> metrics;

    public Map<String, List<List<BigDecimal>>> getMetrics() {
        return metrics;
    }

    public void setMetrics(Map<String, List<List<BigDecimal>>> metrics) {
        this.metrics = metrics;
    }
}
