package com.mudxx.cloud.akamai.common.api;

import cn.hutool.core.util.EnumUtil;
import com.mudxx.cloud.akamai.model.entity.AkamaiCredential;
import com.mudxx.cloud.akamai.model.entity.AkamaiRequester;
import com.mudxx.cloud.akamai.services.auth.AkamaiAuthProvider;
import com.mudxx.common.api.ApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.api.ApiReturnType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/19 13:44
 */
public class AkamaiApiClient extends ApiClient {

    private final AkamaiCredential credential;

    public AkamaiApiClient(AkamaiCredential credential) {
        this.credential = credential;
    }

    public AkamaiApiClient(long connectTimeout, long readTimeout, long writeTimeout, AkamaiCredential credential) {
        super(connectTimeout, readTimeout, writeTimeout);
        this.credential = credential;
    }

    public AkamaiCredential getCredential() {
        return credential;
    }

    @Override
    public <T> T doGet(String urlString, Map<String, String> headers, Map<String, String> queryParams,
                       ApiReturnType<T> returnType, String logName) throws ApiException {
        return this.doGet(this.withQueryString(urlString, queryParams), headers, returnType, logName);
    }

    @Override
    public <T> T doGet(String urlString, Map<String, String> headers,
                       ApiReturnType<T> returnType, String logName) throws ApiException {
        this.setAuthorization(this.buildGet(urlString, headers), headers);
        return super.doGet(urlString, headers, returnType, logName);
    }

    @Override
    public <T> T doPostJson(String url, Map<String, String> headers, Map<String, String> queryParams,
                            String params, ApiReturnType<T> returnType, String logName) throws ApiException {
        return this.doPostJson(this.withQueryString(url, queryParams), headers, params, returnType, logName);
    }

    @Override
    public <T> T doPostJson(String url, Map<String, String> headers, String params,
                            ApiReturnType<T> returnType, String logName) throws ApiException {
        this.setAuthorization(this.buildPost(url, headers, params), headers);
        return super.doPostJson(url, headers, params, returnType, logName);
    }

    @Override
    public String handleResponse(Response response) throws ApiException {
        if (!response.isSuccessful()) {
            AkamaiApiCodeEnum anEnum = EnumUtil.getBy(AkamaiApiCodeEnum::getCode, response.code());
            if (anEnum == null) {
                throw new ApiException(response.code(), response.message(), response.headers().toMultimap());
            }
            throw new ApiException(anEnum.getCode(), anEnum.getDetails(response.message()), response.headers().toMultimap());
        }
        String responseBody = null;
        try {
            ResponseBody body = response.body();
            if (body != null) {
                responseBody = body.string();
            }
        } catch (IOException ignore) {
            // ignore
        }
        if (StringUtils.isNotBlank(responseBody)) {
            if (!this.validJson(responseBody)) {
                throw new ApiException(AkamaiApiCodeEnum.C_500.getCode(), AkamaiApiCodeEnum.C_500.getDetails("Error response body"),
                        response.headers().toMultimap(), responseBody);
            }
        }
        return responseBody;
    }

    /**
     * 设置授权头
     */
    private void setAuthorization(AkamaiRequester requester, Map<String, String> headers) {
        headers.put("Authorization", AkamaiAuthProvider.buildAuthorization(requester, credential));
    }

    private AkamaiRequester buildGet(String urlString, Map<String, String> headers) {
        return new AkamaiRequester.Builder()
                .uri(urlString)
                .method("GET")
                .headers(headers)
                .body(new byte[0])
                .build();
    }

    private AkamaiRequester buildPost(String url, Map<String, String> headers, String params) {
        return new AkamaiRequester.Builder()
                .uri(url)
                .method("POST")
                .headers(headers)
                .body(params.getBytes(StandardCharsets.UTF_8))
                .build();
    }
}
