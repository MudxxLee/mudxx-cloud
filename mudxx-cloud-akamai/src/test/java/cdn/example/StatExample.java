package cdn.example;

import cdn.ApiBuilder;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.mudxx.cloud.akamai.model.enums.AkamaiCdnIntervalEnum;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.api.ApiReturnType;
import com.mudxx.common.utils.date.DateUtc;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author laiw
 * @date 2023/12/11 15:33
 */
public class StatExample {

//    private static final String start = "2023-12-15 10:10:00";
//    private static final String end = "2023-12-15 10:20:00";

//    private static final String start = "2023-12-17 08:00:00";
//    private static final String end = "2023-12-17 18:00:00";

//    private static final String start = "2023-12-18 09:50:00";
//    private static final String end = "2023-12-18 10:00:00";

//    private static final String start = "2024-01-15 16:40:00";
//    private static final String end = "2024-01-15 16:50:00";

//    private static final String start = "2024-01-16 18:10:00";
//    private static final String end = "2024-01-16 18:20:00";

//    private static final String start = "2024-01-16 19:10:00";
//    private static final String end = "2024-01-16 19:15:00";

//    private static final String start = "2024-01-22 14:30:00";
//    private static final String end = "2024-01-22 14:35:00";

//    private static final String start = "2024-01-22 15:05:00";
//    private static final String end = "2024-01-22 15:10:00";

    private static final String start = "2024-01-26 14:25:00";
    private static final String end = "2024-01-26 14:30:00";

//
//    private static final String start = "2024-01-26 16:15:00";
//    private static final String end = "2024-01-26 16:30:00";

    @Test
    public void test1() {
        // 请求数-按时间分组
        doPostJson("https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/reporting-api/v1/reports/hostname-hits-by-time/versions/2/report-data");
    }

    @Test
    public void test2() {
        // 字节-按时间分组
        doPostJson("https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/reporting-api/v1/reports/hostname-bytes-by-time/versions/2/report-data");
    }

    @Test
    public void test3() {
        // 请求数-按时间&状态码分组
        doPostJson("https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/reporting-api/v1/reports/hostname-traffic-by-timeandresponseclass/versions/2/report-data");
    }

    @Test
    public void test4() {
        // 请求数(含回源)-按时间分组
        doPostJson("https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/reporting-api/v1/reports/hits-by-time/versions/1/report-data");
    }

    @Test
    public void test5() {
        // 字节(含回源)-按时间分组
        doPostJson("https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/reporting-api/v1/reports/bytes-by-time/versions/1/report-data");
    }

    @Test
    public void test6() {
        // 字节(含回源)-按时间分组
        doPostJson("https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/reporting-api/v1/reports/todaytraffic-by-time/versions/1/report-data");
    }

    public static void doPostJson(String url) {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("start", DateUtc.formatSssZ(DateUtc.ofUtc(DateUtil.parseDateTime(start).getTime())));
        queryParams.put("end", DateUtc.formatSssZ(DateUtc.ofUtc(DateUtil.parseDateTime(end).getTime())));
        queryParams.put("interval", AkamaiCdnIntervalEnum.FIVE_MINUTES.getCode());

        Map<String, Object> params = new HashMap<>();
        List<String> objectIds = new ArrayList<>();
//        objectIds.add("1570849");
        objectIds.add("1582946");
        params.put("objectIds", objectIds);
//        List<String> metrics = new ArrayList<>();
//        metrics.add("edgeHitsPerSecond");
//        metrics.add("maxEdgeHits");
//        metrics.add("edgeBytesTotal");
//        params.put("metrics", metrics);
        Map<String, List<Object>> filters = new HashMap<>();
//        filters.put("hostname_match", Stream.of("laiw1-akamai.agilewingcdn-demo.com").collect(Collectors.toList()));
//        filters.put("traffic", Stream.of("all_responses").collect(Collectors.toList()));
//        filters.put("traffic", Stream.of("get_head_responses").collect(Collectors.toList()));
//        filters.put("delivery_type", Stream.of("non_secure").collect(Collectors.toList()));
//        filters.put("response_class", Stream.of("2xx").collect(Collectors.toList()));

        params.put("filters", filters);

        String urlString = apiClient.getApiClient().withQueryString(url, queryParams);
        String logName = "test-" + System.currentTimeMillis();
        String result = null;
        try {
            result = apiClient.getApiClient().doPostJson(
                    urlString,
                    headers,
                    JSON.toJSONString(params),
                    new ApiReturnType<>(String.class),
                    logName
            );
        } catch (ApiException e) {
            e.printStackTrace();
            System.out.println(e.toSimpleJsonStr());
        }
        System.out.println(result);
    }

}
