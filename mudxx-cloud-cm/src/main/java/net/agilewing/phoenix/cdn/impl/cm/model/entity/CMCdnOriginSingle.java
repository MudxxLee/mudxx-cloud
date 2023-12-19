package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 11:37
 */
@ApiModel("模型-回源信息")
public class CMCdnOriginSingle implements Serializable {
    private static final long serialVersionUID = 7825169082888592530L;

    @ApiModelProperty(value = "源站 ip 或域名", required = true)
    private String origin;

    @ApiModelProperty(value = "源站端口", notes = "不传默认80，不可传443，多个源站时，源站端口需保持一致")
    private Integer port;

    @ApiModelProperty(value = "权重", required = true, notes = "范围：1-100, role和weight都不存在或取值一致时，按轮询策略")
    private Integer weight;

    @ApiModelProperty(value = "源站角色", required = true, notes = "取值: master, slave")
    private String role;

    @ApiModelProperty(value = "源站类型", notes = "默认http，目前不支持自定义配置https源站")
    private String protocol;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
