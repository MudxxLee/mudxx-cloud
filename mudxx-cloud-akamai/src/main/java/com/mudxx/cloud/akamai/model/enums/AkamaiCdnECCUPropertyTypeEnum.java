package com.mudxx.cloud.akamai.model.enums;


/**
 * @author laiwen
 */

public enum AkamaiCdnECCUPropertyTypeEnum {
    /**
     * 属性类型
     */
    ARL_TOKEN("ARL_TOKEN", "ARL令牌"),
    HOST_HEADER("HOST_HEADER", "主机头"),

    ;

    private final String code;
    private final String desc;

    AkamaiCdnECCUPropertyTypeEnum(String code, String desc) {
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
