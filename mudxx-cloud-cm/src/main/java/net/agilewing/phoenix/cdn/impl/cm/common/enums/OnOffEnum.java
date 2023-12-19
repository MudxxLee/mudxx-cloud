package net.agilewing.phoenix.cdn.impl.cm.common.enums;


/**
 * @author laiwen
 */

public enum OnOffEnum {
    /**
     * 开启关闭
     */
    On("on", "开启"),
    Off("off", "关闭"),
    ;

    private final String code;
    private final String desc;

    OnOffEnum(String code, String desc) {
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
