package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-https配置基础信息")
public class CMCdnHttpsBasicConf implements Serializable {
    private static final long serialVersionUID = -5943655165146046171L;

    @ApiModelProperty(value = "是否拉取跳转后文件", notes = "0（否）；1（是）")
    @JSONField(name = "follow_302")
    private Integer follow302;

    @ApiModelProperty(value = "是否开启http2", notes = "取值：0（不开启）；1（开启）；默认0，该字段只有在证书开启状态下才会有效")
    @JSONField(name = "use_http2")
    private Integer useHttp2;

    public Integer getFollow302() {
        return follow302;
    }

    public void setFollow302(Integer follow302) {
        this.follow302 = follow302;
    }

    public Integer getUseHttp2() {
        return useHttp2;
    }

    public void setUseHttp2(Integer useHttp2) {
        this.useHttp2 = useHttp2;
    }
}
