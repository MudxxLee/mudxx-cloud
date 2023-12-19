package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("模型-日志信息")
public class CMCdnLog implements Serializable {
    private static final long serialVersionUID = 5411016172434862273L;

    @ApiModelProperty(value = "日志文件包含的时间点", notes = "北京时间，格式为： YYYY-MM-DD HH:MM")
    @JSONField(name = "timepoint")
    private String timePoint;

    @ApiModelProperty(value = "日志文件大小，单位：B")
    private Integer size;

    @ApiModelProperty(value = "日志文件下载路径")
    private String url;

    @ApiModelProperty(value = "日志文件 md5 值")
    private String md5;

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
