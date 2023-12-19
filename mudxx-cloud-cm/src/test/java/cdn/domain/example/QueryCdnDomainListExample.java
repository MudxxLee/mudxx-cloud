package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnDomainListRequest;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMCdnDomainListResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class QueryCdnDomainListExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

        CMCdnDomainListRequest request = new CMCdnDomainListRequest.Builder()
//                .domain("laiw1-cm.agilecdn.cn")
//                .domain("laiw1.cm.agilecdn.cn")

//                .productCode(CdnProductCodeEnum.CODE_008.getCode())
//                .areaScope(CdnAreaScopeEnum.CODE_1.getCode())
                .build();

        CMCdnDomainListResponse response = client.listCdnDomains(request);

        System.out.println(JSON.toJSONString(response.getResult(), SerializerFeature.WriteMapNullValue));
    }

}
