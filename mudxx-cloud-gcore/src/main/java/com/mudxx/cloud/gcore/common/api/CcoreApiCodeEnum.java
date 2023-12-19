package com.mudxx.cloud.gcore.common.api;

import org.apache.commons.lang3.StringUtils;

/**
 * @author laiw
 * @date 2023/11/24 13:54
 */
public enum CcoreApiCodeEnum {

    /**
     * HTTP 状态代码
     */
    SUCCESS(200, "OK", "请求已成功完成"),
    C_400(400, "错误的请求", "缺少必需的参数"),
    C_401(401, "未经授权", "提供的凭据无效或您的 API 令牌已过期"),
    C_403(403, "禁止", "访问被拒绝。你没有足够的权利"),
    C_404(404, "未找到", "请求的项目不存在"),
    C_429(429, "请求太多", "您已超过允许的资源请求数"),
    C_458(458, "请求太多", "已超过来自客户端 IP 地址的最大请求数"),
    C_500(500, "服务器错误", "服务器出了点问题"),
    C_502(502, "服务器错误", "服务器出了点问题"),
    C_503(503, "服务不可用", "您的请求参数有误，或者服务当前不可用"),
    C_504(504, "服务器错误", "CDN 对源的访问受到限制"),
    C_508(508, "服务器错误", "CDN 资源（CNAME）的域和源被搞砸了"),
    C_556(556, "服务器错误", "已超过与源的连接数"),
    C_557(557, "服务器错误", "对服务器的请求数已超过每台服务器 5,000 个请求的限制"),

    ;

    private final Integer code;
    private final String desc;
    private final String detail;

    CcoreApiCodeEnum(Integer code, String desc, String detail) {
        this.code = code;
        this.desc = desc;
        this.detail = detail;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String getDetail() {
        return detail;
    }

    public String getDetails(String message) {
        if (StringUtils.isBlank(message)) {
            return String.join("，", desc, detail);
        }
        return String.join("，", desc, message);
    }
}
