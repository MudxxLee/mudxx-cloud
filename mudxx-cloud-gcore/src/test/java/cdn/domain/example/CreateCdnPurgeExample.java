package cdn.domain.example;

import cdn.domain.ApiBuilder;
import com.mudxx.cloud.gcore.model.enums.GcoreCdnPurgeTypeEnum;
import com.mudxx.cloud.gcore.model.request.GcoreCdnPurgeCreateRequest;
import com.mudxx.cloud.gcore.services.client.GcoreCdnApiClient;
import com.mudxx.common.api.ApiException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class CreateCdnPurgeExample {

    public static void main(String[] args) throws ApiException {

        GcoreCdnApiClient client = ApiBuilder.build();

//        按URL清除
        List<String> values = new ArrayList<>();
        values.add("/v3/test.txt");
//        values.add("/v3/logo.jpg");
        GcoreCdnPurgeCreateRequest request = new GcoreCdnPurgeCreateRequest.Builder()
                .typeEnum(GcoreCdnPurgeTypeEnum.CODE_1)
                .values(values)
                .build();

//        按模式清除
//        values = new ArrayList<>();
//        values.add("/v4/*");
//        request = new GcoreCdnPurgeCreateRequest.Builder()
//                .typeEnum(GcoreCdnRefreshTypeEnum.CODE_2)
//                .values(values)
//                .build();

//        清除所有缓存
//        request = new GcoreCdnRefreshTaskAddRequest.Builder()
//                .typeEnum(GcoreCdnRefreshTypeEnum.CODE_3)
//                .values(null)
//                .build();

        client.createCdnPurge("294320", request);

    }


    @Test
    public void test1() throws ApiException {
        GcoreCdnApiClient client = ApiBuilder.build();

//        按URL清除
        List<String> values = new ArrayList<>();
//        values.add("/v4/test.txt");
        values.add("/v5/t1/t2/test.txt");

        GcoreCdnPurgeCreateRequest request = new GcoreCdnPurgeCreateRequest.Builder()
                .typeEnum(GcoreCdnPurgeTypeEnum.CODE_1)
                .values(values)
                .build();

        client.createCdnPurge("294320", request);
    }

    @Test
    public void test2() throws ApiException {

        GcoreCdnApiClient client = ApiBuilder.build();

//        按模式清除
        List<String> values = new ArrayList<>();
        values.add("/v4/*");
        GcoreCdnPurgeCreateRequest request = new GcoreCdnPurgeCreateRequest.Builder()
                .typeEnum(GcoreCdnPurgeTypeEnum.CODE_2)
                .values(values)
                .build();

        client.createCdnPurge("294320", request);

    }

}
