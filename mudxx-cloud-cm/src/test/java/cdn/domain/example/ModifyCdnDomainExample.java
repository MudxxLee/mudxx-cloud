package cdn.domain.example;

import cdn.ApiBuilder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mudxx.cloud.biz.common.api.ApiException;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnFiletypeTtl;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnHttpsBasic;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnDomainModifyRequest;
import net.agilewing.phoenix.cdn.impl.cm.model.response.CMResponse;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;

import java.util.ArrayList;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 16:19
 */
public class ModifyCdnDomainExample {

    public static void main(String[] args) throws ApiException {

        CMCdnApiClient client = ApiBuilder.build();

//        CMCdnOriginSingle o = new CMCdnOriginSingle();
//        o.setOrigin("njf-oss-test01.oss-cn-guangzhou.aliyuncs.com");
//        o.setPort(80);
//        o.setRole(CMCdnOriginRoleEnum.master.getCode());
//        o.setWeight(50);
//        List<CMCdnOriginSingle> origin = new ArrayList<>();
//        origin.add(o);

//        String reqHost = "njf-oss-test01.oss-cn-guangzhou.aliyuncs.com";
//        Integer originHostType = 0;
//        Object originHostHttp = null;

//        CMCdnOriginSingle os = new CMCdnOriginSingle();
//        os.setOrigin("wuwg-origin.coc3.com");
//        os.setPort(null);
//        os.setRole(CMCdnOriginRoleEnum.master.getCode());
//        os.setWeight(50);
//        os.setProtocol("https");
//        List<CMCdnOriginSingle> origin = new ArrayList<>();
//        origin.add(os);

//        String reqHost = "101.33.247.213";
//        Integer originHostType = 0;
//        Map<String, String> originHostHttp = null;


        CMCdnHttpsBasic basic = new CMCdnHttpsBasic();
        basic.setOriginProtocol("http");

        List<CMCdnFiletypeTtl> filetypeTtl = new ArrayList<>();
//        CMCdnFiletypeTtl t1 = new CMCdnFiletypeTtl();
//        t1.setCacheType(1);
//        t1.setCacheWithArgs(0);
//        t1.setMode(0);
//        t1.setFileType("txt");
//        t1.setTtl(0);
//        filetypeTtl.add(t1);
        CMCdnFiletypeTtl t2 = new CMCdnFiletypeTtl();
        t2.setCacheType(3);
        t2.setCacheWithArgs(0);
        t2.setMode(0);
        t2.setFileType("txt,jpg,png,css,html,css,xls,xlsx,doc,docx,pptx,htm,gif,psd,mp3");
        t2.setTtl(3600 * 24 * 5);
        filetypeTtl.add(t2);
        CMCdnFiletypeTtl t3 = new CMCdnFiletypeTtl();
        t3.setCacheType(3);
        t3.setCacheWithArgs(0);
        t3.setMode(2);
        t3.setFileType("/");
        t3.setTtl(3600 * 24 * 7);
        filetypeTtl.add(t3);


//        ReqHeadersSingle req = new ReqHeadersSingle();
//        req.setKey("X-test-key");
//        req.setValue("1111");
//        List<ReqHeadersSingle> reqHeaders = new ArrayList<>();
//        reqHeaders.add(req);
//
//        RespHeadersSingle resp = new RespHeadersSingle();
//        resp.setKey("X-test-key");
//        resp.setValue("2222");
//        List<RespHeadersSingle> respHeaders = new ArrayList<>();
//        respHeaders.add(resp);

        CMCdnDomainModifyRequest request = new CMCdnDomainModifyRequest.Builder()
                .domain("laiw1-cm.agilecdn.cn")
//                .origin(origin)
//                .reqHost(reqHost)
//                .originHostType(originHostType)
//                .originHostHttp(originHostHttp)

                .httpsBasic(basic)

//                .httpsStatus(OnOffEnum.On.getCode())
//                .certName("laiw1-cm.agilecdn.cn")

//                .filetypeTtl(filetypeTtl)

//                .reqHeaders(new ArrayList<>())
//                .respHeaders(new ArrayList<>())
                .build();

//        String params = JSON.toJSONString(request);
//        System.out.println(params);

        CMResponse response = client.modifyCdnDomain(request);

        System.out.println(JSON.toJSONString(response, SerializerFeature.WriteMapNullValue));
    }

}
