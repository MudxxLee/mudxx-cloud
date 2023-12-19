package com.mudxx.cloud.akamai.model.entity;

import java.io.Serializable;

/**
 * 模型-属性
 *
 * @author laiw
 * @date 2023/12/14 13:53
 */
public class AkamaiCdnProperties implements Serializable {
    private static final long serialVersionUID = 3788306487263204855L;
    /**
     * 帐户 ID-标识属性所属的帐户
     */
    private String accountId;
    /**
     * 资产 ID-属性的备用标识符
     */
    private String assetId;
    /**
     * 合约 ID-标识属性所属的协定
     */
    private String contractId;
    /**
     * 组 ID-标识属性分配到的组
     */
    private String groupId;
    /**
     * 产品 ID-分配给属性的产品
     */
    private String productId;
    /**
     * 属性 ID-属性的唯一标识符
     */
    private String propertyId;
    /**
     * 属性的描述性名称
     */
    private String propertyName;
    /**
     * 属性的类型
     */
    private String propertyType;
    /**
     * 最新版本-属性的最新版本
     */
    private Integer latestVersion;
    /**
     * 测试使用的版本(否则为null)
     */
    private Integer stagingVersion;
    /**
     * 生产使用的版本(否则为null)
     */
    private Integer productionVersion;
    /**
     * 描述
     */
    private String note;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Integer getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(Integer latestVersion) {
        this.latestVersion = latestVersion;
    }

    public Integer getStagingVersion() {
        return stagingVersion;
    }

    public void setStagingVersion(Integer stagingVersion) {
        this.stagingVersion = stagingVersion;
    }

    public Integer getProductionVersion() {
        return productionVersion;
    }

    public void setProductionVersion(Integer productionVersion) {
        this.productionVersion = productionVersion;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
