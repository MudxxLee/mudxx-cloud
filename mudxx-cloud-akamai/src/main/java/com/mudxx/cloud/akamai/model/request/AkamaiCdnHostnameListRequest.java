package com.mudxx.cloud.akamai.model.request;

import java.io.Serializable;

/**
 * 请求参数-列出帐户主机名
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnHostnameListRequest implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;

    /*--------------------------------------------------------------可选参数--------------------------------------------------------------*/
    /**
     * 合约 ID-标识属性所属的协定
     */
    private String contractId;
    /**
     * 组 ID-标识属性分配到的组
     */
    private String groupId;
    /**
     * 合约 ID-标识属性所属的协定
     */
    private String hostname;
    /**
     * 组 ID-标识属性分配到的组
     */
    private String cnameTo;
    /**
     * 属性 ID-属性的唯一标识符
     */
    private String network;

    public AkamaiCdnHostnameListRequest() {
    }

    private AkamaiCdnHostnameListRequest(Builder builder) {
        setContractId(builder.contractId);
        setGroupId(builder.groupId);
        setHostname(builder.hostname);
        setCnameTo(builder.cnameTo);
        setNetwork(builder.network);
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

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getCnameTo() {
        return cnameTo;
    }

    public void setCnameTo(String cnameTo) {
        this.cnameTo = cnameTo;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public static final class Builder {
        private String contractId;
        private String groupId;
        private String hostname;
        private String cnameTo;
        private String network;

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

        public Builder hostname(String val) {
            hostname = val;
            return this;
        }

        public Builder cnameTo(String val) {
            cnameTo = val;
            return this;
        }

        public Builder network(String val) {
            network = val;
            return this;
        }

        public AkamaiCdnHostnameListRequest build() {
            return new AkamaiCdnHostnameListRequest(this);
        }
    }
}
