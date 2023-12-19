package com.mudxx.cloud.akamai.model.response;

import com.mudxx.cloud.akamai.model.entity.AkamaiCdnProperties;
import com.mudxx.cloud.akamai.model.entity.AkamaiItemsModel;

import java.io.Serializable;

/**
 * 请求响应-获取属性
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnPropertiesGetResponse implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;
    /**
     * 属性的集合
     */
    private AkamaiItemsModel<AkamaiCdnProperties> properties;

    public AkamaiItemsModel<AkamaiCdnProperties> getProperties() {
        return properties;
    }

    public void setProperties(AkamaiItemsModel<AkamaiCdnProperties> properties) {
        this.properties = properties;
    }
}
