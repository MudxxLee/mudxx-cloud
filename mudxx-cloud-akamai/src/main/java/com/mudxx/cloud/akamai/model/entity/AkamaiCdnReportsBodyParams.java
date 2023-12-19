package com.mudxx.cloud.akamai.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 模型-报表-body参数
 *
 * @author laiw
 * @date 2023/12/15 13:56
 */
public class AkamaiCdnReportsBodyParams implements Serializable {
    private static final long serialVersionUID = -7550492654742466417L;
    /**
     * 指定要报告的值集。cpcode
     */
    private List<String> objectIds;
    /**
     * 所需指标的集合
     */
    private List<String> metrics;
    /**
     * 自定义筛选器
     */
    private AkamaiCdnReportsFilters filters;

    public AkamaiCdnReportsBodyParams() {
    }

    private AkamaiCdnReportsBodyParams(Builder builder) {
        setObjectIds(builder.objectIds);
        setMetrics(builder.metrics);
        setFilters(builder.filters);
    }

    public List<String> getObjectIds() {
        return objectIds;
    }

    public void setObjectIds(List<String> objectIds) {
        this.objectIds = objectIds;
    }

    public List<String> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<String> metrics) {
        this.metrics = metrics;
    }

    public AkamaiCdnReportsFilters getFilters() {
        return filters;
    }

    public void setFilters(AkamaiCdnReportsFilters filters) {
        this.filters = filters;
    }

    public static final class Builder {
        private List<String> objectIds;
        private List<String> metrics;
        private AkamaiCdnReportsFilters filters;

        public Builder() {
        }

        public Builder objectIds(List<String> objectIds) {
            this.objectIds = objectIds;
            return this;
        }

        public Builder metrics(List<String> metrics) {
            this.metrics = metrics;
            return this;
        }

        public Builder filters(AkamaiCdnReportsFilters filters) {
            this.filters = filters;
            return this;
        }

        public AkamaiCdnReportsBodyParams build() {
            return new AkamaiCdnReportsBodyParams(this);
        }
    }
}
