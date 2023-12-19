package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-错误状态码缓存信息")
public class CMCdnErrorCode implements Serializable {
    private static final long serialVersionUID = -4862522871049881250L;

    @ApiModelProperty(value = "错误状态码", required = true)
    private List<Integer> code;

    @ApiModelProperty(value = "缓存时间", required = true, notes = "单位秒,取值范围：0-31536000")
    private Integer ttl;

    public List<Integer> getCode() {
        return code;
    }

    public void setCode(List<Integer> code) {
        this.code = code;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }
}
