package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-自定义回源请求头信息")
public class CMCdnReqHeaders implements Serializable {
    private static final long serialVersionUID = -4862522871049881250L;

    @ApiModelProperty(value = "自定义回源请求头名称", required = true)
    private String key;

    @ApiModelProperty(value = "自定义回源请求头值", notes = "默认\"\"")
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
