package net.agilewing.phoenix.cdn.impl.cm.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
@ApiModel("请求响应-新增加速域名")
public class CMCdnDomainAddResponse extends CMResponse {
    private static final long serialVersionUID = 8396711053399996856L;

    @ApiModelProperty(value = "主域名 zone，域名校验失败时，域名对应的主域名 zone")
    @JSONField(name = "domain_zone")
    private String domainZone;

    @ApiModelProperty(value = "记录类型，域名校验失败时，生成的记录类型，如 TXT")
    @JSONField(name = "zone_type")
    private String zoneType;

    @ApiModelProperty(value = "主机记录，域名校验失败时，生成的主机记录，如 dnsverify")
    @JSONField(name = "zone_host")
    private String zoneHost;

    @ApiModelProperty(value = "记录值，域名校验失败时，生成的记录值")
    @JSONField(name = "zone_record")
    private String zoneRecord;

    public String getDomainZone() {
        return domainZone;
    }

    public void setDomainZone(String domainZone) {
        this.domainZone = domainZone;
    }

    public String getZoneType() {
        return zoneType;
    }

    public void setZoneType(String zoneType) {
        this.zoneType = zoneType;
    }

    public String getZoneHost() {
        return zoneHost;
    }

    public void setZoneHost(String zoneHost) {
        this.zoneHost = zoneHost;
    }

    public String getZoneRecord() {
        return zoneRecord;
    }

    public void setZoneRecord(String zoneRecord) {
        this.zoneRecord = zoneRecord;
    }
}

