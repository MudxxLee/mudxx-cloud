package net.agilewing.phoenix.cdn.impl.cm.model.enums;


/**
 * @author laiwen
 */

public enum CMCdnRefreshTaskTypeEnum {
    /**
     * 刷新任务类型
     */
    CODE_1(1, "url"),
    CODE_2(2, "目录dir"),
    CODE_3(3, "正则匹配 re"),

    ;

    private final Integer code;
    private final String desc;

    CMCdnRefreshTaskTypeEnum(Integer code, String desc) {
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
