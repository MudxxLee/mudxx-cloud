package com.mudxx.cloud.gcore.services.builder;

import cn.hutool.core.util.URLUtil;
import com.alibaba.fastjson.JSON;
import com.mudxx.cloud.gcore.model.enums.GcoreCdnPurgeTypeEnum;
import com.mudxx.cloud.gcore.model.request.GcoreCdnPrefetchCreateRequest;
import com.mudxx.cloud.gcore.model.request.GcoreCdnPurgeCreateRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author laiw
 * @date 2023/12/5 13:49
 */
public class GcoreCdnBuilder {

    /**
     * 构建请求参数-创建预热请求
     */
    public static GcoreCdnPrefetchCreateRequest buildCdnPrefetchCreateRequest(List<String> pathList) {
        List<String> paths = pathList.stream()
                .map(e -> URLUtil.url(e).getFile())
                .distinct()
                .collect(Collectors.toList());
        return new GcoreCdnPrefetchCreateRequest.Builder()
                .paths(paths)
                .build();
    }

    /**
     * 构建请求参数-创建清除请求(分组)
     */
    public static List<GcoreCdnPurgeCreateRequest> buildCdnPurgeCreateRequests(List<String> pathList) {
        // 按刷新路径分组
        Map<GcoreCdnPurgeTypeEnum, List<String>> enumListMap = pathList.stream().collect(
                Collectors.groupingBy(GcoreCdnBuilder::turnIntoPurgeTypeEnum, Collectors.toList()));
        List<GcoreCdnPurgeCreateRequest> requests = new ArrayList<>();
        if (enumListMap.containsKey(GcoreCdnPurgeTypeEnum.CODE_3)) {
            // 如果存在清除所有缓存,则默认只有一种
            requests.add(new GcoreCdnPurgeCreateRequest.Builder()
                    .typeEnum(GcoreCdnPurgeTypeEnum.CODE_3)
                    .build());
            return requests;
        }
        for (Map.Entry<GcoreCdnPurgeTypeEnum, List<String>> entry : enumListMap.entrySet()) {
            requests.add(new GcoreCdnPurgeCreateRequest.Builder()
                    .typeEnum(entry.getKey())
                    .values(entry.getValue())
                    .build());
        }
        return requests;
    }

    public static void main(String[] args) {
        List<String> pathList = new ArrayList<>();
//        pathList.add("*");
        pathList.add("/aa/*");
        pathList.add("/v1/tet/*.png");
        pathList.add("/v1/tet/111.png");

        System.out.println(JSON.toJSONString(buildCdnPurgeCreateRequests(pathList)));

    }

    /**
     * 按刷新路径分组
     * <p>
     * pathPattern                  Gcore-PurgeType
     * ---------------------------------------
     * *, /, /*                     3(清除所有缓存)
     * 排除上述的使用 * 运算符        2(按模式清除)
     * 非上述两种                    1(按URL清除)
     */
    private static GcoreCdnPurgeTypeEnum turnIntoPurgeTypeEnum(String pathPattern) {
        String pattern = pathPattern.trim();
        if ("".equals(pattern) || "/".equals(pattern) || "*".equals(pattern) || "/*".equals(pathPattern)) {
            return GcoreCdnPurgeTypeEnum.CODE_3;
        }
        if (pattern.contains("*")) {
            return GcoreCdnPurgeTypeEnum.CODE_2;
        }
        return GcoreCdnPurgeTypeEnum.CODE_1;
    }


}
