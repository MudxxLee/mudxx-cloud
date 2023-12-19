package net.agilewing.phoenix.cdn.impl.cm.common.enums;


/**
 * @author laiwen
 */

public enum SwitchEnum {
    /**
     * 开关
     */
    Open(1, "开"),
    Close(2, "关"),
    ;

    private final Integer code;
    private final String desc;

    SwitchEnum(Integer code, String desc) {
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
