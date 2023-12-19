package net.agilewing.phoenix.cdn.impl.cm.model.enums;


/**
 * @author laiwen
 */

public enum CMCdnRefreshTaskStatusEnum {
    /**
     * 刷新任务执行状态
     */
    Processing("processing", "进行中"),
    Completed("completed", "成功"),
    Failed("failed", "失败"),

    ;

    private final String code;
    private final String desc;

    CMCdnRefreshTaskStatusEnum(String code, String desc) {
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
