package net.agilewing.phoenix.cdn.impl.cm.model.enums;


/**
 * @author laiwen
 */

public enum CMCdnDomainActionEnum {
    /**
     * 域名操作动作
     */
    ADD(1, "新增"),

    ;

    private final Integer code;
    private final String desc;

    CMCdnDomainActionEnum(Integer code, String desc) {
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
