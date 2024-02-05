package com.mudxx.cloud.akamai.model.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * hostname-bytes-by-time
 *
 * @author laiw
 * @date 2023/12/15 17:20
 */
public class AkamaiCdnReportsDataHbbt implements Serializable {
    private static final long serialVersionUID = 3842738360753895637L;
    @JSONField(alternateNames = "startdatetime")
    private String startDateTime;
    private String edgeBitsPerSecond;
    private String maxEdgeBytes;

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEdgeBitsPerSecond() {
        return edgeBitsPerSecond;
    }

    public void setEdgeBitsPerSecond(String edgeBitsPerSecond) {
        this.edgeBitsPerSecond = edgeBitsPerSecond;
    }

    public String getMaxEdgeBytes() {
        return maxEdgeBytes;
    }

    public void setMaxEdgeBytes(String maxEdgeBytes) {
        this.maxEdgeBytes = maxEdgeBytes;
    }
}
