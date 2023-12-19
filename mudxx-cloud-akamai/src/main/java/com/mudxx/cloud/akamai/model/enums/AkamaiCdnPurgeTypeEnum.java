package com.mudxx.cloud.akamai.model.enums;


/**
 * @author laiwen
 */

public enum AkamaiCdnPurgeTypeEnum {
    /**
     * 清除类型
     */
    INVALID_CPCODE("/ccu/v3/invalidate/cpcode/%s", "通过 CP代码 失效"),
    INVALID_TAG("/ccu/v3/invalidate/tag/%s", "通过 缓存标记 失效"),
    INVALID_URL("/ccu/v3/invalidate/url/%s", "通过 URL或ARL 失效"),
    DELETE_CPCODE("/ccu/v3/delete/cpcode/%s", "通过 CP代码 删除"),
    DELETE_TAG("/ccu/v3/delete/tag/%s", "通过 缓存标记 删除"),
    DELETE_URL("/ccu/v3/delete/url/%s", "通过 URL或ARL 删除"),

    ;

    private final String code;
    private final String desc;

    AkamaiCdnPurgeTypeEnum(String code, String desc) {
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
