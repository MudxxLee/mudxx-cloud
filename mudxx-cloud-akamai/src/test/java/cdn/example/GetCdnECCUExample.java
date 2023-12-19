package cdn.example;

import cdn.ApiBuilder;
import com.mudxx.cloud.akamai.model.response.AkamaiCdnECCUGetResponse;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.utils.json.JsonStrUtil;
import org.junit.Test;

/**
 * @author laiw
 * @date 2023/12/13 11:58
 */
public class GetCdnECCUExample {

    @Test
    public void test1() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        AkamaiCdnECCUGetResponse response = null;
        try {
            response = apiClient.getCdnECCU(339636952L);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(JsonStrUtil.toJsonStrMelody(response));
    }

    @Test
    public void test2() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        System.out.println(JsonStrUtil.toJsonStrMelody(apiClient));
    }

}
