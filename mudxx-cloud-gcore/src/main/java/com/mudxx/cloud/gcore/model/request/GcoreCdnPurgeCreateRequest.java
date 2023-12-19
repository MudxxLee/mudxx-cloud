package com.mudxx.cloud.gcore.model.request;

import com.mudxx.cloud.gcore.model.enums.GcoreCdnPurgeTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author laiw
 * @date 2023/10/19 10:50
 */
@ApiModel("请求参数-清除创建")
public class GcoreCdnPurgeCreateRequest implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;

    @ApiModelProperty(value = "类型", required = true)
    private GcoreCdnPurgeTypeEnum typeEnum;

    @ApiModelProperty(value = "内容", required = true)
    private List<String> values;

    /*--------------------------------------------------------------可选参数--------------------------------------------------------------*/

    public GcoreCdnPurgeCreateRequest() {
    }

    private GcoreCdnPurgeCreateRequest(Builder builder) {
        setTypeEnum(builder.typeEnum);
        setValues(builder.values);
    }

    public GcoreCdnPurgeTypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(GcoreCdnPurgeTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public static final class Builder {
        private GcoreCdnPurgeTypeEnum typeEnum;
        private List<String> values;

        public Builder() {
        }

        public Builder typeEnum(GcoreCdnPurgeTypeEnum val) {
            typeEnum = val;
            return this;
        }

        public Builder values(List<String> val) {
            values = val;
            return this;
        }

        public GcoreCdnPurgeCreateRequest build() {
            return new GcoreCdnPurgeCreateRequest(this);
        }
    }
}
