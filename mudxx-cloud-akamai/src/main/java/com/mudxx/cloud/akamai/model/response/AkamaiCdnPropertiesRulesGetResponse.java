package com.mudxx.cloud.akamai.model.response;

import java.io.Serializable;
import java.util.List;

/**
 * 请求响应-获取属性的规则树
 *
 * @author laiw
 * @date 2023/10/19 10:50
 */
public class AkamaiCdnPropertiesRulesGetResponse implements Serializable {
    private static final long serialVersionUID = -2517999721936550738L;
    private String accountId;
    private String contractId;
    private String groupId;
    private String propertyId;
    private String propertyName;
    private Integer propertyVersion;
    private String etag;
    private AkamaiCdnPropertiesRulesDTO rules;
    private List<AkamaiCdnPropertiesRulesWarningsDTO> warnings;
    private String ruleFormat;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getPropertyVersion() {
        return propertyVersion;
    }

    public void setPropertyVersion(Integer propertyVersion) {
        this.propertyVersion = propertyVersion;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public AkamaiCdnPropertiesRulesDTO getRules() {
        return rules;
    }

    public void setRules(AkamaiCdnPropertiesRulesDTO rules) {
        this.rules = rules;
    }

    public List<AkamaiCdnPropertiesRulesWarningsDTO> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<AkamaiCdnPropertiesRulesWarningsDTO> warnings) {
        this.warnings = warnings;
    }

    public String getRuleFormat() {
        return ruleFormat;
    }

    public void setRuleFormat(String ruleFormat) {
        this.ruleFormat = ruleFormat;
    }

    public static class AkamaiCdnPropertiesRulesDTO implements Serializable {
        private static final long serialVersionUID = -2517999721936550738L;
        private String name;
        private List<?> children;
        private List<AkamaiCdnPropertiesRulesDTO.AkamaiCdnPropertiesRulesBehaviorsDTO> behaviors;
        private AkamaiCdnPropertiesRulesDTO.AkamaiCdnPropertiesRulesOptionsDTO options;
        private List<?> variables;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<?> getChildren() {
            return children;
        }

        public void setChildren(List<?> children) {
            this.children = children;
        }

        public List<AkamaiCdnPropertiesRulesDTO.AkamaiCdnPropertiesRulesBehaviorsDTO> getBehaviors() {
            return behaviors;
        }

        public void setBehaviors(List<AkamaiCdnPropertiesRulesDTO.AkamaiCdnPropertiesRulesBehaviorsDTO> behaviors) {
            this.behaviors = behaviors;
        }

        public AkamaiCdnPropertiesRulesDTO.AkamaiCdnPropertiesRulesOptionsDTO getOptions() {
            return options;
        }

        public void setOptions(AkamaiCdnPropertiesRulesDTO.AkamaiCdnPropertiesRulesOptionsDTO options) {
            this.options = options;
        }

        public List<?> getVariables() {
            return variables;
        }

        public void setVariables(List<?> variables) {
            this.variables = variables;
        }

        public static class AkamaiCdnPropertiesRulesOptionsDTO implements Serializable {
            private static final long serialVersionUID = -2517999721936550738L;
            private Boolean isSecure;

            public Boolean getSecure() {
                return isSecure;
            }

            public void setSecure(Boolean secure) {
                isSecure = secure;
            }
        }

        public static class AkamaiCdnPropertiesRulesBehaviorsDTO implements Serializable {
            private static final long serialVersionUID = -2517999721936550738L;
            private String name;
            private Object options;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getOptions() {
                return options;
            }

            public void setOptions(Object options) {
                this.options = options;
            }
        }
    }

    public static class AkamaiCdnPropertiesRulesWarningsDTO implements Serializable {
        private static final long serialVersionUID = -2517999721936550738L;
        private String title;
        private String type;
        private String detail;
        private String currentRuleFormat;
        private String suggestedRuleFormat;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getCurrentRuleFormat() {
            return currentRuleFormat;
        }

        public void setCurrentRuleFormat(String currentRuleFormat) {
            this.currentRuleFormat = currentRuleFormat;
        }

        public String getSuggestedRuleFormat() {
            return suggestedRuleFormat;
        }

        public void setSuggestedRuleFormat(String suggestedRuleFormat) {
            this.suggestedRuleFormat = suggestedRuleFormat;
        }
    }
}
