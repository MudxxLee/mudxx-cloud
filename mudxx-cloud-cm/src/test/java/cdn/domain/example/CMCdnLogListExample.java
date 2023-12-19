package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnLogListRequest;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMCdnLogListResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class CMCdnLogListExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

        CMCdnLogListRequest request = new CMCdnLogListRequest.Builder()
                .startTime((int) (System.currentTimeMillis() / 1000) - 3600 * 24 * 7)
                .endTime((int) (System.currentTimeMillis() / 1000))
                .domain("laiw1-cm.agilecdn.cn")
                .build();

        CMCdnLogListResponse response = client.listCdnLogs(request);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));

    }

}
