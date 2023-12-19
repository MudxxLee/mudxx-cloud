package cdn.example;

import cdn.ApiBuilder;
import com.mudxx.cloud.akamai.model.enums.AkamaiCdnNetworkEnum;
import com.mudxx.cloud.akamai.model.enums.AkamaiCdnPurgeTypeEnum;
import com.mudxx.cloud.akamai.model.request.AkamaiCdnPurgeCreateRequest;
import com.mudxx.cloud.akamai.model.response.AkamaiCdnPurgeCreateResponse;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.utils.json.JsonStrUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laiw
 * @date 2023/12/13 11:58
 */
public class CreateCdnPurgeExample {

    @Test
    public void test1() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        List<String> values = new ArrayList<>();
        values.add("http://laiw1-akamai.agilewingcdn-demo.com/v3/test.txt");

        AkamaiCdnPurgeCreateRequest<String> request = new AkamaiCdnPurgeCreateRequest.Builder<String>()
                .typeEnum(AkamaiCdnPurgeTypeEnum.INVALID_URL)
                .values(values)
                .build();

        AkamaiCdnPurgeCreateResponse response = null;
        try {
            response = apiClient.createCdnPurge(request, AkamaiCdnNetworkEnum.STAGING);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(JsonStrUtil.toJsonStrMelody(response));
    }

    @Test
    public void test2() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        List<String> values = new ArrayList<>();
        values.add("http://laiw1-akamai.agilewingcdn-demo.com/v3/test.txt");

        AkamaiCdnPurgeCreateRequest<String> request = new AkamaiCdnPurgeCreateRequest.Builder<String>()
                .typeEnum(AkamaiCdnPurgeTypeEnum.DELETE_URL)
                .values(values)
                .build();

        AkamaiCdnPurgeCreateResponse response = null;
        try {
            response = apiClient.createCdnPurge(request, AkamaiCdnNetworkEnum.STAGING);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(JsonStrUtil.toJsonStrMelody(response));
    }

}
