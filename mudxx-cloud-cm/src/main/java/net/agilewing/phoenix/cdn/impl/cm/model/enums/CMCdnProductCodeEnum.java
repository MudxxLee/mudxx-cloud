package net.agilewing.phoenix.cdn.impl.cm.model.enums;

/**
 * @author laiwen
 */

public enum CMCdnProductCodeEnum {
    /**
     * 支持产品类型
     */
    CODE_001("001", "静态加速"),
    CODE_003("003", "下载加速"),
    CODE_004("004", "视频点播加速"),
    CODE_006("006", "全站加速"),
    CODE_007("007", "安全加速"),
    CODE_008("008", "CDN 加速"),
    CODE_014("014", "下载加速闲时"),

    ;

    private final String code;
    private final String desc;

    CMCdnProductCodeEnum(String code, String desc) {
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
