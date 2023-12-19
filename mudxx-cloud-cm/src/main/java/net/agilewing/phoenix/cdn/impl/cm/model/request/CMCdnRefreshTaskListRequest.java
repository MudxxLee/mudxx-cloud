package net.agilewing.phoenix.cdn.impl.cm.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求参数-查询刷新任务")
public class CMCdnRefreshTaskListRequest implements Serializable {
    private static final long serialVersionUID = -3538354618111188162L;

    @ApiModelProperty(value = "查询方式", notes = "0（按照时间查询）；1（按照 submit_id 查询）；2（按照 task_id 查询）。默认为 0")
    private Integer type;

    @ApiModelProperty(value = "起始时间", notes = "时间戳(秒)，type=0 时，必填")
    @JSONField(name = "start_time")
    private Integer startTime;

    @ApiModelProperty(value = "结束时间", notes = "时间戳(秒)，type=0 时，必填")
    @JSONField(name = "end_time")
    private Integer endTime;

    @ApiModelProperty(value = "提交id", notes = "type=1 时，必填")
    @JSONField(name = "submit_id")
    private String submitId;

    @ApiModelProperty(value = "任务id", notes = "type=2 时，必填")
    @JSONField(name = "task_id")
    private String taskId;

    @ApiModelProperty(value = "模糊查询关键字")
    private String url;

    @ApiModelProperty(value = "刷新类型", notes = "1(url);2(目录 dir);3(正则匹配 re)")
    @JSONField(name = "task_type")
    private Integer taskType;

    @ApiModelProperty(value = "页数", notes = "默认 1")
    private Integer page;

    @ApiModelProperty(value = "每页条数", notes = "默认 50， 最大 100")
    @JSONField(name = "page_size")
    private Integer pageSize;

    public CMCdnRefreshTaskListRequest() {
    }

    private CMCdnRefreshTaskListRequest(Builder builder) {
        setType(builder.type);
        setStartTime(builder.startTime);
        setEndTime(builder.endTime);
        setSubmitId(builder.submitId);
        setTaskId(builder.taskId);
        setUrl(builder.url);
        setTaskType(builder.taskType);
        setPage(builder.page);
        setPageSize(builder.pageSize);
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public String getSubmitId() {
        return submitId;
    }

    public void setSubmitId(String submitId) {
        this.submitId = submitId;
    }

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

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public static final class Builder {
        private Integer type;
        private Integer startTime;
        private Integer endTime;
        private String submitId;
        private String taskId;
        private String url;
        private Integer taskType;
        private Integer page;
        private Integer pageSize;

        public Builder() {
        }

        public Builder type(Integer val) {
            type = val;
            return this;
        }

        public Builder startTime(Integer val) {
            startTime = val;
            return this;
        }

        public Builder endTime(Integer val) {
            endTime = val;
            return this;
        }

        public Builder submitId(String val) {
            submitId = val;
            return this;
        }

        public Builder taskId(String val) {
            taskId = val;
            return this;
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public Builder taskType(Integer val) {
            taskType = val;
            return this;
        }

        public Builder page(Integer val) {
            page = val;
            return this;
        }

        public Builder pageSize(Integer val) {
            pageSize = val;
            return this;
        }

        public CMCdnRefreshTaskListRequest build() {
            return new CMCdnRefreshTaskListRequest(this);
        }
    }
}
