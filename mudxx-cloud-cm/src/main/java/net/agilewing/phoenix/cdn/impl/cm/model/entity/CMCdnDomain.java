package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 11:37
 */
@ApiModel("模型-cdn域名信息")
public class CMCdnDomain implements Serializable {
    private static final long serialVersionUID = -1381265088183174330L;

    @ApiModelProperty(value = "域名")
    private String domain;

    @ApiModelProperty(value = "CNAME记录")
    private String cname;

    @ApiModelProperty(value = "产品类型")
    @JSONField(name = "product_code")
    private String productCode;

    @ApiModelProperty(value = "产品名称")
    @JSONField(name = "product_name")
    private String productName;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "域名创建时间,单位毫秒")
    @JSONField(name = "insert_date")
    private Long insertDate;

    @ApiModelProperty(value = "加速范围")
    @JSONField(name = "area_scope")
    private Integer areaScope;

    @ApiModelProperty(value = "备案号")
    @JSONField(name = "record_num")
    private String recordNum;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Long insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getAreaScope() {
        return areaScope;
    }

    public void setAreaScope(Integer areaScope) {
        this.areaScope = areaScope;
    }

    public String getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum;
    }
}
