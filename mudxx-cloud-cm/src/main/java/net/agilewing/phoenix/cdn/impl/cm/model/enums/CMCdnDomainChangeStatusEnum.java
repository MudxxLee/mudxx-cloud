package net.agilewing.phoenix.cdn.impl.cm.model.enums;


/**
 * @author laiwen
 */

public enum CMCdnDomainChangeStatusEnum {
    /**
     * 域名状态操作动作
     */
    CODE_1(1, "删除"),
    CODE_2(2, "停用"),
    CODE_3(3, "启用"),
    ;

    private final Integer code;
    private final String desc;

    CMCdnDomainChangeStatusEnum(Integer code, String desc) {
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
