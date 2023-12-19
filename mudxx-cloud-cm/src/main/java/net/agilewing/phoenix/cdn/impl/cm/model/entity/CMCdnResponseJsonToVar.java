package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/25 14:26
 */
@ApiModel("模型-JSON鉴权")
public class CMCdnResponseJsonToVar implements Serializable {
    private static final long serialVersionUID = -2195432090489078704L;

    @ApiModelProperty(value = "鉴权不通过状态码", notes = "有运维condition，id为RemoteSyncAuth的id+_json_forbidden_code，" +
            "如xxxxxx_json_forbidden_code，此参数只有有配置condition的时候才生效")
    @JSONField(name = "forbidden_code")
    private Integer forbiddenCode;

    @ApiModelProperty(value = "json数据", notes = "成对出现，可添加多对")
    @JSONField(name = "json_var_list")
    private List<CMCdnJsonToVarList> jsonVarList;

    @ApiModelProperty(value = "json数据开关", notes = "0（关），1（开）")
    @JSONField(name = "switch")
    private Integer jsonSwitch;

    public Integer getForbiddenCode() {
        return forbiddenCode;
    }

    public void setForbiddenCode(Integer forbiddenCode) {
        this.forbiddenCode = forbiddenCode;
    }

    public List<CMCdnJsonToVarList> getJsonVarList() {
        return jsonVarList;
    }

    public void setJsonVarList(List<CMCdnJsonToVarList> jsonVarList) {
        this.jsonVarList = jsonVarList;
    }

    public Integer getJsonSwitch() {
        return jsonSwitch;
    }

    public void setJsonSwitch(Integer jsonSwitch) {
        this.jsonSwitch = jsonSwitch;
    }
}
