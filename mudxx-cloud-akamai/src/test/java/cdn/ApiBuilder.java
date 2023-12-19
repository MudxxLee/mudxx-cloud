package cdn;

import com.mudxx.cloud.akamai.model.entity.AkamaiCredential;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
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

    private static final AkamaiCredential credential = new AkamaiCredential.Builder()
            .host("akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net")
            .clientToken("akab-coafg5u2masrgu5x-zvjt3w4ukgfgwqd2")
            .clientSecret("GgnUiDrdCtmPCYXZaUSHikavk1oSxciAGAQr6wbQeV0=")
            .accessToken("akab-h3isdjihh5fm4vi3-usft66teik5iybvd")
            .maxBodySize(AkamaiCredential.DEFAULT_MAX_BODY_SIZE_IN_BYTES)
            .build();

    public static AkamaiCdnApiClient buildCdnApiClient() {
        return new AkamaiCdnApiClient(
                "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net",
                credential
        );
    }

    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient(10L, 30L, 30L);
        Map<String, String> headers = new HashMap<>(1);
        headers.put("Authorization", "EG1-HMAC-SHA256 client_token=akab-coafg5u2masrgu5x-zvjt3w4ukgfgwqd2;access_token=akab-h3isdjihh5fm4vi3-usft66teik5iybvd;timestamp=20231208T05:56:27+0000;nonce=7ed84b77-d991-407c-9b61-5750bff4bf1b;signature=60N0pUfzXhS3kLUjUzZddQDedfYKw5yLWTxMFezs7rw=");
        headers.put("Content-Type", "application/JSON");
        headers.put("Accept", "application/JSON");
        String url = "https://akab-kcumtwsgjm2fy4ov-gyjmbpym7eodljzg.luna.akamaiapis.net/edge-diagnostics/v1/gtm/gtm-properties";
        String params = "{}";
        String logName = "test-" + System.currentTimeMillis();
        String result = null;
        try {
            result = apiClient.doGet(
                    url,
                    headers,
                    new ApiReturnType<>(String.class),
                    logName
            );
        } catch (ApiException e) {
            System.out.println(e.toSimpleJsonStr());
            e.printStackTrace();
        }
        System.out.println(result);
    }

}
