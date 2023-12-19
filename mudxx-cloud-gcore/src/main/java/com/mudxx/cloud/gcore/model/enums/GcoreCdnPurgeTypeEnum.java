package com.mudxx.cloud.gcore.model.enums;


/**
 * @author laiwen
 */

public enum GcoreCdnPurgeTypeEnum {
    /**
     * 清除类型
     */
    CODE_1(1, "按URL清除"),
    CODE_2(2, "按模式清除"),
    CODE_3(3, "清除所有缓存"),

    ;

    private final Integer code;
    private final String desc;

    GcoreCdnPurgeTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
