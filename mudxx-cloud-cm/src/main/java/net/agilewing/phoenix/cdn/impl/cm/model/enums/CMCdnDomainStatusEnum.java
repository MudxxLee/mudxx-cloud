package net.agilewing.phoenix.cdn.impl.cm.model.enums;


/**
 * @author laiwen
 */

public enum CMCdnDomainStatusEnum {
    /**
     * 域名状态
     */
    CODE_1(1, "审核中"),
    CODE_2(2, "审核成功"),
    CODE_3(3, "配置中"),
    CODE_4(4, "已启用"),
    CODE_5(5, "停止中"),
    CODE_6(6, "已停止"),
    CODE_7(7, "删除中"),
    CODE_8(8, "已删除"),
    CODE_9(9, "审核失败"),
    CODE_10(10, "配置失败"),
    CODE_11(11, "停止失败"),
    CODE_12(12, "删除失败"),
    ;

    private final Integer code;
    private final String desc;

    CMCdnDomainStatusEnum(Integer code, String desc) {
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
