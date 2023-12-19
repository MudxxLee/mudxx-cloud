package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/25 14:26
 */
@ApiModel("模型-请求头参数")
public class CMCdnUseMainRequestHeaders implements Serializable {
    private static final long serialVersionUID = 1761466362674695064L;

    @ApiModelProperty(value = "请求头参数key", required = true)
    @JSONField(name = "arg_name")
    private String argName;

    @ApiModelProperty(value = "请求头参数value", notes = "默认空，空代表删除")
    @JSONField(name = "arg_value")
    private String argValue;

    public String getArgName() {
        return argName;
    }

    public void setArgName(String argName) {
        this.argName = argName;
    }

    public String getArgValue() {
        return argValue;
    }

    public void setArgValue(String argValue) {
        this.argValue = argValue;
    }
}
