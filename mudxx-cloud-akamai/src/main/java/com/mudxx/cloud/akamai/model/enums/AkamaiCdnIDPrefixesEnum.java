package com.mudxx.cloud.akamai.model.enums;


import org.apache.commons.lang3.StringUtils;

/**
 * @author laiwen
 */

public enum AkamaiCdnIDPrefixesEnum {
    /**
     * ID 前缀
     */
    AID_("aid_", "assetId 资产-ID 前缀"),
    ACT_("act_", "accountId 账号-ID 前缀"),
    ATV_("atv_", "activationId 激活-ID 前缀"),
    CPC_("cpc_", "cpcodeId CP代码-ID 前缀"),
    CTR_("ctr_", "contractId 合同-ID 前缀"),
    EHN_("ehn_", "edgeHostnameId Edge主机名-ID 前缀"),
    GRP_("grp_", "groupId 组-ID 前缀"),
    MSG_("msg_", "messageId 消息-ID 前缀"),
    PRD_("prd_", "productId 产品-ID 前缀"),
    PRP_("prp_", "propertyId 属性-ID 前缀"),
    INC_("inc_", "includeId 包含-ID 前缀"),

    ;

    private final String code;
    private final String desc;

    AkamaiCdnIDPrefixesEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public String usePrefixes(String id) {
        if (StringUtils.isNotBlank(id) && !id.startsWith(this.code)) {
            return String.join("", this.getCode(), id);
        }
        return id;
    }

}
