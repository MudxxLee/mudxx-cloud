package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnPreloadTaskAddRequest;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMCdnPreloadTaskAddResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class AddCdnPreloadTaskExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

        List<String> values = new ArrayList<>();
        values.add("https://laiw1-cm.agilecdn.cn/v3/test.txt");
        values.add("https://laiw1-cm.agilecdn.cn/v3/logo.jpg");

        CMCdnPreloadTaskAddRequest request = new CMCdnPreloadTaskAddRequest.Builder()
                .values(values)
                .build();

        CMCdnPreloadTaskAddResponse response = client.addCdnPreloadTask(request);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));
    }

}
