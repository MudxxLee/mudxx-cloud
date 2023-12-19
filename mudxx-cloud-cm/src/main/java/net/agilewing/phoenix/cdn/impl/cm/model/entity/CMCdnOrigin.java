package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("模型-源站信息")
public class CMCdnOrigin implements Serializable {
    private static final long serialVersionUID = -2156297411072660921L;

    @ApiModelProperty(value = "源站 ip 或域名", required = true)
    private String origin;

    @ApiModelProperty(value = "源站端口", required = true,
            notes = "支持 http 自定义端口，http 不支持下发 443 端口，多个源站时，源站端口需保持一致，若不一致以第一个源站端口为准")
    private Integer port;

    @ApiModelProperty(value = "权重", required = true, notes = "范围：1-100")
    private Integer weight;

    @ApiModelProperty(value = "源站角色", required = true, notes = "取值: master, slave")
    private String role;

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
}
