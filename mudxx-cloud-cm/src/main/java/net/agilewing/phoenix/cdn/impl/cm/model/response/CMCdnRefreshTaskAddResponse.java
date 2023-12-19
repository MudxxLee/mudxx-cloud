package net.agilewing.phoenix.cdn.impl.cm.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnRefreshTask;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
@ApiModel("请求响应-创建刷新任务")
public class CMCdnRefreshTaskAddResponse extends CMResponse {
    private static final long serialVersionUID = 5775662116700576582L;

    @ApiModelProperty(value = "提交id")
    @JSONField(name = "submit_id")
    private String submitId;

    @ApiModelProperty(value = "返回包含任务id的列表")
    private List<CMCdnRefreshTask> result;

    public String getSubmitId() {
        return submitId;
    }

    public void setSubmitId(String submitId) {
        this.submitId = submitId;
    }

    public List<CMCdnRefreshTask> getResult() {
        return result;
    }

    public void setResult(List<CMCdnRefreshTask> result) {
        this.result = result;
    }
}

