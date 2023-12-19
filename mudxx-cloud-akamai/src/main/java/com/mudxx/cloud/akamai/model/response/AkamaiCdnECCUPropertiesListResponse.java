package com.mudxx.cloud.akamai.model.response;

import com.mudxx.cloud.akamai.model.entity.AkamaiCdnECCUProperties;

import java.io.Serializable;
import java.util.List;

/**
 * 请求响应-列出 ECCU 请求的数字属性
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnECCUPropertiesListResponse implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;
    /**
     * 属性的集合
     */
    private List<AkamaiCdnECCUProperties> properties;

    public List<AkamaiCdnECCUProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<AkamaiCdnECCUProperties> properties) {
        this.properties = properties;
    }
}
