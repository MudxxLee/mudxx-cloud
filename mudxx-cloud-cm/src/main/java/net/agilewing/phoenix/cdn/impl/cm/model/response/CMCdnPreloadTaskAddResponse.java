package net.agilewing.phoenix.cdn.impl.cm.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import net.agilewing.phoenix.cdn.impl.cm.model.entity.CMCdnPreloadTask;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
@ApiModel("请求响应-创建预热任务")
public class CMCdnPreloadTaskAddResponse extends CMResponse {
    private static final long serialVersionUID = -1756411372792559572L;

    @ApiModelProperty(value = "提交id")
    @JSONField(name = "submit_id")
    private String submitId;

    @ApiModelProperty(value = "返回包含任务id的列表")
    private List<CMCdnPreloadTask> result;

    public String getSubmitId() {
        return submitId;
    }

    public void setSubmitId(String submitId) {
        this.submitId = submitId;
    }

    public List<CMCdnPreloadTask> getResult() {
        return result;
    }

    public void setResult(List<CMCdnPreloadTask> result) {
        this.result = result;
    }

}

