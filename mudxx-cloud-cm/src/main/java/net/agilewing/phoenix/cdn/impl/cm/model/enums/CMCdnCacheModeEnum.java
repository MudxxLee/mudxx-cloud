package net.agilewing.phoenix.cdn.impl.cm.model.enums;


/**
 * @author laiwen
 */

public enum CMCdnCacheModeEnum {
    /**
     * 缓存模式
     */
    CODE_0(0, "文件后缀"),
    CODE_1(1, "目录"),
    CODE_2(2, "首页"),
    CODE_3(3, "全部文件"),
    CODE_4(4, "全路径"),

    ;

    private final Integer code;
    private final String desc;

    CMCdnCacheModeEnum(Integer code, String desc) {
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
