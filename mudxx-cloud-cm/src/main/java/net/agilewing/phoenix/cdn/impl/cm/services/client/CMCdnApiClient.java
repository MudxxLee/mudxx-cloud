package net.agilewing.phoenix.cdn.impl.cm.services.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mudxx.cloud.biz.common.api.ApiClient;
import com.mudxx.cloud.biz.common.api.ApiException;
import com.mudxx.cloud.biz.common.api.ApiReturnType;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnPreloadTaskInfo;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnRefreshTaskInfo;
import net.agilewing.phoenix.cdn.impl.cm.model.request.*;
import net.agilewing.phoenix.cdn.impl.cm.model.response.*;
import net.agilewing.phoenix.cdn.impl.cm.services.auth.CMAuthHeaders;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/19 13:44
 */
public class CMCdnApiClient {

    private final ApiClient apiClient;

    private final String apiHost;

    private final Map<String, String> apiHeaders;

    public CMCdnApiClient(String apiHost, Map<String, String> apiHeaders) {
        this.apiClient = new ApiClient();
        this.apiHost = apiHost;
        this.apiHeaders = apiHeaders;
    }

    public CMCdnApiClient(String apiHost, String appId, String appSecret) {
        this(apiHost, CMAuthHeaders.buildHeaders(appId, appSecret));
    }

    /**
     * 新增加速域名
     * <p>
     * o 单个用户一分钟限制调用 10 次
     * <p>
     * o 该域名必须已成功备案
     */
    public CMCdnDomainAddResponse addCdnDomain(CMCdnDomainAddRequest request) throws ApiException {
        String url = apiHost + "/cdn/domain_manage";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-addCdnDomain-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(CMCdnDomainAddResponse.class),
                logName
        );
    }

    /**
     * 增量修改域名配置(产生在途工单)
     * <p>
     * o 修改配置 涉及全网下发 一般是5～15分钟会自动生效
     * <p>
     * o 单个用户一分钟限制调用 10 次
     * <p>
     * o 修改域名之前，您需要先开通对应产品类型的服务，且保证资源包/按需服务有效
     * <p>
     * o 该域名没有在途工单
     */
    public CMResponse modifyCdnDomain(CMCdnDomainModifyRequest request) throws ApiException {
        String url = apiHost + "/cdn/incre_update";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-modifyCdnDomain-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(CMResponse.class),
                logName
        );
    }

    /**
     * 删除/启用/停用域名(产生在途工单)
     * <p>
     * o 删除域名前，先确保域名是已停用状态
     * <p>
     * o 停用域名前，先确保域名是已启用状态
     * <p>
     * o 启用域名前，先确保域名是已停用状态，且域名备案已通过
     * <p>
     * o 单个用户一分钟限制调用 10 次
     */
    public CMResponse changeCdnDomainStatus(CMCdnDomainChangeStatusRequest request) throws ApiException {
        String url = apiHost + "/cdn/change_domain_status";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-changeCdnDomainStatus-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(CMResponse.class),
                logName
        );
    }

    /**
     * 查询域名配置信息
     * <p>
     * o 单个用户一分钟限制调用 10000 次，并发不超过 100
     */
    public CMCdnDomainGetResponse getCdnDomain(String domain) throws ApiException {
        String url = apiHost + "/cdn/domain_info";
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("domain", domain);
        String logName = "CM-CDN-getCdnDomain-" + System.currentTimeMillis();
        return this.apiClient.doGet(
                url,
                apiHeaders,
                queryParams,
                new ApiReturnType<>(CMCdnDomainGetResponse.class),
                logName
        );
    }

    /**
     * 查询域名列表及域名的基础信息
     * <p>
     * o 单个用户一分钟限制调用 10000 次，并发不超过 100
     */
    public CMCdnDomainListResponse listCdnDomains(CMCdnDomainListRequest request) throws ApiException {
        String url = apiHost + "/cdn/domain_query";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-listCdnDomains-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(CMCdnDomainListResponse.class),
                logName
        );
    }

    /**
     * 查询域名是否存在在途工单
     * <p>
     * o 单个用户一分钟限制调用 10000 次
     * <p>
     * o 并发不超过 100
     */
    public CMCdnOnWayOrderGetResponse getCdnOnWayOrder(String domain) throws ApiException {
        String urlString = apiHost + "/cdn/is_exist_onway_order";
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("domain", domain);
        String logName = "CM-CDN-getCdnOnWayOrder-" + System.currentTimeMillis();
        return this.apiClient.doGet(
                urlString,
                apiHeaders,
                queryParams,
                new ApiReturnType<>(CMCdnOnWayOrderGetResponse.class),
                logName
        );
    }

    /**
     * 创建刷新任务
     * <p>
     * o 单个用户一分钟限制调用 10000 次，并发不超过 100
     */
    public CMCdnRefreshTaskAddResponse addCdnRefreshTask(CMCdnRefreshTaskAddRequest request) throws ApiException {
        String url = apiHost + "/cdn/refreshmanage_create";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-addCdnRefreshTask-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(CMCdnRefreshTaskAddResponse.class),
                logName
        );
    }

    /**
     * 查询刷新任务
     * <p>
     * o 单个用户一分钟限制调用 10000 次，并发不超过 100
     */
    public CMPageResponse<CMCdnRefreshTaskInfo> listCdnRefreshTasks(CMCdnRefreshTaskListRequest request) throws ApiException {
        String url = apiHost + "/cdn/refreshmanage_query";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-listCdnRefreshTasks-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(new TypeReference<CMPageResponse<CMCdnRefreshTaskInfo>>() {
                }),
                logName
        );
    }

    /**
     * 创建预热任务
     * <p>
     * o 单个用户一分钟限制调用 10000 次，并发不超过 100
     */
    public CMCdnPreloadTaskAddResponse addCdnPreloadTask(CMCdnPreloadTaskAddRequest request) throws ApiException {
        String url = apiHost + "/cdn/preloadmanage_create";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-addCdnPreloadTask-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(CMCdnPreloadTaskAddResponse.class),
                logName
        );
    }

    /**
     * 查询预热任务
     * <p>
     * o 单个用户一分钟限制调用 10000 次，并发不超过 100
     */
    public CMPageResponse<CMCdnPreloadTaskInfo> listCdnPreloadTasks(CMCdnPreloadTaskListRequest request) throws ApiException {
        String url = apiHost + "/cdn/preloadmanage_query";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-listCdnPreloadTasks-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(new TypeReference<CMPageResponse<CMCdnPreloadTaskInfo>>() {
                }),
                logName
        );
    }

    /**
     * 查询请求数,回源请求数,请求命中率数据
     * <p>
     * o 单个用户一分钟限制调用 10000 次，并发不超过 100
     * <p>
     * o 单次查询输入域名的个数不能超过 100 个
     * <p>
     * o 单次查询输入结果聚合维度（group_by）的个数不能超过 4 个
     * <p>
     * o 时间粒度为 24h 时，查询开始时间与结束时间需要跨天
     * <p>
     * o 若查询结束时间不包含在该批次的最后一秒，默认 end_time 为该批次最后一秒，
     * 例如：时间粒度为 1h，end_time 设置为 17:30 对应的时间戳，此时 end_time 默认成 17:59:59
     * <p>
     * o 时间片统计数据均为前打点，假如请求 5 分钟粒度数据，time_stamp= "2021-10-13 00:00"对应的时间戳，
     * 表示统计的数据为时间区间[2021-10-13 00:00, 2021-10-13 00:05)
     * o 根据请求参数时间粒度（Interval）和聚合维度（group_by）个数的不同，单次请求可查询历史数据范围，数据延迟， 支持最大的时间跨度均不同，对应如下：
     * 时间粒度     可查询历史数据时间范围     数据延迟    2 ≥ 聚合维度个数 ≥ 0 ，支持最大时间跨度    4 ≥ 聚合维度个数 ＞2 支持最大的时间跨度
     * 1m           最近 31 天               5 分钟      7 天                                     3 小时
     * 5m           最近 183 天              20 分钟     31 天                                    1 天
     * 1h           最近 183 天              20 分钟     93 天                                    3 天
     * 24h          最近 183 天              20 分钟     93 天                                    3 天
     */
    public CMCdnReqNumDataListResponse listCdnReqNumData(CMCdnReqNumDataListRequest request) throws ApiException {
        String url = apiHost + "/cdn/query_request_num_data";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-listCdnReqNumData-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(CMCdnReqNumDataListResponse.class),
                logName
        );
    }

    /**
     * 查询流量，命中流量，流量命中率，回源流量数据
     * <p>
     * o 单个用户一分钟限制调用 10000 次，并发不超过 100
     * <p>
     * o 单次查询输入域名的个数不能超过 100 个
     * <p>
     * o 单次查询输入结果聚合维度（group_by）的个数不能超过 4 个
     * <p>
     * o 时间粒度为 24h 时，查询开始时间与结束时间需要跨天
     * <p>
     * o 若查询结束时间不包含在该批次的最后一秒，默认 end_time 为该批次最后一秒，例如：时间粒度为
     * 1h，end_time 设置为 17:30 对应的时间戳，此时 end_time 默认成 17:59:59
     * <p>
     * o 时间片统计数据均为前打点，假如请求 5 分钟粒度数据，time_stamp= "2021-10-13 00:00"对应的时间
     * 戳，表示统计的数据为时间区间[2021-10-13 00:00, 2021-10-13 00:05)
     * <p>
     * o 根据请求参数时间粒度（Interval）和聚合维度（group_by）个数的不同，单次请求可查询历史数据范围，数据延迟， 支持最大的时间跨度均不同，对应如下：
     * 时间粒度     可查询历史数据时间范围     数据延迟    2 ≥ 聚合维度个数 ≥ 0 ，支持最大时间跨度    4 ≥ 聚合维度个数 ＞2 支持最大的时间跨度
     * 1m           最近 31 天               5 分钟      7 天                                     3 小时
     * 5m           最近 183 天              20 分钟     31 天                                    1 天
     * 1h           最近 183 天              20 分钟     93 天                                    3 天
     * 24h          最近 183 天              20 分钟     93 天                                    3 天
     */
    public CMCdnReqHitFlowRateDataListResponse listCdnReqHitFlowRateData(
            CMCdnReqHitFlowRateDataListRequest request) throws ApiException {
        String url = apiHost + "/cdn/query_hit_flow_rate_data_by_domain";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-listCdnReqHitFlowRateData-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(CMCdnReqHitFlowRateDataListResponse.class),
                logName
        );
    }

    /**
     * 查询状态码请求数，请求状态码占比
     * <p>
     * o 单个用户一分钟限制调用 10000 次，并发不超过 100
     * <p>
     * o 单次查询输入域名的个数不能超过 100 个
     * <p>
     * o 单次查询输入结果聚合维度（group_by）的个数不能超过 4 个
     * <p>
     * o 时间粒度为 24h 时，查询开始时间与结束时间需要跨天
     * <p>
     * o 若查询结束时间不包含在该批次的最后一秒，默认 end_time 为该批次最后一秒，
     * 例如：时间粒度为1h，end_time 设置为 17:30 对应的时间戳，此时 end_time 默认成 17:59:59
     * <p>
     * o 时间片统计数据均为前打点，假如请求 5 分钟粒度数据，time_stamp= "2021-10-13 00:00"对应的时间戳，
     * 表示统计的数据为时间区间[2021-10-13 00:00, 2021-10-13 00:05)
     * <p>
     * o 根据请求参数时间粒度（Interval）和聚合维度（group_by）个数的不同，单次请求可查询历史数据范围，数据延迟， 支持最大的时间跨度均不同，对应如下：
     * 时间粒度     可查询历史数据时间范围    数据延迟    2 ≥ 聚合维度个数 ≥ 0 ，支持最大时间跨度    4 ≥ 聚合维度个数 ＞2 支持最大的时间跨度
     * 1m           最近 31 天             5 分钟       7 天                                    3 小时
     * 5m           最近 183 天            20 分钟      31 天                                   1 天
     * 1h           最近 183 天            20 分钟      93 天                                   3 天
     * 24h          最近 183 天            20 分钟      93 天                                   3 天
     */
    public CMCdnReqHttpStatusCodeDataListResponse listCdnReqHttpStatusCodeData(
            CMCdnReqHttpStatusCodeDataListRequest request) throws ApiException {
        String url = apiHost + "/cdn/query_http_status_code_data";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-listCdnReqHttpStatusCodeData-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(CMCdnReqHttpStatusCodeDataListResponse.class),
                logName
        );
    }


    /**
     * 查询回源状态码请求数,回源状态码请求数占比数据
     * <p>
     * o 单个用户一分钟限制调用 10000 次，并发不超过 100
     * <p>
     * o 单次查询输入域名的个数不能超过 100 个
     * <p>
     * o 时间粒度为 24h 时，查询开始时间与结束时间需要跨天，否则查询的数据为空
     * <p>
     * o 最大返回记录 50000 条记录
     * <p>
     * o 若查询结束时间不包含在该批次的最后一秒，默认 end_time 为该批次最后一秒，
     * 例如：时间粒度为1h，end_time 设置为 17:30 对应的时间戳，此时 end_time 默认成 17:59:59
     * <p>
     * o 时间片统计数据均为前打点，假如请求 5 分钟粒度数据，time_stamp= "2021-10-13 00:00"对应的时间戳，
     * 表示统计的数据为时间区间[2021-10-13 00:00, 2021-10-13 00:05)
     * <p>
     * o 根据请求参数时间粒度（Interval）和聚合维度（group_by）个数的不同，单次请求可查询历史数据范围，数据延迟，
     * 支持最大的时间跨度均不同，对应如下，若开始时间超过可查询历史数据时间范围，超过部分的数据为 0：
     * 时间粒度     可查询历史数据时间范围     数据延迟          单次可查询的时间跨度
     * 1m           最近                    31 天 5 分钟       7 天
     * 5m           最近                    183 天 20 分钟     31 天
     * 1h           最近                    183 天 20 分钟     93 天
     * 24h          最近                    183 天 20 分钟     93 天
     */
    public CMCdnReqMissHttpStatusCodeDataListResponse listCdnReqMissHttpStatusCodeData(
            CMCdnReqMissHttpStatusCodeDataListRequest request) throws ApiException {
        String url = apiHost + "/cdn/query_miss_http_status_code_data";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-listCdnReqMissHttpStatusCodeData-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(CMCdnReqMissHttpStatusCodeDataListResponse.class),
                logName
        );
    }

    /**
     * 离线日志列表查询
     * <p>
     * o 单个用户一分钟限制调用 10000 次，并发不超过 100
     */
    public CMCdnLogListResponse listCdnLogs(CMCdnLogListRequest request) throws ApiException {
        String url = apiHost + "/cdn/log_bsstime_files";
        String params = JSON.toJSONString(request);
        String logName = "CM-CDN-listCdnLogs-" + System.currentTimeMillis();
        return this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                new ApiReturnType<>(CMCdnLogListResponse.class),
                logName
        );
    }

}
