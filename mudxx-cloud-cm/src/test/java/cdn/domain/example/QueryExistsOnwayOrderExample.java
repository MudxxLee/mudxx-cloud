package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMCdnOnWayOrderGetResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class QueryExistsOnwayOrderExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

        CMCdnOnWayOrderGetResponse response = client.getCdnOnWayOrder("laiw1-cm.agilecdn.cn");

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));
    }

}
