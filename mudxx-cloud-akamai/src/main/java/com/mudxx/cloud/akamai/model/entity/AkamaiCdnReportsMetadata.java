package com.mudxx.cloud.akamai.model.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 模型-报表-元数据
 *
 * @author laiw
 * @date 2023/12/15 14:31
 */
public class AkamaiCdnReportsMetadata implements Serializable {
    private static final long serialVersionUID = -8950643213237041353L;
    private String name;
    private String version;
    private String outputType;
    private List<String> groupBy;
    private String interval;
    private String start;
    private String end;
    private Object availableDataEnds;
    private Object suggestedRetryTime;
    private Integer rowCount;
    private List<AkamaiCdnReportsFilters> filters;
    private List<AkamaiCdnReportsColumns> columns;
    private String objectType;
    private List<String> objectIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOutputType() {
        return outputType;
    }

    public void setOutputType(String outputType) {
        this.outputType = outputType;
    }

    public List<String> getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(List<String> groupBy) {
        this.groupBy = groupBy;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Object getAvailableDataEnds() {
        return availableDataEnds;
    }

    public void setAvailableDataEnds(Object availableDataEnds) {
        this.availableDataEnds = availableDataEnds;
    }

    public Object getSuggestedRetryTime() {
        return suggestedRetryTime;
    }

    public void setSuggestedRetryTime(Object suggestedRetryTime) {
        this.suggestedRetryTime = suggestedRetryTime;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public List<AkamaiCdnReportsFilters> getFilters() {
        return filters;
    }

    public void setFilters(List<AkamaiCdnReportsFilters> filters) {
        this.filters = filters;
    }

    public List<AkamaiCdnReportsColumns> getColumns() {
        return columns;
    }

    public void setColumns(List<AkamaiCdnReportsColumns> columns) {
        this.columns = columns;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public List<String> getObjectIds() {
        return objectIds;
    }

    public void setObjectIds(List<String> objectIds) {
        this.objectIds = objectIds;
    }
}
