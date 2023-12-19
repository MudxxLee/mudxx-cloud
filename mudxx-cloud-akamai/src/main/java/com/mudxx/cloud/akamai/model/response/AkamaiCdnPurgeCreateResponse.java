package com.mudxx.cloud.akamai.model.response;

import java.io.Serializable;

/**
 * 请求响应-创建快速清除
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnPurgeCreateResponse implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;
    /**
     * 清除 Id-清除请求的唯一标识符
     */
    private String purgeId;
    /**
     * 支持Id-在出现问题时提供 Akamai 技术支持的标识符
     */
    private String supportId;
    /**
     * 估计秒数-清除完成前的估计秒数
     */
    private Long estimatedSeconds;
    /**
     * HTTP 状态代码-指示使内容失效或清除的请求状态的 HTTP 代码
     */
    private Integer httpStatus;
    /**
     * 细节-有关随响应返回的 HTTP 状态代码的详细信息
     */
    private String detail;
    /**
     * 描述者-描述 API 错误响应的 URL
     */
    private String describedBy;
    /**
     * 标题-描述响应类型
     */
    private String title;

    public String getPurgeId() {
        return purgeId;
    }

    public void setPurgeId(String purgeId) {
        this.purgeId = purgeId;
    }

    public String getSupportId() {
        return supportId;
    }

    public void setSupportId(String supportId) {
        this.supportId = supportId;
    }

    public Long getEstimatedSeconds() {
        return estimatedSeconds;
    }

    public void setEstimatedSeconds(Long estimatedSeconds) {
        this.estimatedSeconds = estimatedSeconds;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDescribedBy() {
        return describedBy;
    }

    public void setDescribedBy(String describedBy) {
        this.describedBy = describedBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
