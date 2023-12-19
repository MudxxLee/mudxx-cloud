package net.agilewing.phoenix.cdn.impl.cm.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
@ApiModel("请求响应")
public class CMResponse implements Serializable {
    private static final long serialVersionUID = 7474666959510971583L;

    private static final Integer SUCCESS_CODE = 0;

    @ApiModelProperty(value = "状态码", required = true)
    private Integer code;

    @ApiModelProperty(value = "描述信息")
    private String message;

    public boolean successful() {
        return SUCCESS_CODE.equals(this.code);
    }

    public boolean unsuccessful() {
        return !successful();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

