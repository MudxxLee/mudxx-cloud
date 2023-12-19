package net.agilewing.phoenix.cdn.impl.cm.model.enums;


/**
 * @author laiwen
 */

public enum CMCdnOriginRoleEnum {
    /**
     * 源站角色
     */
    master("master", "master"),
    slave("slave", "slave"),

    ;

    private final String code;
    private final String desc;

    CMCdnOriginRoleEnum(String code, String desc) {
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
