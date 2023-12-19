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
@ApiModel("模型-限频自助参数信息")
public class CMCdnEntryLimits implements Serializable {
    private static final long serialVersionUID = 6953202814943759777L;

    @ApiModelProperty(value = "唯一id", required = true, notes = "id不可重复")
    private String id;

    @ApiModelProperty(value = "限制参数", required = true)
    @JSONField(name = "limit_element")
    private String limitElement;

    @ApiModelProperty(value = "访问次数限制阈值", required = true, notes = "单位：次数,取值范围：大于等于0")
    @JSONField(name = "frequency_threshold")
    private Integer frequencyThreshold;

    @ApiModelProperty(value = "统计周期", required = true, notes = "单位：s,取值范围：[0, 3600]")
    @JSONField(name = "frequency_time_range")
    private Integer frequencyTimeRange;

    @ApiModelProperty(value = "拒绝访问时间", required = true, notes = "取值范围：大于等于0")
    @JSONField(name = "forbidden_duration")
    private Integer forbiddenDuration;

    @ApiModelProperty(value = "拒绝访问时间单位", notes = "取值范围：[s,millis],默认s")
    @JSONField(name = "forbidden_duration_unit")
    private String forbiddenDurationUnit;

    @ApiModelProperty(value = "封禁http访问码", notes = "取值范围：大于等于0")
    @JSONField(name = "forbidden_code")
    private Integer forbiddenCode;

    @ApiModelProperty(value = "不执行校验的客户端ip", notes = "支持ip和ip段,ipv4,ipv6")
    @JSONField(name = "white_ip_control")
    private List<String> whiteIpControl;

    @ApiModelProperty(value = "优先级", required = true, notes = "取值范围：[1,100]")
    private Integer priority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLimitElement() {
        return limitElement;
    }

    public void setLimitElement(String limitElement) {
        this.limitElement = limitElement;
    }

    public Integer getFrequencyThreshold() {
        return frequencyThreshold;
    }

    public void setFrequencyThreshold(Integer frequencyThreshold) {
        this.frequencyThreshold = frequencyThreshold;
    }

    public Integer getFrequencyTimeRange() {
        return frequencyTimeRange;
    }

    public void setFrequencyTimeRange(Integer frequencyTimeRange) {
        this.frequencyTimeRange = frequencyTimeRange;
    }

    public Integer getForbiddenDuration() {
        return forbiddenDuration;
    }

    public void setForbiddenDuration(Integer forbiddenDuration) {
        this.forbiddenDuration = forbiddenDuration;
    }

    public String getForbiddenDurationUnit() {
        return forbiddenDurationUnit;
    }

    public void setForbiddenDurationUnit(String forbiddenDurationUnit) {
        this.forbiddenDurationUnit = forbiddenDurationUnit;
    }

    public Integer getForbiddenCode() {
        return forbiddenCode;
    }

    public void setForbiddenCode(Integer forbiddenCode) {
        this.forbiddenCode = forbiddenCode;
    }

    public List<String> getWhiteIpControl() {
        return whiteIpControl;
    }

    public void setWhiteIpControl(List<String> whiteIpControl) {
        this.whiteIpControl = whiteIpControl;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
