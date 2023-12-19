package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnReqHttpStatusCodeDataListRequest;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMCdnReqHttpStatusCodeDataListResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class CMCdnReqHttpStatusCodeDataExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

        List<String> domain = new ArrayList<>();
        domain.add("laiw1-cm.agilecdn.cn");

        CMCdnReqHttpStatusCodeDataListRequest request = new CMCdnReqHttpStatusCodeDataListRequest.Builder()
                .startTime((int) (System.currentTimeMillis() / 1000) - 3600 * 24 * 7)
                .endTime((int) (System.currentTimeMillis() / 1000))
                .interval("24h")
                .domain(domain)
                .build();

        CMCdnReqHttpStatusCodeDataListResponse response = client.listCdnReqHttpStatusCodeData(request);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));

    }

}
