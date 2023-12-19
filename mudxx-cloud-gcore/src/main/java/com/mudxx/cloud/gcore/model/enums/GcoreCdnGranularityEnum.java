package com.mudxx.cloud.gcore.model.enums;


/**
 * @author laiwen
 */

public enum GcoreCdnGranularityEnum {
    /**
     * 粒度
     */
    m_1("1m", "1 分钟"),
    m_5("5m", "5 分钟"),
    m_15("15m", "15 分钟"),
    h_1("1h", "1 小时"),
    d_1("1d", "1 天"),

    ;

    private final String code;
    private final String desc;

    GcoreCdnGranularityEnum(String code, String desc) {
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
