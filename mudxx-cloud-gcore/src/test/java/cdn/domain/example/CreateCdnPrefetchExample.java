package cdn.domain.example;

import cdn.domain.ApiBuilder;
import com.mudxx.cloud.gcore.model.request.GcoreCdnPrefetchCreateRequest;
import com.mudxx.cloud.gcore.services.client.GcoreCdnApiClient;
import com.mudxx.common.api.ApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class CreateCdnPrefetchExample {

    public static void main(String[] args) {

        GcoreCdnApiClient client = ApiBuilder.build();

        List<String> paths = new ArrayList<>();
//        paths.add("/v3/test.txt");
        paths.add("----------");

        GcoreCdnPrefetchCreateRequest request = new GcoreCdnPrefetchCreateRequest.Builder()
                .paths(paths)
                .build();

        try {
            client.createCdnPrefetch("294320", request);
        } catch (ApiException e) {
            e.printStackTrace();
        }

    }

}
