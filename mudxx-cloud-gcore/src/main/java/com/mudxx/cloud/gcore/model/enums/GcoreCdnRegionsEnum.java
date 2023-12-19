package com.mudxx.cloud.gcore.model.enums;


/**
 * @author laiwen
 */

public enum GcoreCdnRegionsEnum {
    /**
     * 地区
     */
    na("na", "North America"),
    eu("eu", "Europe"),
    cis("cis", "Commonwealth of Independent States"),
    asia("asia", "Asia"),
    au("au", "Australia"),
    latam("latam", "Latin America"),
    me("me", "Middle East"),
    africa("africa", "Africa"),
    sa("sa", "South America"),

    ;

    private final String code;
    private final String desc;

    GcoreCdnRegionsEnum(String code, String desc) {
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
