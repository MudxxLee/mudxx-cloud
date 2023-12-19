package cdn;

import com.akamai.edgegrid.signer.ClientCredential;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.api.ApiReturnType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/12/8 15:53
 */
public class OpenApiTest2 {

    /**
     * 列出帐户下的合同列表
     */
    @Test
    public void test1() {
        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/contracts";
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");
        this.doGet(url, headers, null);
    }

    /**
     * 列出帐户下的组列表
     */
    @Test
    public void test1_2() {
        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/groups";
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");
        this.doGet(url, headers, null);
    }

    /**
     * 列出给定合同下可用的产品集
     */
    @Test
    public void test2() {
        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/products";
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", "ctr_V-4UYD4T7");
        this.doGet(url, headers, queryParams);
    }

    /**
     * 列出给定产品下用例场景
     */
    @Test
    public void test3() {
        String url = String.format("https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/products/%s/mapping-use-cases", "prd_Download_Delivery");
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", "ctr_V-4UYD4T7");
        this.doGet(url, headers, queryParams);
    }

    /**
     * 列出 Edge 主机名
     */
    @Test
    public void test4() {
        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/edgehostnames";
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", "ctr_V-4UYD4T7");
        queryParams.put("groupId", "grp_247329");
        this.doGet(url, headers, queryParams);
    }

    /**
     * 获取边缘主机名
     */
    @Test
    public void test5() {
        String url = String.format("https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/edgehostnames/%s", "ehn_5501323");
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", "ctr_V-4UYD4T7");
        queryParams.put("groupId", "grp_247329");
        this.doGet(url, headers, queryParams);
    }

    /**
     * 列出 CP 代码
     */
    @Test
    public void test6() {
        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/cpcodes";
        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", "ctr_V-4UYD4T7");
        queryParams.put("groupId", "grp_247329");
        this.doGet(url, headers, queryParams);
    }

    private void doGet(String url, Map<String, String> headers, Map<String, String> queryParams) {
        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();
        String urlString = apiClient.getApiClient().withQueryString(url, queryParams);
        String logName = "test-" + System.currentTimeMillis();
        String result = null;
        try {
            result = apiClient.getApiClient().doGet(
                    urlString,
                    headers,
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
