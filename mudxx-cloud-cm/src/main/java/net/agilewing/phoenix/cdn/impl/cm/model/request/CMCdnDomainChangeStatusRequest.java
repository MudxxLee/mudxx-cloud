package net.agilewing.phoenix.cdn.impl.cm.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求参数-删除/启用/停用域名")
public class CMCdnDomainChangeStatusRequest implements Serializable {
    private static final long serialVersionUID = 8082665673214210603L;

    @ApiModelProperty(value = "域名", required = true)
    private String domain;

    @ApiModelProperty(value = "产品类型", required = true, notes = "支持产品类型")
    @JSONField(name = "product_code")
    private String productCode;

    @ApiModelProperty(value = "域名状态", required = true, notes = "1（删除），2（停用），3（启用）")
    private Integer status;

    public CMCdnDomainChangeStatusRequest() {
    }

    private CMCdnDomainChangeStatusRequest(Builder builder) {
        setDomain(builder.domain);
        setProductCode(builder.productCode);
        setStatus(builder.status);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static final class Builder {
        private String domain;
        private String productCode;
        private Integer status;

        public Builder() {
        }

        public Builder domain(String val) {
            domain = val;
            return this;
        }

        public Builder productCode(String val) {
            productCode = val;
            return this;
        }

        public Builder status(Integer val) {
            status = val;
            return this;
        }

        public CMCdnDomainChangeStatusRequest build() {
            return new CMCdnDomainChangeStatusRequest(this);
        }
    }
}
