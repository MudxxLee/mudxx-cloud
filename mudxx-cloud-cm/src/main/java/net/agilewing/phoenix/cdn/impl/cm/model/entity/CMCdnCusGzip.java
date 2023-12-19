package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-文件压缩信息")
public class CMCdnCusGzip implements Serializable {
    private static final long serialVersionUID = 2525581165906754428L;

    @ApiModelProperty(value = "唯一id", required = true, notes = "跟cus_gzip_condition客户自助的condition的id是一一对应")
    private String id;

    @ApiModelProperty(value = "压缩文件大小", required = true, notes = "格式：(1-1023)B，(1-1023)K，(1-102399)M， (1-99)G，(1-1023)b，(1-1023)k，(1-102399)m ，(1-99)g")
    @JSONField(name = "min_length")
    private String minLength;

    @ApiModelProperty(value = "最大文件大小", notes = "格式：(1-1023)B，(1-1023)K，(1-102399)M，(1-99)G，(1-1023)b，(1-1023)k，(1-102399)m，(1-99)g，不传为null")
    @JSONField(name = "max_length")
    private String maxLength;

    @ApiModelProperty(value = "压缩文件类型，多个以逗号隔开", required = true)
    @JSONField(name = "file_type")
    private String fileType;

    @ApiModelProperty(value = "压缩类型", notes = "取值：0（gzip），1（brotli），不传值为0")
    private Integer type;

    @ApiModelProperty(value = "http_version", notes = "取值：1.1 ，1.0，不传值为null")
    @JSONField(name = "http_version")
    private String httpVersion;

    @ApiModelProperty(value = "gzip_vary", notes = "取值：on（开启），off（关闭）不传值为null")
    private String vary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMinLength() {
        return minLength;
    }

    public void setMinLength(String minLength) {
        this.minLength = minLength;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(String maxLength) {
        this.maxLength = maxLength;
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

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public String getVary() {
        return vary;
    }

    public void setVary(String vary) {
        this.vary = vary;
    }
}
