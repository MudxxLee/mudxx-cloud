package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 11:37
 */
@ApiModel("模型-预热任务信息")
public class CMCdnPreloadTask implements Serializable {

    private static final long serialVersionUID = 5748010119001422853L;
    @ApiModelProperty(value = "任务id")
    @JSONField(name = "task_id")
    private String taskId;

    @ApiModelProperty(value = "刷新的URL")
    private String url;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
