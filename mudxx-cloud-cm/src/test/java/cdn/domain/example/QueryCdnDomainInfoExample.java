package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMCdnDomainGetResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class QueryCdnDomainInfoExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

        CMCdnDomainGetResponse response = client.getCdnDomain("laiw1-cm.agilecdn.cn");

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));

        System.out.println(JSON.toJSONString(response.getFiletypeTtl(), SerializerFeature.WriteMapNullValue));
    }

}
