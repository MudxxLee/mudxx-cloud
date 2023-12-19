package net.agilewing.phoenix.cdn.impl.cm.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求参数-查询请求数,回源请求数,请求命中率数据")
public class CMCdnReqNumDataListRequest implements Serializable {
    private static final long serialVersionUID = -2212866456806341566L;

    @ApiModelProperty(value = "起始时间", required = true, notes = "时间戳(秒)")
    @JSONField(name = "start_time")
    private Integer startTime;

    @ApiModelProperty(value = "结束时间", notes = "时间戳(秒)")
    @JSONField(name = "end_time")
    private Integer endTime;

    @ApiModelProperty(value = "时间粒度", notes = "目前支持 1m，5m，1h 和 24h，默认 5m。")
    private String interval;

    @ApiModelProperty(value = "域名", notes = "不传默认名下所有域名")
    private List<String> domain;

    @ApiModelProperty(value = "产品类型", notes = "不传默认名下所有产品")
    @JSONField(name = "product_type")
    private List<String> productType;

    @ApiModelProperty(value = "省编码", notes = "不传默认名下所有省编码，" +
            "安徽:340000,浙江:330000,上海:310000,江苏:320000,福建:350000,山东:370000,广东:440000,广西:450000,海南:460000,江西:360000," +
            "河南:410000,湖南:430000,湖北:420000,辽宁:210000,吉林:220000,黑龙江:230000,陕西:610000,甘肃:620000,青海:630000,宁夏:640000," +
            "新疆:650000,北京:110000,天津:120000,河北:130000,山西:140000,内蒙古:150000,重庆:500000,四川:510000,贵州:520000,云南:530000," +
            "西藏:540000,香港:810000,澳门:820000,台湾:710000," +
            "华东: 1001, 华南: 1002, 华中: 1003, 东北: 1004, 西北: 1005, 华北: 1006, 西南: 1007, 港澳台地区: 0000, 其他:-2")
    private List<Integer> province;

    @ApiModelProperty(value = "运营商编码", notes = "不传默认名下所有运营商编码，" +
            "电信:001,联通:002,移动:003,中国铁通:004,教育网:005,鹏博士:006,多线:007,BGP:008,长城宽带:009,广电网络:010,其他:100")
    private List<String> isp;

    @ApiModelProperty(value = "网络层协议", notes = "不传默认所有网络层协议，支持作为统计筛选项，可以为 ipv4、ipv6，other。")
    @JSONField(name = "network_layer_protocol")
    private String networkLayerProtocol;

    @ApiModelProperty(value = "应用层协议", notes = "不传默认所有络层协议，支持作为统计筛选项，可以为 http，https，rtmp，quic，other。")
    @JSONField(name = "application_layer_protocol")
    private String applicationLayerProtocol;

    @ApiModelProperty(value = "结果聚合维度", notes = "指标在计算结果的聚合维度，不传或为空默认按照时间粒度聚合，可多个统计维度，" +
            "可以为 product_type，domain，province，isp，network_layer_protocol，application_layer_protocol。")
    @JSONField(name = "group_by")
    private List<String> groupBy;

    public CMCdnReqNumDataListRequest() {
    }

    private CMCdnReqNumDataListRequest(Builder builder) {
        setStartTime(builder.startTime);
        setEndTime(builder.endTime);
        setInterval(builder.interval);
        setDomain(builder.domain);
        setProductType(builder.productType);
        setProvince(builder.province);
        setIsp(builder.isp);
        setNetworkLayerProtocol(builder.networkLayerProtocol);
        setApplicationLayerProtocol(builder.applicationLayerProtocol);
        setGroupBy(builder.groupBy);
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public List<String> getDomain() {
        return domain;
    }

    public void setDomain(List<String> domain) {
        this.domain = domain;
    }

    public List<String> getProductType() {
        return productType;
    }

    public void setProductType(List<String> productType) {
        this.productType = productType;
    }

    public List<Integer> getProvince() {
        return province;
    }

    public void setProvince(List<Integer> province) {
        this.province = province;
    }

    public List<String> getIsp() {
        return isp;
    }

    public void setIsp(List<String> isp) {
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

    public List<String> getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(List<String> groupBy) {
        this.groupBy = groupBy;
    }

    public static final class Builder {
        private Integer startTime;
        private Integer endTime;
        private String interval;
        private List<String> domain;
        private List<String> productType;
        private List<Integer> province;
        private List<String> isp;
        private String networkLayerProtocol;
        private String applicationLayerProtocol;
        private List<String> groupBy;

        public Builder() {
        }

        public Builder startTime(Integer val) {
            startTime = val;
            return this;
        }

        public Builder endTime(Integer val) {
            endTime = val;
            return this;
        }

        public Builder interval(String val) {
            interval = val;
            return this;
        }

        public Builder domain(List<String> val) {
            domain = val;
            return this;
        }

        public Builder productType(List<String> val) {
            productType = val;
            return this;
        }

        public Builder province(List<Integer> val) {
            province = val;
            return this;
        }

        public Builder isp(List<String> val) {
            isp = val;
            return this;
        }

        public Builder networkLayerProtocol(String val) {
            networkLayerProtocol = val;
            return this;
        }

        public Builder applicationLayerProtocol(String val) {
            applicationLayerProtocol = val;
            return this;
        }

        public Builder groupBy(List<String> val) {
            groupBy = val;
            return this;
        }

        public CMCdnReqNumDataListRequest build() {
            return new CMCdnReqNumDataListRequest(this);
        }
    }
}
