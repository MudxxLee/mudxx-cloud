package com.mudxx.cloud.akamai.model.entity;

import java.io.Serializable;

/**
 * 模型-ECCU-数字属性
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnECCUProperties implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;
    /**
     * 标识要刷新其内容的数字属性
     */
    private String propertyName;
    /**
     * 指定是与 的完整字符串完全匹配
     */
    private Boolean propertyNameExactMatch;
    /**
     * 指定数字属性的类型
     */
    private String propertyType;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Boolean getPropertyNameExactMatch() {
        return propertyNameExactMatch;
    }

    public void setPropertyNameExactMatch(Boolean propertyNameExactMatch) {
        this.propertyNameExactMatch = propertyNameExactMatch;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }
}
