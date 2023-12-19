package cdn.domain.example;

import cdn.domain.ApiBuilder;
import cdn.domain.TestJson;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.gcore.model.enums.GcoreCdnGranularityEnum;
import com.mudxx.cloud.gcore.model.enums.GcoreCdnMetricsEnum;
import com.mudxx.cloud.gcore.model.enums.GcoreCdnStatSeriesGroupByEnum;
import com.mudxx.cloud.gcore.model.request.GcoreCdnStatSeriesRequest;
import com.mudxx.cloud.gcore.model.response.GcoreCdnStatSeriesResourceResponse;
import com.mudxx.cloud.gcore.model.response.GcoreCdnStatSeriesVhostResponse;
import com.mudxx.cloud.gcore.services.client.GcoreCdnApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.api.ApiReturnType;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class StatCdnSeriesExample {

    public static String localTimeToISO8601(LocalDateTime dateTime) {
        TimeZone utc = TimeZone.getTimeZone("UTC");
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        dft.setTimeZone(utc);
        return dft.format(Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()));
    }

    @Test
    public void test0() {
        DateTime dateTime = DateUtil.date();
        System.out.println(DateUtil.offsetDay(dateTime, -90).toString());
        System.out.println(dateTime.toString());
    }


    @Test
    public void test() throws ApiException {

        GcoreCdnApiClient client = ApiBuilder.build();

//        String from = "2023-11-28 17:15:00";
//        String to = "2023-11-28 17:20:00";

        String from = "2023-12-06 13:30:00";
        String to = "2023-12-06 14:00:00";

//        DateTime dateTime = DateUtil.date();
//        String from = DateUtil.offsetDay(dateTime, -90).toString();
//        String to = dateTime.toString();


//        请求数
        List<String> metrics = new ArrayList<>();
        metrics.add(GcoreCdnMetricsEnum.requests.getCode());
//        metrics.add(GcoreCdnMetricsEnum.responses_hit.getCode());
//        metrics.add(GcoreCdnMetricsEnum.responses_miss.getCode());
//        metrics.add(GcoreCdnMetricsEnum.cache_hit_requests_ratio.getCode());

        GcoreCdnStatSeriesRequest request = new GcoreCdnStatSeriesRequest.Builder()
                .from(localTimeToISO8601(DateUtil.parseLocalDateTime(from)))
                .to(localTimeToISO8601(DateUtil.parseLocalDateTime(to)))
                .granularity(GcoreCdnGranularityEnum.m_5.getCode())
                .metrics(String.join("&metrics=", metrics))
//                .groupBy(GcoreCdnStatSeriesGroupByEnum.resource.getCode())
                .groupBy(GcoreCdnStatSeriesGroupByEnum.vhost.getCode())
                .countries(null)
                .regions(null)
//                .resource("294320")
                .build();

        ApiReturnType<GcoreCdnStatSeriesVhostResponse> returnType = new ApiReturnType<>(GcoreCdnStatSeriesVhostResponse.class);

        GcoreCdnStatSeriesVhostResponse response = client.statCdnSeries(request, returnType);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));

        TestJson.printJson(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue), "vhost");
    }

    @Test
    public void test2() throws ApiException {

        GcoreCdnApiClient client = ApiBuilder.build();

//        String from = "2023-11-29 09:10:00";
//        String to = "2023-11-29 09:20:00";

        String from = "2023-10-30 13:55:00";
        String to = "2023-10-30 14:00:00";

//        流量
        List<String> metrics = new ArrayList<>();
        metrics.add(GcoreCdnMetricsEnum.sent_bytes.getCode());
        metrics.add(GcoreCdnMetricsEnum.shield_bytes.getCode());
        metrics.add(GcoreCdnMetricsEnum.upstream_bytes.getCode());
        metrics.add(GcoreCdnMetricsEnum.total_bytes.getCode());
        metrics.add(GcoreCdnMetricsEnum.cdn_bytes.getCode());
        GcoreCdnStatSeriesRequest request = new GcoreCdnStatSeriesRequest.Builder()
                .from(localTimeToISO8601(DateUtil.parseLocalDateTime(from)))
                .to(localTimeToISO8601(DateUtil.parseLocalDateTime(to)))
                .granularity(GcoreCdnGranularityEnum.m_5.getCode())
                .metrics(String.join("&metrics=", metrics))
                .groupBy(GcoreCdnStatSeriesGroupByEnum.resource.getCode())
                .countries(null)
                .regions(null)
                .resource("294320")
                .build();

        ApiReturnType<GcoreCdnStatSeriesResourceResponse> returnType = new ApiReturnType<>(GcoreCdnStatSeriesResourceResponse.class);

        GcoreCdnStatSeriesResourceResponse response = client.statCdnSeries(request, returnType);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));

        TestJson.printJson(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue), "resource");

    }

    @Test
    public void test3() throws ApiException {

        GcoreCdnApiClient client = ApiBuilder.build();

//        String from = "2023-11-28 17:15:00";
//        String to = "2023-11-28 17:20:00";

        String from = "2023-11-30 10:30:00";
        String to = "2023-11-30 10:35:00";

//        流量
        List<String> metrics = new ArrayList<>();
        metrics.add(GcoreCdnMetricsEnum.responses_2xx.getCode());
        metrics.add(GcoreCdnMetricsEnum.responses_3xx.getCode());
        metrics.add(GcoreCdnMetricsEnum.responses_4xx.getCode());
        metrics.add(GcoreCdnMetricsEnum.responses_5xx.getCode());
        GcoreCdnStatSeriesRequest request = new GcoreCdnStatSeriesRequest.Builder()
                .from(localTimeToISO8601(DateUtil.parseLocalDateTime(from)))
                .to(localTimeToISO8601(DateUtil.parseLocalDateTime(to)))
                .granularity(GcoreCdnGranularityEnum.m_5.getCode())
                .metrics(String.join("&metrics=", metrics))
                .groupBy(GcoreCdnStatSeriesGroupByEnum.resource.getCode())
                .countries(null)
                .regions(null)
                .resource("294320")
                .build();

        ApiReturnType<GcoreCdnStatSeriesResourceResponse> returnType = new ApiReturnType<>(GcoreCdnStatSeriesResourceResponse.class);

        GcoreCdnStatSeriesResourceResponse response = client.statCdnSeries(request, returnType);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));

        TestJson.printJson(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue), "resource");

    }
}
