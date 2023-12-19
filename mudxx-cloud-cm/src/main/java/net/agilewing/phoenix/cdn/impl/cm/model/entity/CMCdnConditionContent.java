package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-自定义回源请求头信息")
public class CMCdnConditionContent implements Serializable {
    private static final long serialVersionUID = -7022429927337291646L;

    @ApiModelProperty(value = "类型", required = true)
    private Integer mode;

    @ApiModelProperty(value = "内容")
    private String content;

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
