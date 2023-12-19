package com.mudxx.cloud.gcore.model.enums;


/**
 * @author laiwen
 */
public enum GcoreCdnStatSeriesGroupByEnum {
    /**
     * 输出数据分组
     */
    resource("resource", "数据按 CDN 资源 ID 分组"),
    region("region", "数据按 CDN 边缘服务器的区域分组"),
    country("country", "数据按 CDN 边缘服务器的国家/地区分组"),
    vhost("vhost", "数据按资源 CNAME 分组"),

    ;

    private final String code;
    private final String desc;

    GcoreCdnStatSeriesGroupByEnum(String code, String desc) {
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
