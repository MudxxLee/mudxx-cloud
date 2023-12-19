package cdn.example;

import cdn.ApiBuilder;
import com.mudxx.cloud.akamai.model.request.AkamaiCdnPropertiesRulesGetRequest;
import com.mudxx.cloud.akamai.model.response.AkamaiCdnPropertiesRulesGetResponse;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.utils.json.JsonStrUtil;
import org.junit.Test;

/**
 * @author laiw
 * @date 2023/12/14 16:45
 */
public class GetCdnPropertiesRulesExample {

    @Test
    public void test1() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        AkamaiCdnPropertiesRulesGetRequest request = new AkamaiCdnPropertiesRulesGetRequest.Builder()
                .contractId("ctr_V-4UYD4T7")
                .groupId("grp_247329")
                .propertyId("prp_1006364")
                .propertyVersion(8)
                .build();

        AkamaiCdnPropertiesRulesGetResponse response = null;
        try {
            response = apiClient.getCdnPropertiesRules(request);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(JsonStrUtil.toJsonStrMelody(response));
    }
}
