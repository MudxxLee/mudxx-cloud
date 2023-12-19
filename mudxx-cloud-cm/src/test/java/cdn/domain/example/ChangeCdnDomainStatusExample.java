package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnDomainChangeStatusEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnProductCodeEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnDomainChangeStatusRequest;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class ChangeCdnDomainStatusExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

        CMCdnDomainChangeStatusRequest request = new CMCdnDomainChangeStatusRequest.Builder()
                .domain("laiw2-cm.agilecdn.cn")
                .productCode(CMCdnProductCodeEnum.CODE_008.getCode())
                .status(CMCdnDomainChangeStatusEnum.CODE_1.getCode())
                .build();

        CMResponse response = client.changeCdnDomainStatus(request);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));
    }

}
