package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-url参数限速信息")
public class CMCdnLimitSpeedUri implements Serializable {
    private static final long serialVersionUID = 2323319844201441630L;

    @ApiModelProperty(value = "limit_speed_uri列表内唯一", required = true, notes = "可以考虑使用时间戳拼上列表索引，比如时间戳为11657615509083，拼上序列化0，则 id为：116576155090830")
    private String id;

    @ApiModelProperty(value = "单位", required = true, notes = "可选值b/s，Kb/s，Mb/s")
    private String unit;

    @ApiModelProperty(value = "uri参数名", required = true)
    private String args;

    @ApiModelProperty(value = "时段", notes = "正则表达式，比如：(08:[2-5][0-9]")
    @JSONField(name = "time_seg")
    private String timeSeg;

    @ApiModelProperty(value = "优先级", notes = "默认值10，取值范围[1,)")
    private Integer weight;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getTimeSeg() {
        return timeSeg;
    }

    public void setTimeSeg(String timeSeg) {
        this.timeSeg = timeSeg;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
