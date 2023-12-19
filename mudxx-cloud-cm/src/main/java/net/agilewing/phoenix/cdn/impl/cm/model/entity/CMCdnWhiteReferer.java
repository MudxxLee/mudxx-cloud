package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-白名单信息")
public class CMCdnWhiteReferer implements Serializable {
    private static final long serialVersionUID = -2650273634228009834L;

    @ApiModelProperty(value = "referer是否允许为空", notes = "取值 on, off，默认off")
    @JSONField(name = "allow_empty")
    private String allowEmpty;

    @ApiModelProperty(value = "referer白名单列表", notes = "默认[]")
    @JSONField(name = "allow_list")
    private List<String> allowList;

    @ApiModelProperty(value = "是否追加referer白名单列表", notes = "是否在原来的白名单列表基础上追加白名单，取值 1:追加, 0:覆盖，不传默认0覆盖。" +
            "当传入的值为1的时候，将当前传入的allow_list追加到已有配置的白名单列表。当传入值0或者不传值的时候，当前传入的allow_list覆盖已有配置的白名单列表")
    @JSONField(name = "is_append")
    private Integer isAppend;

    public String getAllowEmpty() {
        return allowEmpty;
    }

    public void setAllowEmpty(String allowEmpty) {
        this.allowEmpty = allowEmpty;
    }

    public List<String> getAllowList() {
        return allowList;
    }

    public void setAllowList(List<String> allowList) {
        this.allowList = allowList;
    }

    public Integer getIsAppend() {
        return isAppend;
    }

    public void setIsAppend(Integer isAppend) {
        this.isAppend = isAppend;
    }
}
