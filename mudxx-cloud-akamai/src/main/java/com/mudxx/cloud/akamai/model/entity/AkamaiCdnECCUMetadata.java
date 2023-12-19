package com.mudxx.cloud.akamai.model.entity;

import com.mudxx.common.utils.xml.ParseXmlUtils;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 模型-ECCU-元数据
 *
 * @author laiw
 * @date 2023/12/11 10:29
 */
@XmlRootElement(name = "eccu")
public class AkamaiCdnECCUMetadata implements Serializable {
    private static final long serialVersionUID = 3200546902803099056L;

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\"?><eccu><match_recursive-dirs value=\"store\"><match_recursive-dirs value=\"images\"><revalidate>now</revalidate></match_recursive-dirs></match_recursive-dirs></eccu>";
        System.out.println(ParseXmlUtils.xmlData2Map(xml));
    }
}



