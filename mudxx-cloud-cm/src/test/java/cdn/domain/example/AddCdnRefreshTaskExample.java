package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnRefreshTaskTypeEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnRefreshTaskAddRequest;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMCdnRefreshTaskAddResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class AddCdnRefreshTaskExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();


        List<String> values = new ArrayList<>();
//        values.add("https://laiw1-cm.agilecdn.cn/img/logo.jpg");
//        values.add("https://laiw1-cm.agilecdn.cn/img/test.txt");

//        values.add("https://laiw1-cm.agilecdn.cn/img/");

//        values.add("https://laiw1-cm.agilecdn.cn/v3/");

//        values.add("https://laiw1-cm.agilecdn.cn/img/*.*");

//        values.add("https://laiw1-cm.agilecdn.cn/img/[^/]*.jpg");

        values.add("https://laiw1-cm.agilecdn.cn/v3/[^/]*.txt");

//        values.add("https://laiw1-cm.agilecdn.cn/img/.*");
//
//        values.add("https://laiw1-cm.agilecdn.cn/.*");


        CMCdnRefreshTaskAddRequest request = new CMCdnRefreshTaskAddRequest.Builder()
                .taskType(CMCdnRefreshTaskTypeEnum.CODE_3.getCode())
                .values(values)
                .build();

        CMCdnRefreshTaskAddResponse response = client.addCdnRefreshTask(request);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));
    }

}
