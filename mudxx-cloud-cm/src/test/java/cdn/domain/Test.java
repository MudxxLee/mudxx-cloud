package cdn.domain;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author laiw
 * @date 2023/10/30 18:04
 */
public class Test {

    private static String withQueryString(Map<String, String> queryParams) {
        if (ObjectUtils.isEmpty(queryParams)) {
            return null;
        }
        StringBuilder queryString = new StringBuilder();
        for (Map.Entry<String, String> entry : queryParams.entrySet()) {
            if (ObjectUtils.isEmpty(entry.getKey())) {
                continue;
            }
            queryString.append(entry.getKey()).append("=");
            if (StringUtils.isNotBlank(entry.getValue())) {
                queryString.append(entry.getValue());
            }
            queryString.append("&");
        }
        return queryString.substring(0, queryString.length() - 1);
    }

    private static String withQueryString(String url, Map<String, String> queryParams) {
        String queryString = withQueryString(queryParams);
        if(url.endsWith("?")) {
            return url + queryString;
        }
        if (url.contains("=")) {
            return url + "&" + queryString;
        }
        return url + "?" + queryString;
    }

    public static void main(String[] args) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("A", "1");
        queryParams.put("B", "2");
        System.out.println(withQueryString(queryParams));
        System.out.println(withQueryString("http://1223.com:8090", queryParams));
        System.out.println(withQueryString("http://1223.com:8090?", queryParams));
        System.out.println(withQueryString("http://1223.com:8090?a=1", queryParams));
    }

}
