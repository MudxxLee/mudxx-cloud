package com.mudxx.cloud.gcore.common.api;

import cn.hutool.core.util.EnumUtil;
import com.mudxx.common.api.ApiClient;
import com.mudxx.common.api.ApiException;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author laiw
 * @date 2023/10/19 13:44
 */
public class GcoreApiClient extends ApiClient {

    public GcoreApiClient(long connectTimeout, long readTimeout, long writeTimeout) {
        super(connectTimeout, readTimeout, writeTimeout);
    }

    @Override
    public String handleResponse(Response response) throws ApiException {
        if (!response.isSuccessful()) {
            CcoreApiCodeEnum anEnum = EnumUtil.getBy(CcoreApiCodeEnum::getCode, response.code());
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
                throw new ApiException(CcoreApiCodeEnum.C_500.getCode(), CcoreApiCodeEnum.C_500.getDetails("Error response body"),
                        response.headers().toMultimap(), responseBody);
            }
        }
        return responseBody;
    }

}
