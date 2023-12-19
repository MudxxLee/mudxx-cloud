package com.mudxx.cloud.akamai.services.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mudxx.cloud.akamai.common.api.AkamaiApiClient;
import com.mudxx.cloud.akamai.model.entity.AkamaiCdnReportsBodyParams;
import com.mudxx.cloud.akamai.model.entity.AkamaiCredential;
import com.mudxx.cloud.akamai.model.enums.AkamaiCdnIDPrefixesEnum;
import com.mudxx.cloud.akamai.model.enums.AkamaiCdnNetworkEnum;
import com.mudxx.cloud.akamai.model.enums.AkamaiCdnReportsDataTypeEnum;
import com.mudxx.cloud.akamai.model.request.*;
import com.mudxx.cloud.akamai.model.response.*;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.api.ApiReturnType;
import com.mudxx.common.utils.json.JsonUtil;

import java.util.*;

/**
 * @author laiw
 * @date 2023/10/19 13:44
 */
public class AkamaiCdnApiClient {

    private final AkamaiApiClient apiClient;

    private final String apiHost;

    private final Map<String, String> apiHeaders;

    public AkamaiCdnApiClient(String apiHost, AkamaiCredential credential) {
        this.apiClient = new AkamaiApiClient(10L, 30L, 30L, credential);
        this.apiHost = apiHost;
        this.apiHeaders = new HashMap<>();
        this.apiHeaders.put("accept", "application/json");
    }

    public AkamaiApiClient getApiClient() {
        return apiClient;
    }

    /**
     * 列出帐户主机名
     */
    public AkamaiCdnHostnameListResponse listCdnHostnames(AkamaiCdnHostnameListRequest request) throws ApiException {
        String url = apiHost + "/papi/v1/hostnames";
        apiHeaders.put("PAPI-Use-Prefixes", "true");
        Map<String, String> queryParams = JsonUtil.toMap(JsonUtil.toString(request), String.class, String.class);
        if (queryParams != null) {
            queryParams.entrySet().removeIf(entry -> entry.getValue() == null);
        }
        String logName = "AKAMAI-CDN-listCdnHostnames-" + System.currentTimeMillis();
        return this.apiClient.doGet(
                url,
                apiHeaders,
                queryParams,
                new ApiReturnType<>(AkamaiCdnHostnameListResponse.class),
                logName
        );
    }

    /**
     * 获取特定属性
     */
    public AkamaiCdnPropertiesGetResponse getCdnProperties(AkamaiCdnPropertiesGetRequest request) throws ApiException {
        String url = apiHost + "/papi/v1/properties/" + AkamaiCdnIDPrefixesEnum.PRP_.usePrefixes(request.getPropertyId());
        apiHeaders.put("PAPI-Use-Prefixes", "true");
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", AkamaiCdnIDPrefixesEnum.CTR_.usePrefixes(request.getContractId()));
        queryParams.put("groupId", AkamaiCdnIDPrefixesEnum.GRP_.usePrefixes(request.getGroupId()));
        String logName = "AKAMAI-CDN-getCdnProperties-" + System.currentTimeMillis();
        return this.apiClient.doGet(
                url,
                apiHeaders,
                queryParams,
                new ApiReturnType<>(AkamaiCdnPropertiesGetResponse.class),
                logName
        );
    }

    /**
     * 获取属性的规则树
     */
    public AkamaiCdnPropertiesRulesGetResponse getCdnPropertiesRules(AkamaiCdnPropertiesRulesGetRequest request) throws ApiException {
        String url = apiHost + String.format("/papi/v1/properties/%s/versions/%s/rules",
                AkamaiCdnIDPrefixesEnum.PRP_.usePrefixes(request.getPropertyId()), request.getPropertyVersion());
        apiHeaders.put("PAPI-Use-Prefixes", "true");
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", AkamaiCdnIDPrefixesEnum.CTR_.usePrefixes(request.getContractId()));
        queryParams.put("groupId", AkamaiCdnIDPrefixesEnum.GRP_.usePrefixes(request.getGroupId()));
        String logName = "AKAMAI-CDN-getCdnPropertiesRules-" + System.currentTimeMillis();
        return this.apiClient.doGet(
                url,
                apiHeaders,
                queryParams,
                new ApiReturnType<>(AkamaiCdnPropertiesRulesGetResponse.class),
                logName
        );
    }

    /**
     * 创建快速清除请求
     * <p>
     * - 清除 API 请求只能包含 URL/ARL、CP 代码或请求正文中的缓存标记
     * <p>
     * - 单个请求不能包含多个对象类型。
     * <p>
     * - 每个 API 请求使用 1 个 API 请求令牌。API 请求中的每个对象（URL/ARL、CP 代码或缓存标签）都使用上表中相应类型的 1 个令牌。
     * <p>
     * - 速率限制将应用于整个 Akamai 帐户中的所有 API 客户端。
     * <p>
     * - 例如，您账户中的 4 个 API 客户端，每个客户端同时提交 1 个包含 10 个 URL 的清除请求，将消耗 4 个请求令牌和 40 个 URL/ARL 令牌，以限制速率。
     * <p>
     * - 如果没有可用的请求令牌，或者没有足够的对象令牌来满足整个请求，则请求将被拒绝。如果请求被拒绝，则不会使用令牌，这会导致 429 错误。
     * <p>
     * - 清除请求的正文大小限制为 50KB。正文大小大于 50KB 的请求会导致 413 错误。
     * <p>
     * - 若要优化清除，请在单个请求中容纳尽可能多的对象/标记，同时遵守大小和速率限制。
     */
    public <T> AkamaiCdnPurgeCreateResponse createCdnPurge(AkamaiCdnPurgeCreateRequest<T> request,
                                                           AkamaiCdnNetworkEnum networkEnum) throws ApiException {
        String url = apiHost + String.format(request.getTypeEnum().getCode(), networkEnum.getCode());
        Map<String, List<T>> params = new HashMap<>(1);
        params.put("objects", request.getValues());
        String logName = "AKAMAI-CDN-createCdnPurge-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                JSON.toJSONString(params),
                new ApiReturnType<>(AkamaiCdnPurgeCreateResponse.class),
                logName
        );
    }

    /**
     * 列出 ECCU 请求的属性
     * <p>
     * 属性必须发布到生产才行
     */
    public AkamaiCdnECCUPropertiesListResponse listCdnECCUProperties() throws ApiException {
        String url = apiHost + "/eccu-api/v1/properties";
        String logName = "AKAMAI-CDN-listCdnECCUProperties-" + System.currentTimeMillis();
        return this.apiClient.doGet(
                url,
                apiHeaders,
                new ApiReturnType<>(AkamaiCdnECCUPropertiesListResponse.class),
                logName
        );
    }

    /**
     * 创建 ECCU 请求
     * <p>
     * 确保将匹配项数限制为 250 个或更少。一次提交超过 250 个失效请求可能会导致全局失效，即重新验证主机标头的所有内容。
     * <p>
     * 避免匹配单个或少数用户独有的内容。
     * <p>
     * 尝试每天提交少于 100 个请求。虽然在特定日期处理更多匹配项或请求不会导致任何事件，但持续超过建议的限制可能会导致性能下降，如及时刷新对象来衡量。
     * <p>
     * 请注意，ECCU 只会使内容失效。如果需要主动从缓存中删除任何对象，请使用其他清除类别。
     */
    public AkamaiCdnECCUCreateResponse createCdnECCU(AkamaiCdnECCUCreateRequest request) throws ApiException {
        String url = apiHost + "/eccu-api/v1/requests";
        String logName = "AKAMAI-CDN-createCdnECCU-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                JSON.toJSONString(request),
                new ApiReturnType<>(AkamaiCdnECCUCreateResponse.class),
                logName
        );
    }

    /**
     * 获取 ECCU 请求
     */
    public AkamaiCdnECCUGetResponse getCdnECCU(Long requestId) throws ApiException {
        String url = apiHost + "/eccu-api/v1/requests/" + requestId;
        String logName = "AKAMAI-CDN-getCdnECCU-" + System.currentTimeMillis();
        return this.apiClient.doGet(
                url,
                apiHeaders,
                new ApiReturnType<>(AkamaiCdnECCUGetResponse.class),
                logName
        );
    }

    /**
     * 获取报表数据
     * <p>
     * “Traffic by Hostname”报告近乎实时（5-10 分钟）查看基于日志的数据
     * <p>
     * 主机名报告的保留期为 92 天，从数据收集开始算起。数据从 2022 年 10 月 7 日开始提供。
     * <p>
     * 默认情况下，单个报告 API 端点的速率限制为每分钟 120 个请求，适用于给定端点的每个账户
     */
    public <T> AkamaiCdnReportsDataGetResponse<T> getCdnReportsData(AkamaiCdnReportsDataTypeEnum typeEnum,
                                                                    AkamaiCdnReportsDataGetRequest request) throws ApiException {
        String url = apiHost + String.format("/reporting-api/v1/reports/%s/versions/%s/report-data",
                typeEnum.getName(), typeEnum.getVersion());
        Map<String, String> queryParams = JsonUtil.toMap(JSON.toJSONString(request.getQueryParams()), String.class, String.class);
        AkamaiCdnReportsBodyParams bodyParams = request.getBodyParams();
        if (bodyParams.getMetrics() == null) {
            // 设置默认
            List<String> metrics = new ArrayList<>();
            Collections.addAll(metrics, typeEnum.getDataMetrics());
            Collections.addAll(metrics, typeEnum.getSummaryMetrics());
            bodyParams.setMetrics(metrics);
        }
        String logName = "AKAMAI-CDN-getCdnReportsData-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                queryParams,
                JSON.toJSONString(bodyParams),
                new ApiReturnType<>(new TypeReference<AkamaiCdnReportsDataGetResponse<T>>() {
                }),
                logName
        );
    }

}
