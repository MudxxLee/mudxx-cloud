package cdn.domain;

import com.mudxx.cloud.gcore.services.auth.GcoreAuthHeader;
import com.mudxx.cloud.gcore.services.client.GcoreCdnApiClient;
import com.mudxx.common.api.ApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.api.ApiReturnType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/20 16:21
 */
public class ApiBuilder {

    public static GcoreCdnApiClient build() {
        return new GcoreCdnApiClient("https://api.gcore.com",
                GcoreAuthHeader.buildHeaders("8117$e727634660c304e13063db4270b19ac6bd0a65c774e7428e6cb6edcf1aca2760b63916fc7f841b151e5bd24a073e6494ac91beb1683ddcaf8d081310b13ea6fa"));
    }

    public static void main(String[] args) throws ApiException {
        ApiClient apiClient = new ApiClient(10L, 30L, 30L);
        Map<String, String> headers = new HashMap<>(1);
        headers.put("Authorization", "APIKey " + "8117$e727634660c304e13063db4270b19ac6bd0a65c774e7428e6cb6edcf1aca2760b63916fc7f841b151e5bd24a073e6494ac91beb1683ddcaf8d081310b13ea6fa");
        String url = "https://api.gcore.com/cdn/clients/me/limits";
        String params = "{}";
        String logName = "test-" + System.currentTimeMillis();
        String result = apiClient.doGet(
                url,
                headers,
                new ApiReturnType<>(String.class),
                logName
        );
        System.out.println(result);

    }

}
