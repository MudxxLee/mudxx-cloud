package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnPreloadTaskInfo;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnPreloadTaskQueryTypeEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnPreloadTaskListRequest;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMPageResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class QueryCdnPreloadTaskExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

        CMCdnPreloadTaskListRequest request = new CMCdnPreloadTaskListRequest.Builder()
//                .type(CMCdnPreloadTaskQueryTypeEnum.CODE_0.getCode())
//                .startTime((int) (System.currentTimeMillis() / 1000) - 600)
//                .endTime((int) (System.currentTimeMillis() / 1000))
//
                .type(CMCdnPreloadTaskQueryTypeEnum.CODE_1.getCode())
                .submitId("1699580465047")

//                .type(CMCdnPreloadTaskQueryTypeEnum.CODE_2.getCode())
//                .taskId("169830226700045")

                .page(1)
                .pageSize(10)
                .build();

        CMPageResponse<CMCdnPreloadTaskInfo> response = client.listCdnPreloadTasks(request);

        System.out.println(JSON.toJSONString(response.getResult(), SerializerFeature.WriteMapNullValue));
    }

}
