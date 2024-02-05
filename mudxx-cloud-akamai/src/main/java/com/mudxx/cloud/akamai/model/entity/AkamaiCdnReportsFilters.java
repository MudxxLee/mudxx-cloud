package com.mudxx.cloud.akamai.model.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 模型-报表-自定义筛选器
 *
 * @author laiw
 * @date 2023/12/15 13:56
 */
public class AkamaiCdnReportsFilters implements Serializable {
    private static final long serialVersionUID = -7550492654742466417L;
    private List<String> ca;
    @JSONField(name = "delivery_type")
    private List<String> deliveryType;
    @JSONField(name = "hostname_contain")
    private List<String> hostnameContain;
    @JSONField(name = "hostname_end_with")
    private List<String> hostnameEndWith;
    @JSONField(name = "hostname_exact_match")
    private List<String> hostnameExactMatch;
    @JSONField(name = "hostname_match")
    private List<String> hostnameMatch;
    @JSONField(name = "hostname_not_contain")
    private List<String> hostnameNotContain;
    @JSONField(name = "hostname_not_end_with")
    private List<String> hostnameNotEndWith;
    @JSONField(name = "hostname_not_match")
    private List<String> hostnameNotMatch;
    @JSONField(name = "hostname_not_start_with")
    private List<String> hostnameNotStartWith;
    @JSONField(name = "hostname_start_with")
    private List<String> hostnameStartWith;
    @JSONField(name = "http_version")
    private List<String> httpVersion;
    @JSONField(name = "ip_version")
    private List<String> ipVersion;
    @JSONField(name = "response_class")
    private List<String> responseClass;
    @JSONField(name = "response_code")
    private List<String> responseCode;
    @JSONField(name = "response_status")
    private List<String> responseStatus;
    private List<String> traffic;

    public AkamaiCdnReportsFilters() {
    }

    private AkamaiCdnReportsFilters(Builder builder) {
        setCa(builder.ca);
        setDeliveryType(builder.deliveryType);
        setHostnameContain(builder.hostnameContain);
        setHostnameEndWith(builder.hostnameEndWith);
        setHostnameExactMatch(builder.hostnameExactMatch);
        setHostnameMatch(builder.hostnameMatch);
        setHostnameNotContain(builder.hostnameNotContain);
        setHostnameNotEndWith(builder.hostnameNotEndWith);
        setHostnameNotMatch(builder.hostnameNotMatch);
        setHostnameNotStartWith(builder.hostnameNotStartWith);
        setHostnameStartWith(builder.hostnameStartWith);
        setHttpVersion(builder.httpVersion);
        setIpVersion(builder.ipVersion);
        setResponseClass(builder.responseClass);
        setResponseCode(builder.responseCode);
        setResponseStatus(builder.responseStatus);
        setTraffic(builder.traffic);
    }

    public List<String> getCa() {
        return ca;
    }

    public void setCa(List<String> ca) {
        this.ca = ca;
    }

    public List<String> getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(List<String> deliveryType) {
        this.deliveryType = deliveryType;
    }

    public List<String> getHostnameContain() {
        return hostnameContain;
    }

    public void setHostnameContain(List<String> hostnameContain) {
        this.hostnameContain = hostnameContain;
    }

    public List<String> getHostnameEndWith() {
        return hostnameEndWith;
    }

    public void setHostnameEndWith(List<String> hostnameEndWith) {
        this.hostnameEndWith = hostnameEndWith;
    }

    public List<String> getHostnameExactMatch() {
        return hostnameExactMatch;
    }

    public void setHostnameExactMatch(List<String> hostnameExactMatch) {
        this.hostnameExactMatch = hostnameExactMatch;
    }

    public List<String> getHostnameMatch() {
        return hostnameMatch;
    }

    public void setHostnameMatch(List<String> hostnameMatch) {
        this.hostnameMatch = hostnameMatch;
    }

    public List<String> getHostnameNotContain() {
        return hostnameNotContain;
    }

    public void setHostnameNotContain(List<String> hostnameNotContain) {
        this.hostnameNotContain = hostnameNotContain;
    }

    public List<String> getHostnameNotEndWith() {
        return hostnameNotEndWith;
    }

    public void setHostnameNotEndWith(List<String> hostnameNotEndWith) {
        this.hostnameNotEndWith = hostnameNotEndWith;
    }

    public List<String> getHostnameNotMatch() {
        return hostnameNotMatch;
    }

    public void setHostnameNotMatch(List<String> hostnameNotMatch) {
        this.hostnameNotMatch = hostnameNotMatch;
    }

    public List<String> getHostnameNotStartWith() {
        return hostnameNotStartWith;
    }

    public void setHostnameNotStartWith(List<String> hostnameNotStartWith) {
        this.hostnameNotStartWith = hostnameNotStartWith;
    }

    public List<String> getHostnameStartWith() {
        return hostnameStartWith;
    }

    public void setHostnameStartWith(List<String> hostnameStartWith) {
        this.hostnameStartWith = hostnameStartWith;
    }

    public List<String> getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(List<String> httpVersion) {
        this.httpVersion = httpVersion;
    }

    public List<String> getIpVersion() {
        return ipVersion;
    }

    public void setIpVersion(List<String> ipVersion) {
        this.ipVersion = ipVersion;
    }

    public List<String> getResponseClass() {
        return responseClass;
    }

    public void setResponseClass(List<String> responseClass) {
        this.responseClass = responseClass;
    }

    public List<String> getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(List<String> responseCode) {
        this.responseCode = responseCode;
    }

    public List<String> getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(List<String> responseStatus) {
        this.responseStatus = responseStatus;
    }

    public List<String> getTraffic() {
        return traffic;
    }

    public void setTraffic(List<String> traffic) {
        this.traffic = traffic;
    }

    public static final class Builder {
        private List<String> ca;
        private List<String> deliveryType;
        private List<String> hostnameContain;
        private List<String> hostnameEndWith;
        private List<String> hostnameExactMatch;
        private List<String> hostnameMatch;
        private List<String> hostnameNotContain;
        private List<String> hostnameNotEndWith;
        private List<String> hostnameNotMatch;
        private List<String> hostnameNotStartWith;
        private List<String> hostnameStartWith;
        private List<String> httpVersion;
        private List<String> ipVersion;
        private List<String> responseClass;
        private List<String> responseCode;
        private List<String> responseStatus;
        private List<String> traffic;

        public Builder() {
        }

        public Builder ca(List<String> ca) {
            this.ca = ca;
            return this;
        }

        public Builder deliveryType(List<String> deliveryType) {
            this.deliveryType = deliveryType;
            return this;
        }

        public Builder hostnameContain(List<String> hostnameContain) {
            this.hostnameContain = hostnameContain;
            return this;
        }

        public Builder hostnameEndWith(List<String> hostnameEndWith) {
            this.hostnameEndWith = hostnameEndWith;
            return this;
        }

        public Builder hostnameExactMatch(List<String> hostnameExactMatch) {
            this.hostnameExactMatch = hostnameExactMatch;
            return this;
        }

        public Builder hostnameMatch(List<String> hostnameMatch) {
            this.hostnameMatch = hostnameMatch;
            return this;
        }

        public Builder hostnameNotContain(List<String> hostnameNotContain) {
            this.hostnameNotContain = hostnameNotContain;
            return this;
        }

        public Builder hostnameNotEndWith(List<String> hostnameNotEndWith) {
            this.hostnameNotEndWith = hostnameNotEndWith;
            return this;
        }

        public Builder hostnameNotMatch(List<String> hostnameNotMatch) {
            this.hostnameNotMatch = hostnameNotMatch;
            return this;
        }

        public Builder hostnameNotStartWith(List<String> hostnameNotStartWith) {
            this.hostnameNotStartWith = hostnameNotStartWith;
            return this;
        }

        public Builder hostnameStartWith(List<String> hostnameStartWith) {
            this.hostnameStartWith = hostnameStartWith;
            return this;
        }

        public Builder httpVersion(List<String> httpVersion) {
            this.httpVersion = httpVersion;
            return this;
        }

        public Builder ipVersion(List<String> ipVersion) {
            this.ipVersion = ipVersion;
            return this;
        }

        public Builder responseClass(List<String> responseClass) {
            this.responseClass = responseClass;
            return this;
        }

        public Builder responseCode(List<String> responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public Builder responseStatus(List<String> responseStatus) {
            this.responseStatus = responseStatus;
            return this;
        }

        public Builder traffic(List<String> traffic) {
            this.traffic = traffic;
            return this;
        }

        public AkamaiCdnReportsFilters build() {
            return new AkamaiCdnReportsFilters(this);
        }
    }
}
