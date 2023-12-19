package com.mudxx.cloud.gcore.services.client;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mudxx.cloud.gcore.common.api.CcoreApiCodeEnum;
import com.mudxx.cloud.gcore.common.api.GcoreApiClient;
import com.mudxx.cloud.gcore.common.constants.GcoreConstants;
import com.mudxx.cloud.gcore.model.request.GcoreCdnPrefetchCreateRequest;
import com.mudxx.cloud.gcore.model.request.GcoreCdnPurgeCreateRequest;
import com.mudxx.cloud.gcore.model.request.GcoreCdnStatSeriesRequest;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.api.ApiReturnType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/19 13:44
 */
public class GcoreCdnApiClient {

    private final GcoreApiClient apiClient;

    private final String apiHost;

    private final Map<String, String> apiHeaders;

    public GcoreCdnApiClient(String apiHost, Map<String, String> apiHeaders) {
        this.apiClient = new GcoreApiClient(10L, 30L, 30L);
        this.apiHost = apiHost;
        this.apiHeaders = apiHeaders;
    }

    /**
     * 创建清除请求
     * <p>
     * o 清除所有缓存 - 每分钟对 CDN 资源发出一个清除请求。
     * 一个空数组
     * <p>
     * o 按 URL 清除 - 每分钟对 CDN 资源发出两个清除请求。一个清除请求限制为 100 个 URL。
     * 规则：/pictures/icon.jpg?size=small
     * 以斜杠 （/） 开头。
     * 不包括协议、域名或通配符 （*）。
     * 如果将 CDN 资源缓存配置为考虑查询字符串，则包括查询字符串
     * <p>
     * o 按模式清除 - 每分钟对 CDN 资源发出一个清除请求。一个清除请求限制为 10 个模式。
     * 以 * 或 / 符号开头的一个或多个内容模式的数组
     */
    public void createCdnPurge(String cdnId, GcoreCdnPurgeCreateRequest request) throws ApiException {
        String url = apiHost + String.format("/cdn/resources/%s/purge", cdnId);
        Map<String, List<String>> params = new HashMap<>();
        switch (request.getTypeEnum()) {
            case CODE_1:
                params.put("urls", request.getValues());
                break;
            case CODE_2:
                params.put("paths", request.getValues());
                break;
            case CODE_3:
                params.put("paths", new ArrayList<>());
                break;
            default:
                break;
        }
        String logName = "GCORE-CDN-createCdnPurge-" + System.currentTimeMillis();
        this.apiClient.doPostJson(
                url,
                apiHeaders,
                JSON.toJSONString(params),
                logName
        );
    }

    /**
     * 创建预热请求
     * <p>
     * o 建议仅对大于 200 MB 且小于 5 GB 的文件进行预取。
     * <p>
     * o 每分钟可以对 CDN 资源发出一个预取请求。一个预取请求最多只能包含 100 个文件路径。
     * <p>
     * o 过程的时间取决于文件的数量和大小。
     * <p>
     * o 如果需要更新存储在 CDN 中的文件，请先清除这些文件，然后再预取。
     */
    public void createCdnPrefetch(String cdnId, GcoreCdnPrefetchCreateRequest request) throws ApiException {
        String url = apiHost + String.format("/cdn/resources/%s/prefetch", cdnId);
        String params = JSON.toJSONString(request);
        String logName = "GCORE-CDN-createCdnPrefetch-" + System.currentTimeMillis();
        this.apiClient.doPostJson(
                url,
                apiHeaders,
                params,
                logName
        );
    }

    /**
     * CDN资源统计
     * <p>
     * o 获取最多 90 天的 CDN 资源统计信息
     * <p>
     * o 建议至少在两天后接收统计信息
     *
     * @param returnType 输出数据分组不同会导致返回格式不一,需自定义实现
     * @return 若请求的时间段内没有数据则返回null对象
     */
    public <T> T statCdnSeries(GcoreCdnStatSeriesRequest request, ApiReturnType<T> returnType) throws ApiException {
        String url = apiHost + "/cdn/statistics/series";
        request.setService(GcoreConstants.CDN_SERVICE);
        if (DateUtil.parseUTC(request.getFrom()).compareTo(DateUtil.parseUTC(request.getTo())) >= 0) {
            throw new ApiException(
                    CcoreApiCodeEnum.C_400.getCode(),
                    CcoreApiCodeEnum.C_400.getDetails("请求的开始时间段必须小于请求的结束时间段"),
                    null,
                    null);
        }
        Map<String, String> queryParams = JSON.parseObject(JSON.toJSONString(request), new TypeReference<Map<String, String>>() {
        });
        String logName = "GCORE-CDN-statCdnSeries-" + System.currentTimeMillis();
        return this.apiClient.doGet(
                url,
                apiHeaders,
                queryParams,
                returnType,
                logName
        );
    }

}
