package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-缓存类型设置信息")
public class CMCdnFiletypeTtl implements Serializable {
    private static final long serialVersionUID = -4757698002289749394L;

    @ApiModelProperty(value = "缓存类型", required = true, notes = "1（不缓存）；2（遵循源站）； 3（强制缓存）；4（custom缓存）。")
    @JSONField(name = "cache_type")
    private Integer cacheType;

    @ApiModelProperty(value = "是否带参数缓存", required = true, notes = "0（不带参数缓存）；1（带参数缓存）")
    @JSONField(name = "cache_with_args")
    private Integer cacheWithArgs;

    @ApiModelProperty(value = "模式", notes = "0（文件后缀）；1（目录）； 2（首页）；3（全部文件）；4:（全路径），默认0")
    private Integer mode;

    @ApiModelProperty(value = "缓存文件类型，多个以逗号隔开", required = true,
            notes = "当模式mode为文件后缀时,缓存文件类型例如：jpg,png,css（以,分割）；" +
                    "当模式mode为目录时，缓存文件类型例如/test,/a/b/c（不能以/结尾）；" +
                    "当模式mode为首页时，缓存文件类型固定为/；" +
                    "当模式mode为全部文件时，缓存文件类型固定为/；" +
                    "当模式mode为全路径时，缓存文件类型例如/index.html,/test/*.jpg")
    @JSONField(name = "file_type")
    private String fileType;

    @ApiModelProperty(value = "优先级", notes = "范围：1-100，默认10")
    private Integer priority;

    @ApiModelProperty(value = "缓存时间，单位秒", required = true, notes = "取值范围：0-31536000")
    private Integer ttl;

    public Integer getCacheType() {
        return cacheType;
    }

    public void setCacheType(Integer cacheType) {
        this.cacheType = cacheType;
    }

    public Integer getCacheWithArgs() {
        return cacheWithArgs;
    }

    public void setCacheWithArgs(Integer cacheWithArgs) {
        this.cacheWithArgs = cacheWithArgs;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getTtl() {
        return ttl;
    }

    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }
}
