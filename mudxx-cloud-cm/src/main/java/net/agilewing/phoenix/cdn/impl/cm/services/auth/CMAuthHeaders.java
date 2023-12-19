package net.agilewing.phoenix.cdn.impl.cm.services.auth;

import net.agilewing.phoenix.common.model.Md5Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/20 16:21
 */
public class CMAuthHeaders {

    public static Map<String, String> buildHeaders(String appId, String appSecret) {
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000L);
        Map<String, String> headers = new HashMap<>(4);
        headers.put("Content-Type", "application/json");
        headers.put("Timestamp", timestamp);
        headers.put("AppId", appId);
        headers.put("Signature", Md5Utils.littleMD5a(timestamp + appId + appSecret));
        return headers;
    }

}
