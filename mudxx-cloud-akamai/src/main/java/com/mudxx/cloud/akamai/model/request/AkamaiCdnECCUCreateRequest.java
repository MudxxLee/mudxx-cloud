package com.mudxx.cloud.akamai.model.request;

import java.io.Serializable;
import java.util.List;

/**
 * 请求参数-创建 ECCU 请求
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnECCUCreateRequest implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;
    /**
     * 元数据-包含根据请求参数（如目录路径和文件扩展名）定义刷新请求的标签。仅使用 ASCII 字符。
     */
    private String metadata;
    /**
     * 标识要刷新其内容的属性名称
     */
    private String propertyName;
    /**
     * 指定是否完全匹配
     */
    private Boolean propertyNameExactMatch;
    /**
     * 指定属性类型
     */
    private String propertyType;

    /*--------------------------------------------------------------可选参数--------------------------------------------------------------*/

    /**
     * 笔记
     */
    private String notes;
    /**
     * 请求名称-为刷新请求指定的名称
     */
    private String requestName;
    /**
     * 状态更新电子邮件-刷新请求更改时要通知的电子邮件地址列表
     */
    private List<String> statusUpdateEmails;
    /**
     * 版本-使用它来标记刷新请求中的差异
     */
    private String version;


    public AkamaiCdnECCUCreateRequest() {
    }

    private AkamaiCdnECCUCreateRequest(Builder builder) {
        setMetadata(builder.metadata);
        setPropertyName(builder.propertyName);
        setPropertyNameExactMatch(builder.propertyNameExactMatch);
        setPropertyType(builder.propertyType);
        setNotes(builder.notes);
        setRequestName(builder.requestName);
        setStatusUpdateEmails(builder.statusUpdateEmails);
        setVersion(builder.version);
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public List<String> getStatusUpdateEmails() {
        return statusUpdateEmails;
    }

    public void setStatusUpdateEmails(List<String> statusUpdateEmails) {
        this.statusUpdateEmails = statusUpdateEmails;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public static final class Builder {
        private String metadata;
        private String propertyName;
        private Boolean propertyNameExactMatch;
        private String propertyType;
        private String notes;
        private String requestName;
        private List<String> statusUpdateEmails;
        private String version;

        public Builder() {
        }

        public Builder metadata(String val) {
            metadata = val;
            return this;
        }

        public Builder propertyName(String val) {
            propertyName = val;
            return this;
        }

        public Builder propertyNameExactMatch(Boolean val) {
            propertyNameExactMatch = val;
            return this;
        }

        public Builder propertyType(String val) {
            propertyType = val;
            return this;
        }

        public Builder notes(String val) {
            notes = val;
            return this;
        }

        public Builder requestName(String val) {
            requestName = val;
            return this;
        }

        public Builder statusUpdateEmails(List<String> val) {
            statusUpdateEmails = val;
            return this;
        }

        public Builder version(String val) {
            version = val;
            return this;
        }

        public AkamaiCdnECCUCreateRequest build() {
            return new AkamaiCdnECCUCreateRequest(this);
        }
    }
}
