package com.mudxx.cloud.akamai.model.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * hostname-traffic-by-timeandresponseclass
 *
 * @author laiw
 * @date 2023/12/15 17:20
 */
public class AkamaiCdnReportsDataHtbtrDataDTO implements Serializable {
    private static final long serialVersionUID = 3842738360753895637L;
    @JSONField(alternateNames = "response_class")
    private String responseClass;
    private String edgeHitsPerSecond;

    public String getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(String responseClass) {
        this.responseClass = responseClass;
    }

    public String getEdgeHitsPerSecond() {
        return edgeHitsPerSecond;
    }

    public void setEdgeHitsPerSecond(String edgeHitsPerSecond) {
        this.edgeHitsPerSecond = edgeHitsPerSecond;
    }
}
