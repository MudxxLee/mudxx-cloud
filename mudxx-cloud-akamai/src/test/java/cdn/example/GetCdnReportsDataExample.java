package cdn.example;

import cdn.ApiBuilder;
import cn.hutool.core.date.DateUtil;
import com.mudxx.cloud.akamai.model.entity.AkamaiCdnReportsBodyParams;
import com.mudxx.cloud.akamai.model.entity.AkamaiCdnReportsDataHhbt;
import com.mudxx.cloud.akamai.model.entity.AkamaiCdnReportsFilters;
import com.mudxx.cloud.akamai.model.entity.AkamaiCdnReportsQueryParams;
import com.mudxx.cloud.akamai.model.enums.AkamaiCdnIntervalEnum;
import com.mudxx.cloud.akamai.model.enums.AkamaiCdnReportsDataTypeEnum;
import com.mudxx.cloud.akamai.model.request.AkamaiCdnReportsDataGetRequest;
import com.mudxx.cloud.akamai.model.response.AkamaiCdnReportsDataGetResponse;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.utils.date.DateUtc;
import com.mudxx.common.utils.json.JsonStrUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/12/15 17:01
 */
public class GetCdnReportsDataExample {

    private static final AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();
    private static final String start = "2023-12-18 09:50:00";
    private static final String end = "2023-12-18 10:00:00";

    @Test
    public void test1() {
        AkamaiCdnReportsDataGetResponse<AkamaiCdnReportsDataHhbt> response =
                getCdnReportsData(AkamaiCdnReportsDataTypeEnum.HOSTNAME_HITS_BY_TIME);
        System.out.println(JsonStrUtil.toJsonStrMelody(response));
    }

    @Test
    public void test2() {
        AkamaiCdnReportsDataGetResponse<Map<String, Object>> response =
                getCdnReportsData(AkamaiCdnReportsDataTypeEnum.HOSTNAME_BYTES_BY_TIME);
        System.out.println(JsonStrUtil.toJsonStrMelody(response));
    }

    @Test
    public void test3() {
        AkamaiCdnReportsDataGetResponse<Map<String, Object>> response =
                getCdnReportsData(AkamaiCdnReportsDataTypeEnum.HOSTNAME_TRAFFIC_BY_TIME_AND_RESPONSE_CLASS);
        System.out.println(JsonStrUtil.toJsonStrMelody(response));
    }

    private <T> AkamaiCdnReportsDataGetResponse<T> getCdnReportsData(AkamaiCdnReportsDataTypeEnum typeEnum) {
        AkamaiCdnReportsQueryParams queryParams = new AkamaiCdnReportsQueryParams.Builder()
                .start(DateUtc.formatSssZ(DateUtc.ofUtc(DateUtil.parseDateTime(start).getTime())))
                .end(DateUtc.formatSssZ(DateUtc.ofUtc(DateUtil.parseDateTime(end).getTime())))
                .interval(AkamaiCdnIntervalEnum.FIVE_MINUTES.getCode())
                .build();
        List<String> objectIds = new ArrayList<>();
        objectIds.add("1570849");
        List<String> metrics = new ArrayList<>();
//        metrics.add("edgeHitsPerSecond");
//        metrics.add("maxEdgeHits");
//        metrics.add("edgeBytesTotal");
        AkamaiCdnReportsFilters filters = new AkamaiCdnReportsFilters.Builder()
//                .hostnameMatch(Stream.of("laiw1-akamai.agilewingcdn-demo.com").collect(Collectors.toList()))
                .build();
        AkamaiCdnReportsBodyParams bodyParams = new AkamaiCdnReportsBodyParams.Builder()
                .objectIds(objectIds)
                .metrics(metrics)
                .filters(filters)
                .build();
        AkamaiCdnReportsDataGetRequest request = new AkamaiCdnReportsDataGetRequest.Builder()
                .queryParams(queryParams)
                .bodyParams(bodyParams)
                .build();
        try {
            return apiClient.getCdnReportsData(
                    typeEnum,
                    request
            );
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return null;
    }

}
