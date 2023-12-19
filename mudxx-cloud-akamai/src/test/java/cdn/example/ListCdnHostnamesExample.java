package cdn.example;

import cdn.ApiBuilder;
import com.mudxx.cloud.akamai.model.request.AkamaiCdnHostnameListRequest;
import com.mudxx.cloud.akamai.model.response.AkamaiCdnHostnameListResponse;
import com.mudxx.cloud.akamai.services.client.AkamaiCdnApiClient;
import com.mudxx.common.api.ApiException;
import com.mudxx.common.utils.json.JsonStrUtil;
import org.junit.Test;

/**
 * @author laiw
 * @date 2023/12/14 16:05
 */
public class ListCdnHostnamesExample {

    @Test
    public void test1() {

        AkamaiCdnApiClient apiClient = ApiBuilder.buildCdnApiClient();

        AkamaiCdnHostnameListRequest request = new AkamaiCdnHostnameListRequest.Builder()
                .hostname("laiw1-akamai.agilewingcdn-demo.com")
                .build();

        AkamaiCdnHostnameListResponse response = null;
        try {
            response = apiClient.listCdnHostnames(request);
        } catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println(JsonStrUtil.toJsonStrMelody(response));
    }

}
