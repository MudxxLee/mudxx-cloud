package cdn.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.mudxx.cloud.gcore.model.entity.GcoreCdnStatSeriesMetricsModel;
import com.mudxx.cloud.gcore.model.response.GcoreCdnStatSeriesVhostResponse;
import org.apache.commons.lang3.ObjectUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author laiw
 * @date 2023/12/6 18:11
 */
public class TestGroupList {

    public static void main(String[] args) {

//        String s = "[[1701840600,16],[1701840900,0],[1701841200,0],[1701841500,2],[1701841800,3],[1701842100,3]]";
//
//        List<List<BigDecimal>> targets = JSON.parseObject(s, new TypeReference<List<List<BigDecimal>>>() {
//        });
//
//        Map<BigDecimal, BigDecimal> longMap = targets.stream().collect(Collectors.toMap(
//                k -> k.get(0),
//                v -> defaultIfNullAtIndex(v, 1, BigDecimal.ZERO),
//                (v1, v2) -> v1));
//
//        System.out.println(longMap);

        String vv = "{\"vhost\":{\"gcore.agilewingcdn-demo.com\":{\"metrics\":{\"cache_hit_requests_ratio\":[[1701840600,1],[1701840900,0],[1701841200,0],[1701841500,0.5],[1701841800,0.6666666666666666],[1701842100,0]],\"requests\":[[1701840600,16],[1701840900,0],[1701841200,0],[1701841500,2],[1701841800,3],[1701842100,3]],\"responses_hit\":[[1701840600,16],[1701840900,0],[1701841200,0],[1701841500,1],[1701841800,2],[1701842100,0]],\"responses_miss\":[[1701840600,0],[1701840900,0],[1701841200,0],[1701841500,1],[1701841800,1],[1701842100,3]]}},\"niejf-gcore-test01.agilewingcdn-demo.com\":{\"metrics\":{\"cache_hit_requests_ratio\":[[1701840600,0],[1701840900,0],[1701841200,0],[1701841500,0.005044136191677175],[1701841800,0],[1701842100,0]],\"requests\":[[1701840600,0],[1701840900,0],[1701841200,0],[1701841500,793],[1701841800,0],[1701842100,0]],\"responses_hit\":[[1701840600,0],[1701840900,0],[1701841200,0],[1701841500,4],[1701841800,0],[1701842100,0]],\"responses_miss\":[[1701840600,0],[1701840900,0],[1701841200,0],[1701841500,1],[1701841800,0],[1701842100,0]]}}}}";

        GcoreCdnStatSeriesVhostResponse response = JSON.parseObject(vv, new TypeReference<GcoreCdnStatSeriesVhostResponse>() {
        });
        System.out.println(JSON.toJSONString(merge(response.getVhost())));

    }

    public static BigDecimal defaultIfNullAtIndex(List<BigDecimal> list, int index, BigDecimal defaultValue) {
        int len = list.size();
        BigDecimal value = null;
        if (index >= 0 && index < len) {
            value = list.get(index);
        }
        return ObjectUtils.defaultIfNull(value, defaultValue);
    }


    public static Map<String, List<List<BigDecimal>>> merge(Map<String, GcoreCdnStatSeriesMetricsModel> vhost) {
        Map<String, List<List<BigDecimal>>> mergeMap = new HashMap<>();
        for (Map.Entry<String, GcoreCdnStatSeriesMetricsModel> entry : vhost.entrySet()) {
            Map<String, List<List<BigDecimal>>> metricsMap = entry.getValue().getMetrics();
            for (Map.Entry<String, List<List<BigDecimal>>> item : metricsMap.entrySet()) {
                String itemKey = item.getKey();
                if (mergeMap.containsKey(itemKey)) {
                    // 解析并合并数据
                    parseAndMergeData(mergeMap.get(itemKey), item.getValue());
                } else {
                    // 初始化数据
                    mergeMap.put(itemKey, item.getValue());
                }
            }
        }
        return mergeMap;
    }

    /**
     * 解析并合并数据
     */
    private static void parseAndMergeData(List<List<BigDecimal>> dataList, List<List<BigDecimal>> metricsList) {
        Map<BigDecimal, BigDecimal> longMap = metricsList.stream().collect(Collectors.toMap(
                k -> k.get(0),
                v -> defaultIfNullAtIndex(v, 1, BigDecimal.ZERO),
                (v1, v2) -> v1));
        dataList.forEach(data -> {
            if (longMap.containsKey(data.get(0))) {
                data.set(1, data.get(1).add(longMap.get(data.get(0))));
            }
        });
    }
}
