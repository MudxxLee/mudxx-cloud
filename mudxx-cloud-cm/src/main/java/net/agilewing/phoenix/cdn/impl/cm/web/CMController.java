package net.agilewing.phoenix.cdn.impl.cm.web;

import com.mudxx.cloud.biz.common.api.ApiException;
import io.swagger.annotations.ApiOperation;
import net.agilewing.phoenix.cdn.impl.cm.model.request.CMCdnDomainModifyRequest;
import net.agilewing.phoenix.cdn.impl.cm.services.client.CMCdnApiClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laiw
 * @date 2023/9/25 12:00
 */
@RestController
@RequestMapping("/api/cm")
public class CMController {

    private final CMCdnApiClient cdnApiClient = new CMCdnApiClient(
            "",
            null
    );

    @PostMapping(value = "/modify-cdn-domain")
    @ApiOperation(value = "移动CM-CDN-编辑域名")
    public void create(@RequestBody CMCdnDomainModifyRequest request) throws ApiException {
        cdnApiClient.modifyCdnDomain(request);
    }

}
