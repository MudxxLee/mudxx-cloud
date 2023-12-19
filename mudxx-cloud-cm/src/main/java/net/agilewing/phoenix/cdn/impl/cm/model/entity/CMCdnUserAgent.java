package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 11:37
 */
@ApiModel("模型-黑白名单配置")
public class CMCdnUserAgent implements Serializable {
    private static final long serialVersionUID = -8562044362861544895L;

    @ApiModelProperty(value = "类型", notes = "0:（黑名单）； 1（ 白名单）")
    private Integer type;

    @ApiModelProperty(value = "user_agent列表")
    private List<String> ua;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<String> getUa() {
        return ua;
    }

    public void setUa(List<String> ua) {
        this.ua = ua;
    }
}
