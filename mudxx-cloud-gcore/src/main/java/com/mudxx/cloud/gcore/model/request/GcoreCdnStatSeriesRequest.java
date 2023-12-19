package com.mudxx.cloud.gcore.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求参数-CDN资源统计")
public class GcoreCdnStatSeriesRequest implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;

    @ApiModelProperty(value = "服务名称，固定CDN", required = true)
    private String service;

    @ApiModelProperty(value = "请求的时间段的开始，格式UTC", required = true)
    private String from;

    @ApiModelProperty(value = "请求的时间段结束，格式UTC", required = true)
    private String to;

    @ApiModelProperty(value = "粒度，数据将被划分为的时间块的持续时间", required = true)
    private String granularity;

    @ApiModelProperty(value = "指标，统计数据的类型", required = true)
    private String metrics;

    @ApiModelProperty(value = "输出数据分组，多个值请使用：&group_by=区域&group_by=资源", required = true)
    @JSONField(name = "group_by")
    private String groupBy;

    /*--------------------------------------------------------------可选参数--------------------------------------------------------------*/

    @ApiModelProperty(value = "国家，应使用ISO 3166标准中的英文简称，多个值请使用：&countries=france&countries=denmark")
    private String countries;

    @ApiModelProperty(value = "地区，应使用ISO 3166标准中的英文简称")
    private String regions;

    @ApiModelProperty(value = "CDN 资源 ID，应使用ISO 3166标准中的英文简称，多个值请使用：&resource=1&resource=2")
    private String resource;

    public GcoreCdnStatSeriesRequest() {
    }

    private GcoreCdnStatSeriesRequest(Builder builder) {
        setService(builder.service);
        setFrom(builder.from);
        setTo(builder.to);
        setGranularity(builder.granularity);
        setMetrics(builder.metrics);
        setGroupBy(builder.groupBy);
        setCountries(builder.countries);
        setRegions(builder.regions);
        setResource(builder.resource);
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getGranularity() {
        return granularity;
    }

    public void setGranularity(String granularity) {
        this.granularity = granularity;
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
        this.metrics = metrics;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public static final class Builder {
        private String service;
        private String from;
        private String to;
        private String granularity;
        private String metrics;
        private String groupBy;
        private String countries;
        private String regions;
        private String resource;

        public Builder() {
        }

        public Builder service(String val) {
            service = val;
            return this;
        }

        public Builder from(String val) {
            from = val;
            return this;
        }

        public Builder to(String val) {
            to = val;
            return this;
        }

        public Builder granularity(String val) {
            granularity = val;
            return this;
        }

        public Builder metrics(String val) {
            metrics = val;
            return this;
        }

        public Builder groupBy(String val) {
            groupBy = val;
            return this;
        }

        public Builder countries(String val) {
            countries = val;
            return this;
        }

        public Builder regions(String val) {
            regions = val;
            return this;
        }

        public Builder resource(String val) {
            resource = val;
            return this;
        }

        public GcoreCdnStatSeriesRequest build() {
            return new GcoreCdnStatSeriesRequest(this);
        }
    }
}
