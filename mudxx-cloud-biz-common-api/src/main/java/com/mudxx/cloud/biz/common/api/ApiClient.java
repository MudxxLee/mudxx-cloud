package com.mudxx.cloud.biz.common.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import net.agilewing.phoenix.common.model.util.HttpUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
public class ApiClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiClient.class);

    /*----------------------------------------------------------GET----------------------------------------------------------*/

    public <T> T doGet(String urlString, Map<String, String> headers, Map<String, String> queryParams,
                       ApiReturnType<T> returnType, String logName) throws ApiException {
        return this.doGet(urlString, headers, this.withQueryString(queryParams), returnType, logName);
    }

    public <T> T doGet(String urlString, Map<String, String> headers, String queryString,
                       ApiReturnType<T> returnType, String logName) throws ApiException {
        try {
            LOGGER.info("-----[{}] api.request.urlString={}, api.request.queryString={}", logName, urlString, queryString);
            long start = System.currentTimeMillis();
            ApiResponse<T> response = this.doGet(urlString, headers, queryString, returnType);
            LOGGER.info("-----[{}] api.response.code={}, api.response.body={}, api.response.time-consuming={}s",
                    logName, response.getCode(), response.getBody(), (System.currentTimeMillis() - start) / 1000);
            return response.getData();
        } catch (ApiException e) {
            LOGGER.error("-----[{}] api.response.error={}", logName, e.toSimpleJsonStr(), e);
            throw e;
        }
    }

    public <T> ApiResponse<T> doGet(String urlString, Map<String, String> headers, Map<String, String> queryParams,
                                    ApiReturnType<T> returnType) throws ApiException {
        return this.doGet(urlString, headers, this.withQueryString(queryParams), returnType);
    }

    public <T> ApiResponse<T> doGet(String urlString, Map<String, String> headers, String queryString,
                                    ApiReturnType<T> returnType) throws ApiException {
        ApiRequester requester = new ApiRequester.Builder()
                .httpMethod(HttpMethod.GET)
                .url(urlString)
                .headers(headers)
                .queryString(queryString)
                .build();
        return this.doExecute(requester, returnType);
    }

    /*----------------------------------------------------------POST----------------------------------------------------------*/

    public <T> T doPostJson(String url, Map<String, String> headers, String body, ApiReturnType<T> returnType, String logName) throws ApiException {
        try {
            LOGGER.info("-----[{}] api.request.url={}, api.request.body={}", logName, url, body);
            long start = System.currentTimeMillis();
            ApiResponse<T> response = this.doPostJson(
                    url,
                    headers,
                    body,
                    returnType);
            LOGGER.info("-----[{}] api.response.code={}, api.response.body={}, api.response.time-consuming={}s",
                    logName, response.getCode(), response.getBody(), (System.currentTimeMillis() - start) / 1000);
            return response.getData();
        } catch (ApiException e) {
            LOGGER.error("-----[{}] response.error={}", logName, e.toSimpleJsonStr(), e);
            throw e;
        }
    }

    public <T> ApiResponse<T> doPostJson(String url, Map<String, String> headers, String body, ApiReturnType<T> returnType) throws ApiException {
        ApiRequester requester = new ApiRequester.Builder()
                .httpMethod(HttpMethod.POST)
                .url(url)
                .headers(headers)
                .body(body)
                .build();
        return this.doExecute(requester, returnType);
    }

    /*----------------------------------------------------------execute----------------------------------------------------------*/

    protected <T> ApiResponse<T> doExecute(ApiRequester requester, ApiReturnType<T> returnType) throws ApiException {
        try {
            String responseBody = this.execute(requester);
            this.handleResponse(responseBody);
            return new ApiResponse<>(ApiResponse.SUCCESS_CODE, responseBody, this.deserialize(responseBody, returnType));
        } catch (ApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ApiException(e.getMessage(), e);
        }
    }

    protected String execute(ApiRequester requester) throws Exception {
        switch (requester.getHttpMethod()) {
            case POST:
                return HttpUtils.httpPostJson(requester.getUrl(), this.convertMap(requester.getHeaders()), requester.getBody());
            case PUT:
                return HttpUtils.httpPutJson(requester.getUrl(), this.convertMap(requester.getHeaders()), requester.getBody());
            case DELETE:
                return HttpUtils.httpDel(requester.getUrl(), this.convertMap(requester.getHeaders()));
            default:
                return HttpUtils.httpGet(requester.getUrl(), this.convertMap(requester.getHeaders()), requester.getQueryString());
        }
    }

    protected void handleResponse(String responseBody) throws ApiException {
        if (StringUtils.isBlank(responseBody)) {
            throw new ApiException("No response body", responseBody);
        }
        if (!this.validJson(responseBody)) {
            throw new ApiException("Error response body", responseBody);
        }
    }

    protected <T> T deserialize(String responseBody, ApiReturnType<T> returnType) {
        if (returnType == null || returnType.getType() == null) {
            return null;
        }
        switch (returnType.getType()) {
            case Class:
                return JSON.parseObject(responseBody, returnType.getTypeClass());
            case TypeReference:
                return JSON.parseObject(responseBody, returnType.getTypeReference());
            default:
                return null;
        }
    }

    protected String withQueryString(Map<String, String> queryParams) {
        if (ObjectUtils.isEmpty(queryParams)) {
            return null;
        }
        StringBuilder queryString = new StringBuilder();
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            if (ObjectUtils.isEmpty(entry.getKey())) {
                continue;
            }
            queryString.append(entry.getKey()).append("=");
            if (StringUtils.isNotBlank(entry.getValue())) {
                queryString.append(entry.getValue());
            }
            queryString.append("&");
        }
        return queryString.substring(0, queryString.length() - 1);
    }

    protected String withQueryString(String url, Map<String, String> queryParams) {
        String queryString = withQueryString(queryParams);
        if (url.endsWith("?")) {
            return url + queryString;
        }
        if (url.contains("=")) {
            return url + "&" + queryString;
        }
        return url + "?" + queryString;
    }

    protected Map<String, Object> convertMap(Map<String, String> stringMap) {
        Map<String, Object> objectMap = new HashMap<>();
        if (stringMap == null) {
            return objectMap;
        }
        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            objectMap.put(entry.getKey(), entry.getValue());
        }
        return objectMap;
    }

    protected boolean validJson(String str) {
        try {
            JSON.parse(str);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public static void main(String[] args) {

    }

}

