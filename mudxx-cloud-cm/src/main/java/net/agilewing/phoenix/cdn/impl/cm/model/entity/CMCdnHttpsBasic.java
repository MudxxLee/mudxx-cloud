package net.agilewing.phoenix.cdn.impl.cm.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author laiw
 * @date 2023/10/20 13:43
 */
@ApiModel("模型-https基础信息")
public class CMCdnHttpsBasic implements Serializable {
    private static final long serialVersionUID = -4296805810740840304L;

    @ApiModelProperty(value = "强制跳转状态码", notes = "默认:302")
    @JSONField(name = "force_status")
    private String forceStatus;

    @ApiModelProperty(value = "http强制跳转", notes = "取值:“on”:跳转 “off”:不跳转,https_force跟http_force不能同时开启")
    @JSONField(name = "http_force")
    private String httpForce;

    @ApiModelProperty(value = "https强制跳转", notes = "取值:“on”:跳转 “off”:不跳转,https_force跟http_force不能同时开启")
    @JSONField(name = "https_force")
    private String httpsForce;

    @ApiModelProperty(value = "https回源协议", notes = "取值: http:回http协议回源 https:用https协议回源， follow_request:跟随访问协议进行回源")
    @JSONField(name = "origin_protocol")
    private String originProtocol;

    public String getForceStatus() {
        return forceStatus;
    }

    public void setForceStatus(String forceStatus) {
        this.forceStatus = forceStatus;
    }

    public String getHttpForce() {
        return httpForce;
    }

    public void setHttpForce(String httpForce) {
        this.httpForce = httpForce;
    }

    public String getHttpsForce() {
        return httpsForce;
    }

    public void setHttpsForce(String httpsForce) {
        this.httpsForce = httpsForce;
    }

    public String getOriginProtocol() {
        return originProtocol;
    }

    public void setOriginProtocol(String originProtocol) {
        this.originProtocol = originProtocol;
    }
}
