package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/20 11:37
 */
@ApiModel("模型-md5 时间戳防盗链")
public class CMCdnMd5SecureTime implements Serializable {
    private static final long serialVersionUID = -7498821671475523817L;

    @ApiModelProperty(value = "md5 加密方式分隔符")
    @JSONField(name = "delim_time_char")
    private String delimTimeChar;

    @ApiModelProperty(value = "加密元素设置")
    private List<Object> element;

    @ApiModelProperty(value = "校验不通过状态码", notes = "默认403")
    @JSONField(name = "forbidden_code")
    private Integer forbiddenCode;

    @ApiModelProperty(value = "配置名")
    private String id;

    @ApiModelProperty(value = "md5 校验参数名称")
    @JSONField(name = "md5_arg")
    private String md5Arg;

    @ApiModelProperty(value = "md5 校验不通过状态码")
    @JSONField(name = "md5_forbidden_code")
    private Integer md5ForbiddenCode;

    @ApiModelProperty(value = "md5 校验码位置")
    @JSONField(name = "md5_path")
    private Integer md5Path;

    @ApiModelProperty(value = "自定义目录")
    @JSONField(name = "md5_path_custom")
    private String md5PathCustom;

    @ApiModelProperty(value = "目录级别")
    @JSONField(name = "md5_path_level")
    private Integer md5PathLevel;

    @ApiModelProperty(value = "md5 模式名称")
    @JSONField(name = "md5_pattern")
    private String md5Pattern;

    @ApiModelProperty(value = "md5 替代内容")
    @JSONField(name = "md5_replace")
    private String md5Replace;

    @ApiModelProperty(value = "md5 校验开关")
    @JSONField(name = "md5_switch")
    private Integer md5Switch;

    @ApiModelProperty(value = "权重")
    private Integer priority;

    @ApiModelProperty(value = "参数名称")
    @JSONField(name = "time_arg")
    private String timeArg;

    @ApiModelProperty(value = "时间戳格式")
    @JSONField(name = "time_format")
    private Integer timeFormat;

    @ApiModelProperty(value = "可访问起始时长")
    @JSONField(name = "time_lower_limit")
    private Integer timeLowerLimit;

    @ApiModelProperty(value = "md5 校验长度")
    @JSONField(name = "time_md5_length")
    private Integer timeMd5Length;

    @ApiModelProperty(value = "md5 校验起始位置")
    @JSONField(name = "time_md5_start")
    private Integer timeMd5Start;

    @ApiModelProperty(value = "时间戳位置")
    @JSONField(name = "time_path")
    private Integer timePath;

    @ApiModelProperty(value = "自定义目录")
    @JSONField(name = "time_path_custom")
    private String timePathCustom;

    @ApiModelProperty(value = "目录级别")
    @JSONField(name = "time_path_level")
    private Integer timePathLevel;

    @ApiModelProperty(value = "time 模式名称")
    @JSONField(name = "time_pattern")
    private String timePattern;

    @ApiModelProperty(value = "time 替代内容")
    @JSONField(name = "time_replace")
    private String timeReplace;

    @ApiModelProperty(value = "时间戳校验开关")
    @JSONField(name = "time_switch")
    private Integer timeSwitch;

    @ApiModelProperty(value = "时间戳有效期")
    @JSONField(name = "time_upper_limit")
    private Integer timeUpperLimit;

    public String getDelimTimeChar() {
        return delimTimeChar;
    }

    public void setDelimTimeChar(String delimTimeChar) {
        this.delimTimeChar = delimTimeChar;
    }

    public List<Object> getElement() {
        return element;
    }

    public void setElement(List<Object> element) {
        this.element = element;
    }

    public Integer getForbiddenCode() {
        return forbiddenCode;
    }

    public void setForbiddenCode(Integer forbiddenCode) {
        this.forbiddenCode = forbiddenCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMd5Arg() {
        return md5Arg;
    }

    public void setMd5Arg(String md5Arg) {
        this.md5Arg = md5Arg;
    }

    public Integer getMd5ForbiddenCode() {
        return md5ForbiddenCode;
    }

    public void setMd5ForbiddenCode(Integer md5ForbiddenCode) {
        this.md5ForbiddenCode = md5ForbiddenCode;
    }

    public Integer getMd5Path() {
        return md5Path;
    }

    public void setMd5Path(Integer md5Path) {
        this.md5Path = md5Path;
    }

    public String getMd5PathCustom() {
        return md5PathCustom;
    }

    public void setMd5PathCustom(String md5PathCustom) {
        this.md5PathCustom = md5PathCustom;
    }

    public Integer getMd5PathLevel() {
        return md5PathLevel;
    }

    public void setMd5PathLevel(Integer md5PathLevel) {
        this.md5PathLevel = md5PathLevel;
    }

    public String getMd5Pattern() {
        return md5Pattern;
    }

    public void setMd5Pattern(String md5Pattern) {
        this.md5Pattern = md5Pattern;
    }

    public String getMd5Replace() {
        return md5Replace;
    }

    public void setMd5Replace(String md5Replace) {
        this.md5Replace = md5Replace;
    }

    public Integer getMd5Switch() {
        return md5Switch;
    }

    public void setMd5Switch(Integer md5Switch) {
        this.md5Switch = md5Switch;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTimeArg() {
        return timeArg;
    }

    public void setTimeArg(String timeArg) {
        this.timeArg = timeArg;
    }

    public Integer getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(Integer timeFormat) {
        this.timeFormat = timeFormat;
    }

    public Integer getTimeLowerLimit() {
        return timeLowerLimit;
    }

    public void setTimeLowerLimit(Integer timeLowerLimit) {
        this.timeLowerLimit = timeLowerLimit;
    }

    public Integer getTimeMd5Length() {
        return timeMd5Length;
    }

    public void setTimeMd5Length(Integer timeMd5Length) {
        this.timeMd5Length = timeMd5Length;
    }

    public Integer getTimeMd5Start() {
        return timeMd5Start;
    }

    public void setTimeMd5Start(Integer timeMd5Start) {
        this.timeMd5Start = timeMd5Start;
    }

    public Integer getTimePath() {
        return timePath;
    }

    public void setTimePath(Integer timePath) {
        this.timePath = timePath;
    }

    public String getTimePathCustom() {
        return timePathCustom;
    }

    public void setTimePathCustom(String timePathCustom) {
        this.timePathCustom = timePathCustom;
    }

    public Integer getTimePathLevel() {
        return timePathLevel;
    }

    public void setTimePathLevel(Integer timePathLevel) {
        this.timePathLevel = timePathLevel;
    }

    public String getTimePattern() {
        return timePattern;
    }

    public void setTimePattern(String timePattern) {
        this.timePattern = timePattern;
    }

    public String getTimeReplace() {
        return timeReplace;
    }

    public void setTimeReplace(String timeReplace) {
        this.timeReplace = timeReplace;
    }

    public Integer getTimeSwitch() {
        return timeSwitch;
    }

    public void setTimeSwitch(Integer timeSwitch) {
        this.timeSwitch = timeSwitch;
    }

    public Integer getTimeUpperLimit() {
        return timeUpperLimit;
    }

    public void setTimeUpperLimit(Integer timeUpperLimit) {
        this.timeUpperLimit = timeUpperLimit;
    }
}
