package com.mudxx.cloud.akamai.model.enums;


/**
 * @author laiwen
 */

public enum AkamaiCdnReportsDataTypeEnum {
    /**
     * “Traffic by Hostname”报告
     */
    HOSTNAME_HITS_BY_TIME("hostname-hits-by-time", "主机名边缘请求数-按时间分组", 2,
            new String[]{
                    // 给定对象和筛选器每秒的边缘请求数
                    "edgeHitsPerSecond",
                    // 最大边缘命中数
                    "maxEdgeHits",
            },
            new String[]{
                    // 给定对象和筛选器每秒的边缘请求数峰值
                    "edgeHitsPerSecondMax",
                    // 给定对象和筛选器每秒的最小边缘请求数
                    "edgeHitsPerSecondMin",
                    // 表示给定对象和筛选器的边缘请求数的总体变化，如果增加，则为正数，如果减少，则为负数
                    "edgeHitsSlope",
                    // 给定对象和筛选器的边缘请求总数
                    "edgeHitsTotal",
            }),
    HOSTNAME_BYTES_BY_TIME("hostname-bytes-by-time", "主机名边缘字节数-按时间分组", 2,
            new String[]{
                    // 给定对象和过滤器的边缘带宽
                    "edgeBitsPerSecond",
                    // 最大边缘字节数
                    "maxEdgeBytes",
            },
            new String[]{
                    // 给定对象和滤波器的峰值边缘带宽
                    "edgeBitsPerSecondMax",
                    // 给定对象和滤波器的最低边缘带宽
                    "edgeBitsPerSecondMin",
                    // 表示给定对象和过滤器的边缘流量的总体变化，如果增加，则为正数，如果减少，则为负数
                    "edgeBytesSlope",
                    // 给定对象和过滤器的边缘流量总量
                    "edgeBytesTotal",
            }),
    HOSTNAME_TRAFFIC_BY_TIME_AND_RESPONSE_CLASS("hostname-traffic-by-timeandresponseclass",
            "主机名边缘请求数-按时间+响应状态类分组", 2,
            new String[]{
                    // 给定对象和筛选器每秒的边缘请求数
                    "edgeHitsPerSecond",
            },
            new String[]{

            }),

    ;

    private final String name;
    private final String desc;
    private final Integer version;
    private final String[] dataMetrics;
    private final String[] summaryMetrics;

    AkamaiCdnReportsDataTypeEnum(String name, String desc, Integer version, String[] dataMetrics, String[] summaryMetrics) {
        this.name = name;
        this.desc = desc;
        this.version = version;
        this.dataMetrics = dataMetrics;
        this.summaryMetrics = summaryMetrics;
    }

    public String getName() {
        return name;
    }

    public Integer getVersion() {
        return version;
    }

    public String getDesc() {
        return desc;
    }

    public String[] getDataMetrics() {
        return dataMetrics;
    }

    public String[] getSummaryMetrics() {
        return summaryMetrics;
    }
}
