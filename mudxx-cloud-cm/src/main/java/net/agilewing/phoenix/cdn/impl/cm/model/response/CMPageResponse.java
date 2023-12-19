package net.agilewing.phoenix.cdn.impl.cm.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 16:05
 */
@ApiModel("分页请求响应")
public class CMPageResponse<T> extends CMResponse {
    private static final long serialVersionUID = -5913974713141415488L;

    @ApiModelProperty(value = "总条数")
    private Integer total;

    @ApiModelProperty(value = "页数")
    private Integer page;

    @ApiModelProperty(value = "本页页数")
    @JSONField(name = "page_size")
    private Integer pageSize;

    @ApiModelProperty(value = "返回结果数组")
    private List<T> result;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
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

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}

