package net.agilewing.phoenix.cdn.impl.cm.model.response;

import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
@ApiModel("请求响应-查询域名列表及域名的基础信息")
public class CMCdnDomainListResponse extends CMResponse {
    private static final long serialVersionUID = -670999449257915640L;

    @ApiModelProperty(value = "返回结果列表")
    private List<CMCdnDomain> result;

    public List<CMCdnDomain> getResult() {
        return result;
    }

    public void setResult(List<CMCdnDomain> result) {
        this.result = result;
    }
}

