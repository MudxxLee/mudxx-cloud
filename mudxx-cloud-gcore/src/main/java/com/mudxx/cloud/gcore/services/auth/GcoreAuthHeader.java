package com.mudxx.cloud.gcore.services.auth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
public class GcoreAuthHeader {

    public static Map<String, String> buildHeaders(String apiKey) {
        Map<String, String> headers = new HashMap<>(1);
        headers.put("Authorization", "APIKey " + apiKey);
        return headers;
    }

}

