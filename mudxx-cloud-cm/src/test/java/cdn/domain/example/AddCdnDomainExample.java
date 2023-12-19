package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnOrigin;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnAreaScopeEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnDomainActionEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnOriginRoleEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnProductCodeEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnDomainAddRequest;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMCdnDomainAddResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class AddCdnDomainExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

        CMCdnDomainAddRequest request = buildRequest();

        CMCdnDomainAddResponse response = client.addCdnDomain(request);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));
    }

    public static CMCdnDomainAddRequest buildRequest() {
        CMCdnDomainAddRequest.Builder builder = new CMCdnDomainAddRequest.Builder()
                .domain("laiw2-cm.agilecdn.cn")
                .action(CMCdnDomainActionEnum.ADD.getCode())
                .productCode(CMCdnProductCodeEnum.CODE_008.getCode())
                .wafEnable(null)
                .ddosEnable(null)
                .areaScope(CMCdnAreaScopeEnum.CODE_1.getCode())
                .ipv6Enable(null);
        // 源站信息
        List<CMCdnOrigin> origins = new ArrayList<>();
        CMCdnOrigin origin = new CMCdnOrigin();
        origin.setOrigin("wuwg-origin.coc3.com");
        origin.setPort(80);
        origin.setWeight(1);
        origin.setRole(CMCdnOriginRoleEnum.master.getCode());
        origins.add(origin);
        builder.origin(origins);
        return builder.build();
    }

}
