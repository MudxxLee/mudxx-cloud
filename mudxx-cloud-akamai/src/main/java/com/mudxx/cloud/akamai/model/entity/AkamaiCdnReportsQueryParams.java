package com.mudxx.cloud.akamai.model.entity;

import java.io.Serializable;

/**
 * 模型-报表-查询参数
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnReportsQueryParams implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;
    /**
     * 开始时间-ISO-8601 格式 2022-07-25T13:55:00Z
     */
    private String start;
    /**
     * 结束时间-ISO-8601 格式 2022-07-25T13:55:00Z
     */
    private String end;
    /**
     * 聚合间隔-每个数据记录的持续时间
     */
    private String interval;

    public AkamaiCdnReportsQueryParams() {
    }

    private AkamaiCdnReportsQueryParams(Builder builder) {
        setStart(builder.start);
        setEnd(builder.end);
        setInterval(builder.interval);
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public static final class Builder {
        private String start;
        private String end;
        private String interval;

        public Builder() {
        }

        public Builder start(String start) {
            this.start = start;
            return this;
        }

        public Builder end(String end) {
            this.end = end;
            return this;
        }

        public Builder interval(String interval) {
            this.interval = interval;
            return this;
        }

        public AkamaiCdnReportsQueryParams build() {
            return new AkamaiCdnReportsQueryParams(this);
        }
    }
}
