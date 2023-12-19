package cdn.example;

import cdn.ApiBuilder;
import com.mudxx.cloud.akamai.model.request.AkamaiCdnECCUCreateRequest;
import com.mudxx.cloud.akamai.model.response.AkamaiCdnECCUCreateResponse;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.utils.json.JsonStrUtil;
import org.junit.Test;

/**
 * @author laiw
 * @date 2023/12/13 11:58
 */
public class CreateCdnECCUExample {

    @Test
    public void test1() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        AkamaiCdnECCUCreateRequest request = new AkamaiCdnECCUCreateRequest.Builder()
                .metadata("")
                .metadata("<eccu>\n" +
                        "    <match:recursive-dirs value=\"v4\">\n" +
                        "        <revalidate>now</revalidate>\n" +
                        "    </match:recursive-dirs>\n" +
                        "</eccu>")
                .propertyName("laiw1-akamai.agilewingcdn-demo.com")
                .propertyType("HOST_HEADER")
                .propertyNameExactMatch(true)
                .requestName("laiw1-akamai-dev-04")
                .build();

        AkamaiCdnECCUCreateResponse response = null;
        try {
            response = apiClient.createCdnECCU(request);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(JsonStrUtil.toJsonStrMelody(response));
    }

}
