package com.mudxx.cloud.oci.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/11/7 09:22
 */
@ApiModel(value = "存储基础信息", description = "模型")
public class OCIStorageBaseModel implements Serializable {
    private static final long serialVersionUID = 8767909018775752570L;

    @ApiModelProperty(value = "创建存储桶的分区的ID")
    private String compartmentId;

    @ApiModelProperty(value = "名称空间")
    private String namespaceName;

    public String getCompartmentId() {
        return compartmentId;
    }

    public void setCompartmentId(String compartmentId) {
        this.compartmentId = compartmentId;
    }

    public String getNamespaceName() {
        return namespaceName;
    }

    public void setNamespaceName(String namespaceName) {
        this.namespaceName = namespaceName;
    }
}
