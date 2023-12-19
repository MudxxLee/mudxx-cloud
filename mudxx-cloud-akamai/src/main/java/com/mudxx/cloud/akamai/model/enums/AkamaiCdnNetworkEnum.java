package com.mudxx.cloud.akamai.model.enums;


/**
 * @author laiwen
 */

public enum AkamaiCdnNetworkEnum {
    /**
     * 网络 staging production
     */
    STAGING("staging", "暂存环境"),
    PRODUCTION("production", "生产环境"),

    ;

    private final String code;
    private final String desc;

    AkamaiCdnNetworkEnum(String code, String desc) {
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
