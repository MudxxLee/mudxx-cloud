package net.agilewing.phoenix.cdn.impl.cm.model.enums;


/**
 * @author laiwen
 */

public enum CMCdnOriginProtocolEnum {
    /**
     * 源站角色
     */
    http("http", "用http协议回源"),
    https("https", "用https协议回源"),
    follow_request("follow_request", "跟随访问协议进行回源"),
    ;

    private final String code;
    private final String desc;

    CMCdnOriginProtocolEnum(String code, String desc) {
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
