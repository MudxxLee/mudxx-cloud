package net.agilewing.phoenix.cdn.impl.cm.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnOrigin;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求参数-新增加速域名")
public class CMCdnDomainAddRequest implements Serializable {
    private static final long serialVersionUID = 7129144102025684786L;

    @ApiModelProperty(value = "域名", required = true, notes = "仅支持单个域名新增")
    private String domain;

    @ApiModelProperty(value = "域名操作动作", required = true, notes = "固定值 1")
    private Integer action;

    @ApiModelProperty(value = "产品类型", required = true, notes = "支持产品类型")
    @JSONField(name = "product_code")
    private String productCode;

    @ApiModelProperty(value = "源站信息", required = true)
    private List<CMCdnOrigin> origin;


    /*--------------------------------------------------------------可选参数--------------------------------------------------------------*/

    @ApiModelProperty(value = "是否开启安全 WAF 防护。1（启用）； 2（关闭）",
            notes = "仅适用 product_code 为 007（安全加速）时才生效，且 product_code 为 007（安全加速）时，waf_enable 和 ddos_enable 至少启用一个")
    @JSONField(name = "waf_enable")
    private Integer wafEnable;

    @ApiModelProperty(value = "是否开启安全抗 D 服务。1（启用）； 2（关闭）",
            notes = "仅适用 product_code 为 007（安全加速）时才生效，且 product_code 为 007（安全加速）时，" +
                    "waf_enable 和 ddos_enable 至少启用一个,且调用本接口开启安全抗 D 服务后，仍需人工处理，请创建后联系专属售后运营人员处理")
    @JSONField(name = "ddos_enable")
    private Integer ddosEnable;

    @ApiModelProperty(value = "加速范围", notes = "1（国内）；2（海外）； 3（国内+海外），不填默认为 1")
    @JSONField(name = "area_scope")
    private Integer areaScope;

    @ApiModelProperty(value = "ipv6 启用", notes = "1（启用）； 2（关闭），不传默认关闭")
    @JSONField(name = "ipv6_enable")
    private Integer ipv6Enable;


    public CMCdnDomainAddRequest() {
    }

    private CMCdnDomainAddRequest(Builder builder) {
        setDomain(builder.domain);
        setAction(builder.action);
        setProductCode(builder.productCode);
        setOrigin(builder.origin);
        setWafEnable(builder.wafEnable);
        setDdosEnable(builder.ddosEnable);
        setAreaScope(builder.areaScope);
        setIpv6Enable(builder.ipv6Enable);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public List<CMCdnOrigin> getOrigin() {
        return origin;
    }

    public void setOrigin(List<CMCdnOrigin> origin) {
        this.origin = origin;
    }

    public Integer getWafEnable() {
        return wafEnable;
    }

    public void setWafEnable(Integer wafEnable) {
        this.wafEnable = wafEnable;
    }

    public Integer getDdosEnable() {
        return ddosEnable;
    }

    public void setDdosEnable(Integer ddosEnable) {
        this.ddosEnable = ddosEnable;
    }

    public Integer getAreaScope() {
        return areaScope;
    }

    public void setAreaScope(Integer areaScope) {
        this.areaScope = areaScope;
    }

    public Integer getIpv6Enable() {
        return ipv6Enable;
    }

    public void setIpv6Enable(Integer ipv6Enable) {
        this.ipv6Enable = ipv6Enable;
    }

    public static final class Builder {
        private String domain;
        private Integer action;
        private String productCode;
        private List<CMCdnOrigin> origin;
        private Integer wafEnable;
        private Integer ddosEnable;
        private Integer areaScope;
        private Integer ipv6Enable;

        public Builder() {
        }

        public Builder domain(String val) {
            domain = val;
            return this;
        }

        public Builder action(Integer val) {
            action = val;
            return this;
        }

        public Builder productCode(String val) {
            productCode = val;
            return this;
        }

        public Builder origin(List<CMCdnOrigin> val) {
            origin = val;
            return this;
        }

        public Builder wafEnable(Integer val) {
            wafEnable = val;
            return this;
        }

        public Builder ddosEnable(Integer val) {
            ddosEnable = val;
            return this;
        }

        public Builder areaScope(Integer val) {
            areaScope = val;
            return this;
        }

        public Builder ipv6Enable(Integer val) {
            ipv6Enable = val;
            return this;
        }

        public CMCdnDomainAddRequest build() {
            return new CMCdnDomainAddRequest(this);
        }
    }
}
