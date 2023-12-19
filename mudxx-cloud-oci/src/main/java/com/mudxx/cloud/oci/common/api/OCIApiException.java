package com.mudxx.cloud.oci.common.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/19 16:04
 */
public class OCIApiException extends Exception {
    private static final long serialVersionUID = -4322013542730177208L;
    private static final int SYS_ERROR_CODE = -99;

    private Integer code;

    private Map<String, List<String>> responseHeaders;

    public OCIApiException(Integer code, String message, Throwable throwable, Map<String, List<String>> responseHeaders) {
        super(message, throwable);
        this.code = code;
        this.responseHeaders = responseHeaders;
    }

    public OCIApiException(Integer code, String message, Throwable throwable) {
        this(code, message, throwable, null);
    }

    public OCIApiException(String message, Throwable throwable) {
        this(SYS_ERROR_CODE, message, throwable, null);
    }

    public OCIApiException(String message, Map<String, List<String>> responseHeaders) {
        this(SYS_ERROR_CODE, message, null, responseHeaders);
    }

    public String toSimpleJsonStr() {
        try {
            Map<String, Object> jsonStr = new HashMap<>();
            jsonStr.put("code", this.getCode());
            jsonStr.put("message", this.getMessage());
            return JSON.toJSONString(jsonStr, SerializerFeature.WriteMapNullValue);
        } catch (Exception e) {
            return "{\"code\":" + SYS_ERROR_CODE + ",\"message\":\"Unknown error\"}";
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Map<String, List<String>> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

}





