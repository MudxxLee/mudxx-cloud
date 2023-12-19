package com.mudxx.cloud.akamai.model.response;

import com.mudxx.cloud.akamai.model.entity.AkamaiCdnHostname;

import java.io.Serializable;
import java.util.List;

/**
 * 请求响应-列出帐户主机名
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnHostnameListResponse implements Serializable {
    private static final long serialVersionUID = 2874582139295379925L;
    private String accountId;
    private List<String> availableSort;
    private String currentSort;
    private String defaultSort;
    private AkamaiCdnHostnamesDTO hostnames;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<String> getAvailableSort() {
        return availableSort;
    }

    public void setAvailableSort(List<String> availableSort) {
        this.availableSort = availableSort;
    }

    public String getCurrentSort() {
        return currentSort;
    }

    public void setCurrentSort(String currentSort) {
        this.currentSort = currentSort;
    }

    public String getDefaultSort() {
        return defaultSort;
    }

    public void setDefaultSort(String defaultSort) {
        this.defaultSort = defaultSort;
    }

    public AkamaiCdnHostnamesDTO getHostnames() {
        return hostnames;
    }

    public void setHostnames(AkamaiCdnHostnamesDTO hostnames) {
        this.hostnames = hostnames;
    }

    public static class AkamaiCdnHostnamesDTO implements Serializable {
        private static final long serialVersionUID = -3415711818100572307L;
        private Integer currentItemCount;
        private List<AkamaiCdnHostname> items;
        private String nextLink;
        private String previousLink;
        private Integer totalItems;

        public Integer getCurrentItemCount() {
            return currentItemCount;
        }

        public void setCurrentItemCount(Integer currentItemCount) {
            this.currentItemCount = currentItemCount;
        }

        public List<AkamaiCdnHostname> getItems() {
            return items;
        }

        public void setItems(List<AkamaiCdnHostname> items) {
            this.items = items;
        }

        public String getNextLink() {
            return nextLink;
        }

        public void setNextLink(String nextLink) {
            this.nextLink = nextLink;
        }

        public String getPreviousLink() {
            return previousLink;
        }

        public void setPreviousLink(String previousLink) {
            this.previousLink = previousLink;
        }

        public Integer getTotalItems() {
            return totalItems;
        }

        public void setTotalItems(Integer totalItems) {
            this.totalItems = totalItems;
        }
    }

}
