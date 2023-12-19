package com.mudxx.cloud.biz.common.api;

import org.springframework.http.HttpMethod;

import java.io.Serializable;
import java.util.Map;

/**
 * @author laiw
 * @date 2023/10/31 17:09
 */
public class ApiRequester implements Serializable {
    private static final long serialVersionUID = 614514371960177123L;

    private HttpMethod httpMethod;
    private String url;
    private Map<String, String> headers;
    private String queryString;
    private String body;

    public ApiRequester() {
    }

    private ApiRequester(Builder builder) {
        setHttpMethod(builder.httpMethod);
        setUrl(builder.url);
        setHeaders(builder.headers);
        setQueryString(builder.queryString);
        setBody(builder.body);
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static final class Builder {
        private HttpMethod httpMethod;
        private String url;
        private Map<String, String> headers;
        private String queryString;
        private String body;

        public Builder() {
        }

        public Builder httpMethod(HttpMethod val) {
            httpMethod = val;
            return this;
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public Builder headers(Map<String, String> val) {
            headers = val;
            return this;
        }

        public Builder queryString(String val) {
            queryString = val;
            return this;
        }

        public Builder body(String val) {
            body = val;
            return this;
        }

        public ApiRequester build() {
            return new ApiRequester(this);
        }
    }
}
