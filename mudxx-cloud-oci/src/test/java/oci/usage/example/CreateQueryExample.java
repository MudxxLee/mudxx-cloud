package oci.usage.example;

import com.mudxx.cloud.oci.common.generator.OCIGenerator;
import com.mudxx.cloud.oci.common.util.JsonUtil;
import com.oracle.bmc.usageapi.UsageapiClient;
import com.oracle.bmc.usageapi.model.*;
import com.oracle.bmc.usageapi.requests.CreateQueryRequest;
import com.oracle.bmc.usageapi.responses.CreateQueryResponse;
import oci.usage.OCIUsageBuilder;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CreateQueryExample {

    public static void main(String[] args) throws Exception {

        /* Create a service client */
        UsageapiClient client = OCIUsageBuilder.buildClient();

        /* Create a request and dependent object(s). */
        CreateQueryDetails createQueryDetails = CreateQueryDetails.builder()
                // 区间ID 必需：是
                .compartmentId(null)
                // 查询的公共字段  必需：是
                .queryDefinition(QueryDefinition.builder()
                        // 查询显示名称   必需：是
                        .displayName("Usage-Query-dev-1")
                        // 保存的查询版本 必需：是
                        .version(new BigDecimal("1"))
                        // 成本分析 UI 必需：是
                        .costAnalysisUI(CostAnalysisUI.builder()
                                // 图形类型
                                .graph(CostAnalysisUI.Graph.Bars)
                                // 累积图
                                .isCumulativeGraph(true)
                                .build())
                        // 生成的成本分析报表的请求 必需：是
                        .reportQuery(ReportQuery.builder()
                                // 租户 ID 必需：是
                                .tenantId(null)
                                // 粒度 必需：是
                                .granularity(ReportQuery.Granularity.Daily)
                                // 使用开始时间 yyyy-MM-dd'T'HH:mm:ss
//                                .timeUsageStarted(LocalDateTimeUtils.toDateUtc(LocalDateTimeUtils.parseUtc("2024-01-20T00:00:00", "yyyy-MM-dd'T'HH:mm:ss")))
                                // 使用结束时间 yyyy-MM-dd'T'HH:mm:ss
//                                .timeUsageEnded(LocalDateTimeUtils.toDateUtc(LocalDateTimeUtils.parseUtc("2024-01-30T00:00:00", "yyyy-MM-dd'T'HH:mm:ss")))
                                // 指定是否按时间聚合。如果 isAggregateByTime 为 true，则查询时间段内的所有使用量或成本将相加。
                                .isAggregateByTime(true)
                                // dateRange名称
                                .dateRangeName(ReportQuery.DateRangeName.Mtd)
                                // 查询使用类型
                                .queryType(ReportQuery.QueryType.Usage)
                                // 隔间深度级别
                                .compartmentDepth(new BigDecimal("1"))
                                // 预测使用情况或成本的配置
                                .forecast(Forecast.builder()
                                        // 预测类型
                                        .forecastType(Forecast.ForecastType.Basic)
                                        // 预测开始时间
                                        .timeForecastStarted(null)
                                        // 预测结束时间
                                        .timeForecastEnded(null)
                                        .build())
                                // 指定聚合结果所依据的内容
                                // ["tagNamespace", "tagKey", "tagValue", "service", "skuName", "skuPartNumber",
                                // "unit", "compartmentName", "compartmentPath", "compartmentId", "platform",
                                // "region", "logicalAd", "resourceId", "tenantId", "tenantName"]
                                .groupBy(Stream.of("skuName", "tenantId").collect(Collectors.toList()))
                                // GroupBy 特定的 tagKey
//                                .groupByTag(Stream.of(Tag.builder()
//                                        .namespace("EXAMPLE-namespace-Value")
//                                        .key("EXAMPLE-key-Value")
//                                        .value("EXAMPLE-value-Value")
//                                        .build()).collect(Collectors.toList()))
                                // 筛选器
//                                .filter(Filter.builder()
//                                        // 筛选器运算符
//                                        .operator(Filter.Operator.And)
//                                        // 筛选的维度
//                                        .dimensions(Stream.of(Dimension.builder()
//                                                .key("EXAMPLE-key-Value")
//                                                .value("EXAMPLE-value-Value")
//                                                .build()).collect(Collectors.toList()))
//                                        // 标签
//                                        .tags(Stream.of(Tag.builder()
//                                                .namespace("EXAMPLE-namespace-Value")
//                                                .key("EXAMPLE-key-Value")
//                                                .value("EXAMPLE-value-Value").build()).collect(Collectors.toList()))
//                                        .build())
                                .build())
                        .build())
                .build();

        CreateQueryRequest createQueryRequest = CreateQueryRequest.builder()
                .createQueryDetails(createQueryDetails)
                .opcRequestId(OCIGenerator.opcClientRequestId())
                .opcRetryToken(null).build();

        /* Send request to the Client */
        CreateQueryResponse response = null;
        try {
            response = client.createQuery(createQueryRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JsonUtil.toJsonStrMelody(response));
    }

}

