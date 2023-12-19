package com.mudxx.cloud.gcore.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求参数-创建预热任务")
public class GcoreCdnPrefetchCreateRequest implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;

    @ApiModelProperty(value = "文件路径，但不应指定域名", required = true)
    private List<String> paths;

    /*--------------------------------------------------------------可选参数--------------------------------------------------------------*/

    public GcoreCdnPrefetchCreateRequest() {
    }

    private GcoreCdnPrefetchCreateRequest(GcoreCdnPrefetchCreateRequest.Builder builder) {
        setPaths(builder.paths);
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public static final class Builder {
        private List<String> paths;

        public Builder() {
        }

        public GcoreCdnPrefetchCreateRequest.Builder paths(List<String> val) {
            paths = val;
            return this;
        }

        public GcoreCdnPrefetchCreateRequest build() {
            return new GcoreCdnPrefetchCreateRequest(this);
        }
    }
}
