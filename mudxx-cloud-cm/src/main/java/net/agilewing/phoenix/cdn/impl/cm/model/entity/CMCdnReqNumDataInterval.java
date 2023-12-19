package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 11:37
 */
@ApiModel("模型-每个时间间隔的请求数数据信息")
public class CMCdnReqNumDataInterval implements Serializable {
    private static final long serialVersionUID = 5748010119001422853L;

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

    @ApiModelProperty(value = "请求数")
    @JSONField(name = "request_num")
    private Integer requestNum;

    @ApiModelProperty(value = "回源请求数")
    @JSONField(name = "miss_request_num")
    private Integer missRequestNum;

    @ApiModelProperty(value = "请求命中率")
    @JSONField(name = "hit_request_rate")
    private Float hitRequestRate;

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

    public Integer getRequestNum() {
        return requestNum;
    }

    public void setRequestNum(Integer requestNum) {
        this.requestNum = requestNum;
    }

    public Integer getMissRequestNum() {
        return missRequestNum;
    }

    public void setMissRequestNum(Integer missRequestNum) {
        this.missRequestNum = missRequestNum;
    }

    public Float getHitRequestRate() {
        return hitRequestRate;
    }

    public void setHitRequestRate(Float hitRequestRate) {
        this.hitRequestRate = hitRequestRate;
    }
}
