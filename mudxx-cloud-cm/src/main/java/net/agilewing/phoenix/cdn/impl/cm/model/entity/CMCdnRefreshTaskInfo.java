package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 11:37
 */
@ApiModel("模型-刷新任务结果信息")
public class CMCdnRefreshTaskInfo implements Serializable {
    private static final long serialVersionUID = 1053658638599612332L;

    @ApiModelProperty(value = "刷新的URL")
    private String url;

    @ApiModelProperty(value = "提交时间")
    @JSONField(name = "submit_time")
    private String submitTime;

    @ApiModelProperty(value = "任务类型", notes = "url；dirs")
    private String type;

    @ApiModelProperty(value = "任务执行状态", notes = "processing(进行中); completed(成功); failed(失败)")
    private String status;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
