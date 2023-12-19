package com.mudxx.cloud.oci.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author laiw
 * @date 2023/11/7 09:22
 */
@ApiModel(value = "存储对象信息", description = "模型")
public class OCIStorageObjectModel extends OCIStorageBaseModel {
    private static final long serialVersionUID = 7021404625266529106L;

    @ApiModelProperty(value = "存储桶名称")
    private String bucketName;

    @ApiModelProperty(value = "存储对象名称")
    private String objectName;

    public OCIStorageObjectModel() {
    }

    private OCIStorageObjectModel(Builder builder) {
        setCompartmentId(builder.compartmentId);
        setNamespaceName(builder.namespaceName);
        setBucketName(builder.bucketName);
        setObjectName(builder.objectName);
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public static final class Builder {
        private String compartmentId;
        private String namespaceName;
        private String bucketName;
        private String objectName;

        public Builder() {
        }

        public Builder compartmentId(String val) {
            compartmentId = val;
            return this;
        }

        public Builder namespaceName(String val) {
            namespaceName = val;
            return this;
        }

        public Builder bucketName(String val) {
            bucketName = val;
            return this;
        }

        public Builder objectName(String val) {
            objectName = val;
            return this;
        }

        public OCIStorageObjectModel build() {
            return new OCIStorageObjectModel(this);
        }
    }
}
