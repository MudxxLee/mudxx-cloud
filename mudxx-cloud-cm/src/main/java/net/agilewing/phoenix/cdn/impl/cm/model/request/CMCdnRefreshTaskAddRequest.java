package net.agilewing.phoenix.cdn.impl.cm.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求参数-创建刷新任务")
public class CMCdnRefreshTaskAddRequest implements Serializable {
    private static final long serialVersionUID = 2830803314126420825L;

    @ApiModelProperty(value = "刷新类型", required = true, notes = "1(url);2(目录 dir);3(正则匹配 re)")
    @JSONField(name = "task_type")
    private Integer taskType;

    @ApiModelProperty(value = "刷新内容", required = true, notes = "刷新类型为 url 时单次最多 1000 条，类型为 dir 和 re 时单次最多 50 条")
    private List<String> values;

    /*--------------------------------------------------------------可选参数--------------------------------------------------------------*/

    public CMCdnRefreshTaskAddRequest() {
    }

    private CMCdnRefreshTaskAddRequest(Builder builder) {
        setTaskType(builder.taskType);
        setValues(builder.values);
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public static final class Builder {
        private Integer taskType;
        private List<String> values;

        public Builder() {
        }

        public Builder taskType(Integer val) {
            taskType = val;
            return this;
        }

        public Builder values(List<String> val) {
            values = val;
            return this;
        }

        public CMCdnRefreshTaskAddRequest build() {
            return new CMCdnRefreshTaskAddRequest(this);
        }
    }
}
