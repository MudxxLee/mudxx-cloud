package com.mudxx.cloud.akamai.model.entity;

import java.io.Serializable;

/**
 * 模型-报表-字段
 *
 * @author laiw
 * @date 2023/12/15 14:31
 */
public class AkamaiCdnReportsColumns implements Serializable {
    private static final long serialVersionUID = -8950643213237041353L;
    private String name;
    private String label;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
