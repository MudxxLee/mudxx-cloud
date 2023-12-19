package com.mudxx.cloud.akamai.model.request;

import com.mudxx.cloud.akamai.model.entity.AkamaiCdnReportsBodyParams;
import com.mudxx.cloud.akamai.model.entity.AkamaiCdnReportsQueryParams;

import java.io.Serializable;

/**
 * 请求参数-获取报表数据
 *
 * @author laiw
 * @date 2023/12/15 13:56
 */
public class AkamaiCdnReportsDataGetRequest implements Serializable {
    private static final long serialVersionUID = -7550492654742466417L;
    private AkamaiCdnReportsQueryParams queryParams;
    private AkamaiCdnReportsBodyParams bodyParams;

    public AkamaiCdnReportsDataGetRequest() {
    }

    private AkamaiCdnReportsDataGetRequest(Builder builder) {
        setQueryParams(builder.queryParams);
        setBodyParams(builder.bodyParams);
    }

    public AkamaiCdnReportsQueryParams getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(AkamaiCdnReportsQueryParams queryParams) {
        this.queryParams = queryParams;
    }

    public AkamaiCdnReportsBodyParams getBodyParams() {
        return bodyParams;
    }

    public void setBodyParams(AkamaiCdnReportsBodyParams bodyParams) {
        this.bodyParams = bodyParams;
    }

    public static final class Builder {
        private AkamaiCdnReportsQueryParams queryParams;
        private AkamaiCdnReportsBodyParams bodyParams;

        public Builder() {
        }

        public Builder queryParams(AkamaiCdnReportsQueryParams queryParams) {
            this.queryParams = queryParams;
            return this;
        }

        public Builder bodyParams(AkamaiCdnReportsBodyParams bodyParams) {
            this.bodyParams = bodyParams;
            return this;
        }

        public AkamaiCdnReportsDataGetRequest build() {
            return new AkamaiCdnReportsDataGetRequest(this);
        }
    }
}
