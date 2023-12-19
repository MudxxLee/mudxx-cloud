package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 11:37
 */
@ApiModel("模型-每个时间间隔的回源请求状态码数数据信息")
public class CMCdnReqMissHttpStatusCodeDataInterval implements Serializable {
    private static final long serialVersionUID = 2627682212103821962L;

    @ApiModelProperty(value = "时间片开始时间戳")
    @JSONField(name = "time_stamp")
    private Integer timeStamp;

    @ApiModelProperty(value = "域名")
    private String domain;

    @ApiModelProperty(value = "产品类型")
    @JSONField(name = "product_type")
    private String productType;

    @ApiModelProperty(value = "省编码")
    private String province;

    @ApiModelProperty(value = "运营商编码")
    private String isp;

    @ApiModelProperty(value = "网络层协议")
    @JSONField(name = "network_layer_protocol")
    private String networkLayerProtocol;

    @ApiModelProperty(value = "应用层协议")
    @JSONField(name = "application_layer_protocol")
    private String applicationLayerProtocol;

    @ApiModelProperty(value = "回源状态码")
    @JSONField(name = "miss_http_status_code")
    private String missHttpStatusCode;

    @ApiModelProperty(value = "回源状态码个数")
    @JSONField(name = "miss_http_status_code_num")
    private Integer missHttpStatusCodeNum;

    @ApiModelProperty(value = "回源状态码占比（百分比，保留两位小数）")
    @JSONField(name = "miss_http_status_code_proportion")
    private Float missHttpStatusCodeProportion;

    public Integer getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getNetworkLayerProtocol() {
        return networkLayerProtocol;
    }

    public void setNetworkLayerProtocol(String networkLayerProtocol) {
        this.networkLayerProtocol = networkLayerProtocol;
    }

    public String getApplicationLayerProtocol() {
        return applicationLayerProtocol;
    }

    public void setApplicationLayerProtocol(String applicationLayerProtocol) {
        this.applicationLayerProtocol = applicationLayerProtocol;
    }

    public String getMissHttpStatusCode() {
        return missHttpStatusCode;
    }

    public void setMissHttpStatusCode(String missHttpStatusCode) {
        this.missHttpStatusCode = missHttpStatusCode;
    }

    public Integer getMissHttpStatusCodeNum() {
        return missHttpStatusCodeNum;
    }

    public void setMissHttpStatusCodeNum(Integer missHttpStatusCodeNum) {
        this.missHttpStatusCodeNum = missHttpStatusCodeNum;
    }

    public Float getMissHttpStatusCodeProportion() {
        return missHttpStatusCodeProportion;
    }

    public void setMissHttpStatusCodeProportion(Float missHttpStatusCodeProportion) {
        this.missHttpStatusCodeProportion = missHttpStatusCodeProportion;
    }
}
