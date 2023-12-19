package com.mudxx.cloud.oci.common.util;

import cn.hutool.core.comparator.PinyinComparator;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import java.util.Arrays;

/**
 * @author laiw
 * @date 2023/10/19 16:04
 */
public class JsonUtil {

    public static String toJsonStr(Object object) {
        return toJsonStr(object, false, true);
    }

    public static String toJsonStrMelody(Object object, String... ignoreFields) {
        return toJsonStr(object, true, false, ignoreFields);
    }

    public static String toJsonStrPinyinOrder(Object object, String... ignoreFields) {
        return toJsonStr(object, true, true, ignoreFields);
    }

    public static String toJsonStrWithNull(Object object, String... ignoreFields) {
        return toJsonStr(object, false, false, ignoreFields);
    }

    public static String toJsonStr(Object object, boolean isPinyinOrder, boolean ignoreNullValue, String... ignoreFields) {
        try {
            if (ignoreFields == null) {
                return JSONUtil.toJsonStr(object, new JSONConfig()
                        .setKeyComparator(isPinyinOrder ? new PinyinComparator() : null)
                        .setIgnoreNullValue(ignoreNullValue));
            }
            return toFastjsonStr(object, ignoreNullValue, ignoreFields);
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String toFastjsonStr(Object object, boolean ignoreNullValue, String... ignoreFields) {
        // Fastjson 动态排除字段
        SimplePropertyPreFilter excludeFilter = new SimplePropertyPreFilter();
        // 注意：如果类包含子对象，下级同字段名的也会被排除掉
        excludeFilter.getExcludes().addAll(Arrays.asList(ignoreFields));
        if (ignoreNullValue) {
            return JSON.toJSONString(object, excludeFilter, SerializerFeature.IgnoreErrorGetter);
        }
        return JSON.toJSONString(object, excludeFilter, SerializerFeature.IgnoreErrorGetter, SerializerFeature.WriteMapNullValue);
    }

    public static void main(String[] args) {
    }

}


