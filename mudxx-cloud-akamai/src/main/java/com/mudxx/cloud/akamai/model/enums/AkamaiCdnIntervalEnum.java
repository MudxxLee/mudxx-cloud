package com.mudxx.cloud.akamai.model.enums;


/**
 * @author laiwen
 */

public enum AkamaiCdnIntervalEnum {
    /**
     * 聚合间隔 MONTH WEEK DAY HOUR FIVE_MINUTES
     */
    FIVE_MINUTES("FIVE_MINUTES", "5 分钟"),
    HOUR("HOUR", "1 小时"),
    DAY("DAY", "1 天"),
    WEEK("WEEK", "1 周"),
    MONTH("MONTH", "1 个月"),

    ;

    private final String code;
    private final String desc;

    AkamaiCdnIntervalEnum(String code, String desc) {
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
