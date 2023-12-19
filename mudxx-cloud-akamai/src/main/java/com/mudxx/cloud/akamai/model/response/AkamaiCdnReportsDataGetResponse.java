package com.mudxx.cloud.akamai.model.response;

import com.mudxx.cloud.akamai.model.entity.AkamaiCdnReportsMetadata;
import com.mudxx.cloud.akamai.model.entity.AkamaiCdnReportsSummaryStatDetails;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 请求响应-获取报表数据
 *
 * @author laiw
 * @date 2023/12/15 14:31
 */
public class AkamaiCdnReportsDataGetResponse<T> implements Serializable {
    private static final long serialVersionUID = -8950643213237041353L;
    private AkamaiCdnReportsMetadata metadata;
    private List<T> data;
    private Map<String, AkamaiCdnReportsSummaryStatDetails> summaryStatistics;

    public AkamaiCdnReportsMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(AkamaiCdnReportsMetadata metadata) {
        this.metadata = metadata;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Map<String, AkamaiCdnReportsSummaryStatDetails> getSummaryStatistics() {
        return summaryStatistics;
    }

    public void setSummaryStatistics(Map<String, AkamaiCdnReportsSummaryStatDetails> summaryStatistics) {
        this.summaryStatistics = summaryStatistics;
    }
}
