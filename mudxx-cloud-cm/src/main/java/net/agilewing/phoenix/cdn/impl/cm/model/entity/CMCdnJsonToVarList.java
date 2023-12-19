package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/25 14:26
 */
@ApiModel("模型-JSON数据")
public class CMCdnJsonToVarList implements Serializable {
    private static final long serialVersionUID = -2195432090489078704L;

    @ApiModelProperty(value = "变量名", required = true)
    @JSONField(name = "arg_name")
    private String argName;

    @ApiModelProperty(value = "变量值", required = true)
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
