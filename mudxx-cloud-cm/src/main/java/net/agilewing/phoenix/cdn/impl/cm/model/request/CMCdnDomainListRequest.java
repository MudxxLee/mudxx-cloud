package net.agilewing.phoenix.cdn.impl.cm.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求参数-查询域名列表及域名的基础信息")
public class CMCdnDomainListRequest implements Serializable {
    private static final long serialVersionUID = 7372278545701640573L;

    @ApiModelProperty(value = "域名", notes = "不填默认所有域名")
    private String domain;

    @ApiModelProperty(value = "产品类型", notes = "支持产品类型：001(静态加速)，003(下载加速)，004(视频点播加速)，008(CDN 加速)，" +
            "007(安全加速)，005(直播加速)，006(全站加速)，009(应用加速),010(web 应用防火墙（边缘云版）),011(高防 DDoS（边缘云版）)，不填默认所有产品")
    @JSONField(name = "product_code")
    private String productCode;

    @ApiModelProperty(value = "状态", notes = "1（审核中）；2（审核成功），3（配置中）；4（已启用）；5（停止中）；6（已停止）；" +
            "7（删除中）；8（已删除）；9（审核失败）；10（配置失败）；11（停止失败）；12（删除失败），不填默认所有状态")
    private Integer status;

    @ApiModelProperty(value = "加速范围", notes = "1（国内）；2（海外）； 3（国内+海外），不填默认为 1")
    @JSONField(name = "area_scope")
    private Integer areaScope;

    public CMCdnDomainListRequest() {
    }

    private CMCdnDomainListRequest(Builder builder) {
        setDomain(builder.domain);
        setProductCode(builder.productCode);
        setStatus(builder.status);
        setAreaScope(builder.areaScope);
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

    public Integer getAreaScope() {
        return areaScope;
    }

    public void setAreaScope(Integer areaScope) {
        this.areaScope = areaScope;
    }

    public static final class Builder {
        private String domain;
        private String productCode;
        private Integer status;
        private Integer areaScope;

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

        public Builder areaScope(Integer val) {
            areaScope = val;
            return this;
        }

        public CMCdnDomainListRequest build() {
            return new CMCdnDomainListRequest(this);
        }
    }
}
