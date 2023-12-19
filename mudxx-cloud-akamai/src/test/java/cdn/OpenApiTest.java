package cdn;

import cn.hutool.core.date.DateUtil;
import com.akamai.edgegrid.signer.ClientCredential;
import com.akamai.edgegrid.signer.EdgeGridV1Signer;
import com.akamai.edgegrid.signer.Request;
import com.akamai.edgegrid.signer.exceptions.RequestSigningException;
import com.akamai.edgegrid.signer.googlehttpclient.GoogleHttpClientEdgeGridRequestSigner;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.mudxx.cloud.akamai.model.enums.AkamaiCdnIntervalEnum;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
import com.mudxx.common.api.ApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.api.ApiReturnType;
import com.mudxx.common.utils.date.DateUtc;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/12/8 15:53
 */
public class OpenApiTest {

    private static final ClientCredential clientCredential = ClientCredential.builder()
            .host("akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net")
            .clientToken("akab-coafg5u2masrgu5x-zvjt3w4ukgfgwqd2")
            .clientSecret("GgnUiDrdCtmPCYXZaUSHikavk1oSxciAGAQr6wbQeV0=")
            .accessToken("akab-h3isdjihh5fm4vi3-usft66teik5iybvd")
            .build();

    @Test
    public void test1() throws IOException, URISyntaxException, RequestSigningException {
        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();

        String path = "/ccu/v3/invalidate/url/staging";
        URI uri = new URI("https", "akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net", path, null, null);

        HttpRequest request = requestFactory.buildPostRequest(
                new GenericUrl(uri),
                ByteArrayContent.fromString("application/json", "{}")
        );

        GoogleHttpClientEdgeGridRequestSigner googleHttpSigner = new GoogleHttpClientEdgeGridRequestSigner(clientCredential);
        googleHttpSigner.sign(request, request);

        HttpResponse response = request.execute();

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));
    }

    @Test
    public void test2() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/hostnames";

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");

        Map<String, String> queryParams = new HashMap<>();
//        queryParams.put("contractId", "ctr_V-4UYD4T7");
//        queryParams.put("groupId", "grp_247329");
        queryParams.put("hostname", "laiw1-akamai.agilewingcdn-demo.com");

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

    @Test
    public void test3() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/cpcodes/cpc_1570849";

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", "ctr_V-4UYD4T7");
        queryParams.put("groupId", "grp_247329");

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

    /**
     * 获取特定属性
     */
    @Test
    public void test4() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/properties/prp_1006364";

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", "ctr_V-4UYD4T7");
        queryParams.put("groupId", "grp_247329");

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

    /**
     * 获取属性版本的整个规则树
     */
    @Test
    public void test41() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/properties/prp_1006364/versions/1/rules";

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", "ctr_V-4UYD4T7");
        queryParams.put("groupId", "grp_247329");

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

    @Test
    public void test5() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");

        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/reporting-api/v1/reports";
        String logName = "test-" + System.currentTimeMillis();
        String result = null;
        try {
            result = apiClient.getApiClient().doGet(
                    url,
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


    @Test
    public void test6() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/cpcodes";

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", "ctr_V-4UYD4T7");
        queryParams.put("groupId", "grp_247329");

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

    @Test
    public void test7() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/papi/v1/cpcodes";

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");
        headers.put("PAPI-Use-Prefixes", "true");

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("contractId", "ctr_V-4UYD4T7");
        queryParams.put("groupId", "grp_247329");

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

    @Test
    public void test8() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/eccu-api/v1/properties";

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");

        String logName = "test-" + System.currentTimeMillis();
        String result = null;
        try {
            result = apiClient.getApiClient().doGet(
                    url,
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


    @Test
    public void test9() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net" +
                "/eccu-api/v1/requests";

        Map<String, String> headers = new HashMap<>();
        headers.put("accept", "application/json");

        String logName = "test-" + System.currentTimeMillis();
        String result = null;
        try {
            result = apiClient.getApiClient().doGet(
                    url,
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
