package com.mudxx.cloud.akamai.model.entity;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * 模型-请求内容
 *
 * @author laiw
 * @date 2023/12/11 10:29
 */
public class AkamaiRequester implements Serializable {
    private static final long serialVersionUID = 3200546902803099056L;
    private URI uri;
    private String method;
    private Map<String, String> headers;
    private byte[] body;

    public AkamaiRequester() {
    }

    private AkamaiRequester(Builder builder) {
        setUri(builder.uri);
        setMethod(builder.method);
        setHeaders(builder.headers);
        setBody(builder.body);
    }


    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public byte[] getBody() {
        return body;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public static final class Builder {
        private URI uri;
        private String method;
        private Map<String, String> headers;
        private byte[] body;

        public Builder() {
        }

        public Builder uri(URI val) {
            uri = val;
            return this;
        }

        public Builder uri(String val) {
            if (StringUtils.isBlank(val)) {
                throw new IllegalArgumentException("uri cannot be empty");
            }
            try {
                URI u = URI.create(val);
                this.uri = new URI(null, null, u.getPath(), u.getRawQuery(), null);
                return this;
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException("Error setting URI", e);
            }
        }

        public Builder method(String val) {
            method = val;
            return this;
        }

        public Builder headers(Map<String, String> val) {
            headers = val;
            return this;
        }

        public Builder body(byte[] val) {
            body = val;
            return this;
        }

        public AkamaiRequester build() {
            return new AkamaiRequester(this);
        }
    }
}
