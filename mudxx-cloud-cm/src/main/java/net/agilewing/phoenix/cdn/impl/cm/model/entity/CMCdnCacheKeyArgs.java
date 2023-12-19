package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-缓存参数信息")
public class CMCdnCacheKeyArgs implements Serializable {
    private static final long serialVersionUID = 603317097916783888L;

    @ApiModelProperty(value = "基于缓存参数唯一标识", required = true, notes = "id不可重复")
    private String id;

    @ApiModelProperty(value = "去参数缓存开关", notes = "取值：0:否，1 是, 默认值1，取值范围[0,1]")
    private Integer ignore;

    @ApiModelProperty(value = "带特定参数缓存", notes = "取值：0:否，1 是, 默认值1，取值范围[0,1]")
    @JSONField(name = "is_with_args")
    private Integer isWithArgs;

    @ApiModelProperty(value = "匹配方式", notes = "取值：0: 字符串, 1 正则 默认值0，取值范围[0,1]")
    private Integer mode;

    @ApiModelProperty(value = "匹配方式为0时配置的参数", notes = "匹配方式为0时配置的参数，默认值\"\"")
    private String args;

    @ApiModelProperty(value = "匹配方式为1时配置，目前没用", notes = "默认值\"\"")
    private String subject;

    @ApiModelProperty(value = "匹配方式为1时配置，目前没用", notes = "默认值\"\"")
    private String pattern;

    @ApiModelProperty(value = "匹配方式为1时配置，目前没用", notes = "默认值\"\"")
    private String replace;

    @ApiModelProperty(value = "优先级", notes = "默认值10，取值范围[1,100]")
    private Integer priority;

    @ApiModelProperty(value = "忽略特定参数缓存", notes = "默认值\"\",若需要忽略多个参数，中间用逗号分割")
    @JSONField(name = "ignore_args")
    private String ignoreArgs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIgnore() {
        return ignore;
    }

    public void setIgnore(Integer ignore) {
        this.ignore = ignore;
    }

    public Integer getIsWithArgs() {
        return isWithArgs;
    }

    public void setIsWithArgs(Integer isWithArgs) {
        this.isWithArgs = isWithArgs;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getIgnoreArgs() {
        return ignoreArgs;
    }

    public void setIgnoreArgs(String ignoreArgs) {
        this.ignoreArgs = ignoreArgs;
    }
}
