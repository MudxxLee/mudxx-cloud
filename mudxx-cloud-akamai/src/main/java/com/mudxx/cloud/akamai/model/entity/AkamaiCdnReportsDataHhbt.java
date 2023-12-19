package com.mudxx.cloud.akamai.model.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/12/15 17:20
 */
public class AkamaiCdnReportsDataHhbt implements Serializable {
    private static final long serialVersionUID = 3842738360753895637L;
    @JSONField(alternateNames = "startdatetime")
    private String startDateTime;
    private String edgeHitsPerSecond;
    private String maxEdgeHits;

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEdgeHitsPerSecond() {
        return edgeHitsPerSecond;
    }

    public void setEdgeHitsPerSecond(String edgeHitsPerSecond) {
        this.edgeHitsPerSecond = edgeHitsPerSecond;
    }

    public String getMaxEdgeHits() {
        return maxEdgeHits;
    }

    public void setMaxEdgeHits(String maxEdgeHits) {
        this.maxEdgeHits = maxEdgeHits;
    }
}
