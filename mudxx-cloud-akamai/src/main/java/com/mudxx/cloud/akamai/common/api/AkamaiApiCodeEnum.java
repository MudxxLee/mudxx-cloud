package com.mudxx.cloud.akamai.common.api;

import org.apache.commons.lang3.StringUtils;

/**
 * @author laiw
 * @date 2023/11/24 13:54
 */
public enum AkamaiApiCodeEnum {

    /**
     * HTTP 状态代码
     */
    C_200(200, "OK", "请求已成功完成"),
    C_201(201, "OK", "请求已成功完成"),
    C_400(400, "请求错误", "缺少必需的参数"),
    C_401(401, "请求未经授权", "提供的凭据无效或您的 API 令牌已过期"),
    C_403(403, "请求禁止", "访问被拒绝。你没有足够的权利"),
    C_404(404, "请求未找到", "API 端点不存在"),
    C_405(405, "请求错误", "不允许的 HTTP 方法"),
    C_408(408, "请求超时", "服务器在等待客户端生成请求时超时"),
    C_410(410, "请求版本错误", "已停用的 API 版本"),
    C_411(411, "请求错误", "未提供标头"),
    C_413(413, "请求被拒绝", "请求实体太大，因为它超出了最大邮件正文大小，即 50,000 字节"),
    C_415(415, "介质类型错误", "验证请求中是否存在标头.Content-Type: application/json"),
    C_429(429, "请求太多", "超出了每秒请求数的限制"),
    C_500(500, "内部服务器错误", "服务器出了点问题"),
    C_503(503, "内部服务器错误", "服务暂时不可用"),
    C_504(504, "内部服务器错误", "服务器在处理请求时超时。等待 5 秒钟，然后重试您的请求。"),
    C_507(507, "内部服务器错误", "存储空间不足。等待 5 秒钟，然后重试您的请求。"),

    ;

    private final Integer code;
    private final String desc;
    private final String detail;

    AkamaiApiCodeEnum(Integer code, String desc, String detail) {
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
