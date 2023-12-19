package com.mudxx.cloud.oci.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/8/22 13:47
 */
@ApiModel(value = "身份认证信息", description = "模型")
public class OCIAuthenticationModel implements Serializable {
    private static final long serialVersionUID = 7904960083796288433L;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "用户名称")
    private String userName;

    @ApiModelProperty(value = "租户ID")
    private String tenantId;

    @ApiModelProperty(value = "租户名称")
    private String tenantName;

    @ApiModelProperty(value = "fingerprint")
    private String fingerprint;

    @ApiModelProperty(value = "API秘钥")
    private String privateKey;

    @ApiModelProperty(value = "API秘钥路径")
    private String privateKeyPath;

    public OCIAuthenticationModel() {
    }

    private OCIAuthenticationModel(Builder builder) {
        setUserId(builder.userId);
        setUserName(builder.userName);
        setTenantId(builder.tenantId);
        setTenantName(builder.tenantName);
        setFingerprint(builder.fingerprint);
        setPrivateKey(builder.privateKey);
        setPrivateKeyPath(builder.privateKeyPath);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPrivateKeyPath() {
        return privateKeyPath;
    }

    public void setPrivateKeyPath(String privateKeyPath) {
        this.privateKeyPath = privateKeyPath;
    }

    public static final class Builder {
        private String userId;
        private String userName;
        private String tenantId;
        private String tenantName;
        private String fingerprint;
        private String privateKey;
        private String privateKeyPath;

        public Builder() {
        }

        public Builder userId(String val) {
            userId = val;
            return this;
        }

        public Builder userName(String val) {
            userName = val;
            return this;
        }

        public Builder tenantId(String val) {
            tenantId = val;
            return this;
        }

        public Builder tenantName(String val) {
            tenantName = val;
            return this;
        }

        public Builder fingerprint(String val) {
            fingerprint = val;
            return this;
        }

        public Builder privateKey(String val) {
            privateKey = val;
            return this;
        }

        public Builder privateKeyPath(String val) {
            privateKeyPath = val;
            return this;
        }

        public OCIAuthenticationModel build() {
            return new OCIAuthenticationModel(this);
        }
    }
}
