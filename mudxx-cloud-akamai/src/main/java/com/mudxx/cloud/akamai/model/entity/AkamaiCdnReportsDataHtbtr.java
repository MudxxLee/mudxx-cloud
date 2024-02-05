package com.mudxx.cloud.akamai.model.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * hostname-traffic-by-timeandresponseclass
 *
 * @author laiw
 * @date 2023/12/15 17:20
 */
public class AkamaiCdnReportsDataHtbtr implements Serializable {
    private static final long serialVersionUID = 3842738360753895637L;
    @JSONField(alternateNames = "startdatetime")
    private String startDateTime;
    private List<AkamaiCdnReportsDataHtbtrDataDTO> data;

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public List<AkamaiCdnReportsDataHtbtrDataDTO> getData() {
        return data;
    }

    public void setData(List<AkamaiCdnReportsDataHtbtrDataDTO> data) {
        this.data = data;
    }
}
