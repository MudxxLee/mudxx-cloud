package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-压缩功能")
public class CMCdnGzip implements Serializable {
    private static final long serialVersionUID = -4329105877140966430L;

    @ApiModelProperty(value = "压缩文件大小")
    @JSONField(name = "min_length")
    private String minLength;

    @ApiModelProperty(value = "压缩文件类型，多个以逗号隔开", required = true)
    @JSONField(name = "file_type")
    private String fileType;

    @ApiModelProperty(value = "压缩类型", notes = "取值：0（gzip），1（brotli），不传值为0")
    private Integer type;

    public String getMinLength() {
        return minLength;
    }

    public void setMinLength(String minLength) {
        this.minLength = minLength;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
