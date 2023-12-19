package com.mudxx.cloud.akamai.model.entity;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * 模型-凭证
 *
 * @author laiw
 * @date 2023/12/11 11:05
 */
public class AkamaiCredential implements Serializable {
    private static final long serialVersionUID = -1129034861959321681L;
    public static final int DEFAULT_MAX_BODY_SIZE_IN_BYTES = 131072;
    private String host;
    private String clientToken;
    private String clientSecret;
    private String accessToken;
    private TreeSet<String> headersToSign;
    private Integer maxBodySize;

    public AkamaiCredential() {
    }

    private AkamaiCredential(Builder builder) {
        setHost(builder.host);
        setClientToken(builder.clientToken);
        setClientSecret(builder.clientSecret);
        setAccessToken(builder.accessToken);
        setHeadersToSign(builder.headersToSign);
        setMaxBodySize(builder.maxBodySize);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public TreeSet<String> getHeadersToSign() {
        return headersToSign;
    }

    public void setHeadersToSign(TreeSet<String> headersToSign) {
        this.headersToSign = headersToSign;
    }

    public Integer getMaxBodySize() {
        return maxBodySize;
    }

    public void setMaxBodySize(Integer maxBodySize) {
        this.maxBodySize = maxBodySize;
    }

    public static final class Builder {
        private String host;
        private String clientToken;
        private String clientSecret;
        private String accessToken;
        private TreeSet<String> headersToSign;
        private Integer maxBodySize;

        public Builder() {
        }

        public Builder host(String val) {
            host = val;
            return this;
        }

        public Builder clientToken(String val) {
            clientToken = val;
            return this;
        }

        public Builder clientSecret(String val) {
            clientSecret = val;
            return this;
        }

        public Builder accessToken(String val) {
            accessToken = val;
            return this;
        }

        public Builder headersToSign(TreeSet<String> val) {
            headersToSign = val;
            return this;
        }

        public Builder maxBodySize(Integer val) {
            maxBodySize = val;
            return this;
        }

        public AkamaiCredential build() {
            return new AkamaiCredential(this);
        }
    }
}
