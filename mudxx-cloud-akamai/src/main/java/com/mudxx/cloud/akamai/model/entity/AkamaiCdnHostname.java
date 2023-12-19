package com.mudxx.cloud.akamai.model.entity;

import java.io.Serializable;

/**
 * 模型-主机名
 *
 * @author laiw
 * @date 2023/12/14 13:53
 */
public class AkamaiCdnHostname implements Serializable {
    private static final long serialVersionUID = 3788306487263204855L;
    /**
     * 最终用户看到的主机名
     */
    private String cnameFrom;
    /**
     * 合约 ID-标识属性所属的协定
     */
    private String contractId;
    /**
     * 组 ID-标识属性分配到的组
     */
    private String groupId;
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
     * 生产证书类型
     */
    private String productionCertType;
    /**
     * 生产指向属性主机名的边缘主机名
     */
    private String productionCnameTo;
    /**
     * 生产使用的 CNAME 类型
     */
    private String productionCnameType;
    /**
     * 生产的 Edge 主机名ID
     */
    private String productionEdgeHostnameId;
    /**
     * 暂存证书类型
     */
    private String stagingCertType;
    /**
     * 暂存指向属性主机名的边缘主机名
     */
    private String stagingCnameTo;
    /**
     * 暂存使用的 CNAME 类型
     */
    private String stagingCnameType;
    /**
     * 暂存的 Edge 主机名ID
     */
    private String stagingEdgeHostnameId;

    public String getCnameFrom() {
        return cnameFrom;
    }

    public void setCnameFrom(String cnameFrom) {
        this.cnameFrom = cnameFrom;
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

    public String getProductionCertType() {
        return productionCertType;
    }

    public void setProductionCertType(String productionCertType) {
        this.productionCertType = productionCertType;
    }

    public String getProductionCnameTo() {
        return productionCnameTo;
    }

    public void setProductionCnameTo(String productionCnameTo) {
        this.productionCnameTo = productionCnameTo;
    }

    public String getProductionCnameType() {
        return productionCnameType;
    }

    public void setProductionCnameType(String productionCnameType) {
        this.productionCnameType = productionCnameType;
    }

    public String getProductionEdgeHostnameId() {
        return productionEdgeHostnameId;
    }

    public void setProductionEdgeHostnameId(String productionEdgeHostnameId) {
        this.productionEdgeHostnameId = productionEdgeHostnameId;
    }

    public String getStagingCertType() {
        return stagingCertType;
    }

    public void setStagingCertType(String stagingCertType) {
        this.stagingCertType = stagingCertType;
    }

    public String getStagingCnameTo() {
        return stagingCnameTo;
    }

    public void setStagingCnameTo(String stagingCnameTo) {
        this.stagingCnameTo = stagingCnameTo;
    }

    public String getStagingCnameType() {
        return stagingCnameType;
    }

    public void setStagingCnameType(String stagingCnameType) {
        this.stagingCnameType = stagingCnameType;
    }

    public String getStagingEdgeHostnameId() {
        return stagingEdgeHostnameId;
    }

    public void setStagingEdgeHostnameId(String stagingEdgeHostnameId) {
        this.stagingEdgeHostnameId = stagingEdgeHostnameId;
    }
}
