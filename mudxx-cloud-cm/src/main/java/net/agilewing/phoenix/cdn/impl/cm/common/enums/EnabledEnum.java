package net.agilewing.phoenix.cdn.impl.cm.common.enums;


/**
 * @author laiwen
 */

public enum EnabledEnum {
    /**
     * 启用禁用
     */
    Enable(1, "启用"),
    Disable(0, "禁用"),
    ;

    private final Integer code;
    private final String desc;

    EnabledEnum(Integer code, String desc) {
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
