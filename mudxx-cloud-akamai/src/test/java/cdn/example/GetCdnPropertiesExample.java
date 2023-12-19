package cdn.example;

import cdn.ApiBuilder;
import com.mudxx.cloud.akamai.model.request.AkamaiCdnPropertiesGetRequest;
import com.mudxx.cloud.akamai.model.response.AkamaiCdnPropertiesGetResponse;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.utils.json.JsonStrUtil;
import org.junit.Test;

/**
 * @author laiw
 * @date 2023/12/14 14:01
 */
public class GetCdnPropertiesExample {

    @Test
    public void test1() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        AkamaiCdnPropertiesGetRequest request = new AkamaiCdnPropertiesGetRequest.Builder()
//                .contractId("ctr_V-4UYD4T7")
//                .groupId("grp_247329")
                .propertyId("prp_1006364")
                .build();

        AkamaiCdnPropertiesGetResponse response = null;
        try {
            response = apiClient.getCdnProperties(request);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(JsonStrUtil.toJsonStrMelody(response));
    }

}
