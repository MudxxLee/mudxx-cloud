package com.mudxx.cloud.akamai.model.request;

import com.mudxx.cloud.akamai.model.enums.AkamaiCdnPurgeTypeEnum;

import java.io.Serializable;
import java.util.List;

/**
 * 请求参数-创建快速清除
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnPurgeCreateRequest<T> implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;
    /**
     * 清除类型枚举
     */
    private AkamaiCdnPurgeTypeEnum typeEnum;
    /**
     * 列出要清除的对象
     */
    private List<T> values;

    /*--------------------------------------------------------------可选参数--------------------------------------------------------------*/


    public AkamaiCdnPurgeCreateRequest() {
    }

    private AkamaiCdnPurgeCreateRequest(Builder<T> builder) {
        setTypeEnum(builder.typeEnum);
        setValues(builder.values);
    }

    public AkamaiCdnPurgeTypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(AkamaiCdnPurgeTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

    public static final class Builder<T> {
        private AkamaiCdnPurgeTypeEnum typeEnum;
        private List<T> values;

        public Builder() {
        }

        public Builder<T> typeEnum(AkamaiCdnPurgeTypeEnum val) {
            typeEnum = val;
            return this;
        }

        public Builder<T> values(List<T> val) {
            values = val;
            return this;
        }

        public AkamaiCdnPurgeCreateRequest<T> build() {
            return new AkamaiCdnPurgeCreateRequest<>(this);
        }
    }
}
