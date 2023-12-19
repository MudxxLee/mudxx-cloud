package cdn;

import com.mudxx.cloud.biz.common.api.ApiClient;
import com.mudxx.cloud.biz.common.api.ApiException;
import com.mudxx.cloud.biz.common.api.ApiReturnType;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

/**
 * @author laiw
 * @date 2023/10/20 16:21
 */
public class ApiBuilder {

    public static CMCdnApiClient build() {
        return new CMCdnApiClient(
                "http://openapi.anosm.com",
                "CFC91D6504E390A0ACB2C2C2083880A3",
                "8FE60889CBAE62B8607D195EFBC68020");
    }

    public static void main(String[] args) throws ApiException {
        ApiClient apiClient = new ApiClient();
        String url = "https://account-api1.agilewingcdn-demo.com/auth/center/ticket/check1";
        String params = "{}";
        String logName = "test-" + System.currentTimeMillis();
        String result = apiClient.doPostJson(
                url,
                null,
                params,
                new ApiReturnType<>(String.class),
                logName
        );
        System.out.println(result);
    }

}
