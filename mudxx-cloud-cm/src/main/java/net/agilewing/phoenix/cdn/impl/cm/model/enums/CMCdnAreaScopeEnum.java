package net.agilewing.phoenix.cdn.impl.cm.model.enums;


/**
 * @author laiwen
 */

public enum CMCdnAreaScopeEnum {
    /**
     * 加速范围
     */
    CODE_1(1, "国内"),
    CODE_2(2, "海外"),
    CODE_3(3, "国内+海外"),

    ;

    private final Integer code;
    private final String desc;

    CMCdnAreaScopeEnum(Integer code, String desc) {
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
