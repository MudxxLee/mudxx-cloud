package net.agilewing.phoenix.cdn.impl.cm.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
@ApiModel("请求响应-查询域名是否存在在途工单")
public class CMCdnOnWayOrderGetResponse extends CMResponse {
    private static final long serialVersionUID = 8919530498064098426L;

    @ApiModelProperty(value = "是否存在在途工单, true:存在，false:不存在")
    @JSONField(name = "is_exist")
    private Boolean isExist;

    @ApiModelProperty(value = "工单号")
    @JSONField(name = "order_no")
    private String orderNo;

    public Boolean getExist() {
        return isExist;
    }

    public void setExist(Boolean exist) {
        isExist = exist;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}

