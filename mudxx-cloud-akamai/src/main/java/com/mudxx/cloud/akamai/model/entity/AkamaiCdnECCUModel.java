package com.mudxx.cloud.akamai.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 模型-ECCU
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnECCUModel implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;
    /**
     * 元数据-包含根据请求参数（如目录路径和文件扩展名）定义刷新请求的标签
     */
    private String metadata;
    /**
     * 笔记
     */
    private String notes;
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
    /**
     * 请求日期-提交刷新请求的时间，采用 ISO 8601 格式。
     */
    private String requestDate;
    /**
     * 请求 Id-刷新请求的唯一标识符
     */
    private Long requestId;
    /**
     * 请求名称-为刷新请求指定的名称
     */
    private String requestName;
    /**
     * 提交请求的人员的用户名-邮件
     */
    private String requestor;
    /**
     * 状态
     */
    private String status;
    /**
     * 状态消息
     */
    private String statusMessage;
    /**
     * 状态更新日期-刷新请求上次更改的时间
     */
    private String statusUpdateDate;
    /**
     * 状态更新电子邮件-刷新请求更改时要通知的电子邮件地址列表
     */
    private List<String> statusUpdateEmails;

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getStatusUpdateDate() {
        return statusUpdateDate;
    }

    public void setStatusUpdateDate(String statusUpdateDate) {
        this.statusUpdateDate = statusUpdateDate;
    }

    public List<String> getStatusUpdateEmails() {
        return statusUpdateEmails;
    }

    public void setStatusUpdateEmails(List<String> statusUpdateEmails) {
        this.statusUpdateEmails = statusUpdateEmails;
    }
}
