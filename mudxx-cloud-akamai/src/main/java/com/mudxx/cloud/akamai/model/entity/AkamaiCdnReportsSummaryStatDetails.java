package com.mudxx.cloud.akamai.model.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/12/15 17:20
 */
public class AkamaiCdnReportsSummaryStatDetails implements Serializable {
    private static final long serialVersionUID = 3842738360753895637L;
    private String value;
    private Map<String, Object> details;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }
}
