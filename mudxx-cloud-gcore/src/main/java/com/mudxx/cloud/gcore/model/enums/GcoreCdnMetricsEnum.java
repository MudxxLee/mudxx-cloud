package com.mudxx.cloud.gcore.model.enums;


/**
 * @author laiwen
 */

public enum GcoreCdnMetricsEnum {
    /**
     * 流量
     */
    sent_bytes("sent_bytes", "流出流量：从 CDN 服务器到客户端的流量（以字节为单位）。"),
    shield_bytes("shield_bytes", "从源屏蔽到 CDN 服务器的流量（以字节为单位）。"),
    upstream_bytes("upstream_bytes", "回源流量：使用时从源服务器到 CDN 服务器或源屏蔽的流量（以字节为单位）。"),
    cdn_bytes("cdn_bytes", "sent_bytes、shield_bytes相结合。"),
    total_bytes("total_bytes", "sent_bytes、shield_bytes、upstream_bytes相结合。可用于带宽换算"),
    backblaze_bytes("backblaze_bytes", "来自 Backblaze 源的流量（以字节为单位）。"),
    shield_traffic_ratio("shield_traffic_ratio", "公式：(shield_bytes - upstream_bytes) / shield_bytes。" +
            "源屏蔽的效率：从源屏蔽发送的流量比从源发送的流量多多少。"),
    /**
     * 请求数
     */
    requests("requests", "流出请求数：对边缘服务器的请求数。"),
    /**
     * 状态码
     */
    responses_2xx("responses_2xx", "2xx 响应代码的数量。"),
    responses_3xx("responses_3xx", "3xx 响应代码的数量。"),
    responses_4xx("responses_4xx", "4xx 响应代码的数量。"),
    responses_5xx("responses_5xx", "5xx 响应代码的数量。"),
    responses_hit("responses_hit", "标头为 Cache： HIT 的响应数。"),
    responses_miss("responses_miss", "标头为 Cache： MISS 的响应数。"),
    response_types("response_types", "按内容类型划分的统计信息。它为具有不同 MIME 类型的内容返回许多响应。"),
    /**
     * 缓存命中率
     */
    cache_hit_traffic_ratio("cache_hit_traffic_ratio", "公式：1 - upstream_bytes / sent_bytes。我们从总流量中扣除非缓存流量。"),
    cache_hit_requests_ratio("cache_hit_requests_ratio", "公式：responses_hit/请求。发送缓存内容的份额。"),

    image_processed("image_processed", "在图像优化服务上转换的图像数。"),
    request_time("request_time", "处理请求的第一个字节与将最后一个字节发送给用户后的记录之间经过的时间。"),
    upstream_response_time("upstream_response_time", "从源接收响应所花费的秒数。" +
            "如果上游response_time_包含一个请求的多个指示（如果有多个源），我们会汇总它们。在聚合多个查询的情况下，将计算此数量的平均值。"),

    ;

    private final String code;
    private final String desc;

    GcoreCdnMetricsEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
