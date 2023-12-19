package com.mudxx.cloud.gcore.model.response;


import com.mudxx.cloud.gcore.model.entity.GcoreCdnStatSeriesMetricsModel;

import java.io.Serializable;
import java.util.Map;

/**
 * 请求响应-CDN资源统计-仅对资源 CNAME 分组
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class GcoreCdnStatSeriesVhostResponse implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;

    /**
     * vhost，仅对资源 CNAME 分组，key=CNAME，value=指标内容
     */
    private Map<String, GcoreCdnStatSeriesMetricsModel> vhost;

    public Map<String, GcoreCdnStatSeriesMetricsModel> getVhost() {
        return vhost;
    }

    public void setVhost(Map<String, GcoreCdnStatSeriesMetricsModel> vhost) {
        this.vhost = vhost;
    }

}
