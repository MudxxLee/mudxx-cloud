package com.mudxx.cloud.akamai.model.response;

import com.mudxx.cloud.akamai.model.entity.AkamaiCdnECCUModel;

/**
 * 请求响应-获取 ECCU 请求
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnECCUGetResponse extends AkamaiCdnECCUModel {
    private static final long serialVersionUID = 25712466066632923L;
    /**
     * 请求状态的更多详细信息
     */
    private String extendedStatusMessage;

    public String getExtendedStatusMessage() {
        return extendedStatusMessage;
    }

    public void setExtendedStatusMessage(String extendedStatusMessage) {
        this.extendedStatusMessage = extendedStatusMessage;
    }
}
