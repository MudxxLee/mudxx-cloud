package net.agilewing.phoenix.cdn.impl.cm.model.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求参数-创建预热任务")
public class CMCdnPreloadTaskAddRequest implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;

    @ApiModelProperty(value = "预热文件列表", required = true, notes = "单次最多 50 条。若域名有做防盗链配置，则相应的预取 url 需同样带有防盗链")
    private List<String> values;

    /*--------------------------------------------------------------可选参数--------------------------------------------------------------*/

    public CMCdnPreloadTaskAddRequest() {
    }

    private CMCdnPreloadTaskAddRequest(Builder builder) {
        setValues(builder.values);
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public static final class Builder {
        private List<String> values;

        public Builder() {
        }

        public Builder values(List<String> val) {
            values = val;
            return this;
        }

        public CMCdnPreloadTaskAddRequest build() {
            return new CMCdnPreloadTaskAddRequest(this);
        }
    }
}
