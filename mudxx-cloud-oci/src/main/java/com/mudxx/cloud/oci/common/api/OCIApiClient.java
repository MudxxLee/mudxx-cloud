package com.mudxx.cloud.oci.common.api;

import com.mudxx.cloud.oci.common.util.JsonUtil;
import com.oracle.bmc.model.BmcException;
import com.oracle.bmc.responses.BmcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author laiw
 * @date 2023/8/18 11:18
 */
public class OCIApiClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(OCIApiClient.class);

    private static final int HTTP_SUCCESS_CODE = 200;

    public <R> BmcResponse doExecute(Function<R, BmcResponse> invokeMethod, R request, String logName)
            throws OCIApiException {
        BmcResponse response;
        try {
            LOGGER.info("-----[{}] invoke.request={}", logName, JsonUtil.toJsonStrMelody(request,
                    "invocationCallback", "retryConfiguration", "body$"));
            response = this.doExecute(invokeMethod, request);
            LOGGER.info("-----[{}] invoke.response={}", logName, JsonUtil.toJsonStrMelody(response,
                    "headers"));
        } catch (OCIApiException e) {
            LOGGER.error("-----[{}] invoke.error={}", logName, e.toSimpleJsonStr(), e);
            throw e;
        }
        return response;
    }

    public <R> BmcResponse doExecute(Function<R, BmcResponse> invokeMethod, R request)
            throws OCIApiException {
        BmcResponse response = this.doFunction(invokeMethod, request);
        this.handleResponse(response);
        return response;
    }

    protected <R> BmcResponse doFunction(Function<R, BmcResponse> invokeMethod, R request)
            throws OCIApiException {
        BmcResponse response;
        try {
            response = invokeMethod.apply(request);
        } catch (BmcException e) {
            throw new OCIApiException(e.getStatusCode(), e.getUnmodifiedMessage(), e);
        } catch (Exception e) {
            throw new OCIApiException(e.getMessage(), e);
        }
        return response;
    }

    protected void handleResponse(BmcResponse response) throws OCIApiException {
        if (response == null) {
            throw new OCIApiException("No response", (Map<String, List<String>>) null);
        }
        if (HTTP_SUCCESS_CODE != response.get__httpStatusCode__()) {
            throw new OCIApiException("Error response", response.getHeaders());
        }
    }

}
