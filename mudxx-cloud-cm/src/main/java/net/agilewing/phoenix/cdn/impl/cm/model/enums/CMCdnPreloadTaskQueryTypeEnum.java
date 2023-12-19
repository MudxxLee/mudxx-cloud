package net.agilewing.phoenix.cdn.impl.cm.model.enums;


/**
 * @author laiwen
 */

public enum CMCdnPreloadTaskQueryTypeEnum {
    /**
     * 预热任务查询方式
     */
    CODE_0(0, "按照时间查询"),
    CODE_1(1, "按照 submit_id 查询"),
    CODE_2(2, "按照 task_id 查询"),

    ;

    private final Integer code;
    private final String desc;

    CMCdnPreloadTaskQueryTypeEnum(Integer code, String desc) {
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
