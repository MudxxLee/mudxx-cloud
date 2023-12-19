package com.mudxx.cloud.akamai.model.request;

import java.io.Serializable;

/**
 * 请求参数-获取属性
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnPropertiesGetRequest implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;
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

    /*--------------------------------------------------------------可选参数--------------------------------------------------------------*/


    public AkamaiCdnPropertiesGetRequest() {
    }

    private AkamaiCdnPropertiesGetRequest(Builder builder) {
        setContractId(builder.contractId);
        setGroupId(builder.groupId);
        setPropertyId(builder.propertyId);
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

    public static final class Builder {
        private String contractId;
        private String groupId;
        private String propertyId;

        public Builder() {
        }

        public Builder contractId(String val) {
            contractId = val;
            return this;
        }

        public Builder groupId(String val) {
            groupId = val;
            return this;
        }

        public Builder propertyId(String val) {
            propertyId = val;
            return this;
        }

        public AkamaiCdnPropertiesGetRequest build() {
            return new AkamaiCdnPropertiesGetRequest(this);
        }
    }
}
