package cdn.example;

import cdn.ApiBuilder;
import com.mudxx.cloud.akamai.model.response.AkamaiCdnECCUPropertiesListResponse;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.utils.json.JsonStrUtil;
import org.junit.Test;

/**
 * @author laiw
 * @date 2023/12/14 10:56
 */
public class ListCdnECCUPropertiesExample {

    @Test
    public void test1() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        AkamaiCdnECCUPropertiesListResponse response = null;
        try {
            response = apiClient.listCdnECCUProperties();
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(JsonStrUtil.toJsonStrMelody(response));
    }

}
