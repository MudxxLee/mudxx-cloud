package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnRefreshTaskInfo;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnRefreshTaskQueryTypeEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnRefreshTaskListRequest;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMPageResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class QueryCdnRefreshTaskExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

        CMCdnRefreshTaskListRequest request = new CMCdnRefreshTaskListRequest.Builder()
//                .type(CMCdnRefreshTaskQueryTypeEnum.CODE_0.getCode())
//                .startTime((int) (System.currentTimeMillis() / 1000) - 3600 * 24 * 1)
//                .endTime((int) (System.currentTimeMillis() / 1000))

                .type(CMCdnRefreshTaskQueryTypeEnum.CODE_1.getCode())
                .submitId("16995885601359")

//                .type(CMCdnRefreshTaskQueryTypeEnum.CODE_2.getCode())
//                .taskId("1699517280115876")

                .page(1)
                .pageSize(20)
                .build();

        CMPageResponse<CMCdnRefreshTaskInfo> response = client.listCdnRefreshTasks(request);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));

        System.out.println(JSON.toJSONString(response.getResult(), SerializerFeature.WriteMapNullValue));
    }

}
