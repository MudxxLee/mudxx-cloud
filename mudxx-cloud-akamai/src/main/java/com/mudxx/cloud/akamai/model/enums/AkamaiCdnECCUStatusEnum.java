package com.mudxx.cloud.akamai.model.enums;


/**
 * @author laiwen
 */

public enum AkamaiCdnECCUStatusEnum {
    /**
     * 状态
     */
    PENDING("PENDING", "等待中"),
    SUCCEEDED("SUCCEEDED", "成功"),
    FAILED("FAILED", "失败"),
    IGNORED("IGNORED", "忽略"),

    ;

    private final String code;
    private final String desc;

    AkamaiCdnECCUStatusEnum(String code, String desc) {
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
