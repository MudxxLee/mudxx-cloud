package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnReqNumDataListRequest;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMCdnReqNumDataListResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class QueryCdnRequestNumDataExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

        List<String> domain = new ArrayList<>();
        domain.add("laiw1-cm.agilecdn.cn");

        CMCdnReqNumDataListRequest request = new CMCdnReqNumDataListRequest.Builder()
                .startTime((int) (System.currentTimeMillis() / 1000) - 3600 * 2)
                .endTime((int) (System.currentTimeMillis() / 1000))
                .interval("1h")
                .domain(domain)
                .build();

        CMCdnReqNumDataListResponse response = client.listCdnReqNumData(request);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));

    }

}
