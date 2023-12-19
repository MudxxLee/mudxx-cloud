package net.agilewing.phoenix.cdn.impl.cm.services.bulider;

import net.agilewing.phoenix.cdn.impl.cm.common.enums.SwitchEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnCacheModeEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnOriginProtocolEnum;
import net.agilewing.phoenix.cdn.impl.cm.model.enums.CMCdnProductCodeEnum;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author laiw
 * @date 2023/10/30 14:46
 */
public class CMCdnConverter {

    /**
     * 转变成-产品类型
     */
    public static CMCdnProductCodeEnum turnIntoProductCode(Integer configModel) {
        if (configModel == null) {
            return CMCdnProductCodeEnum.CODE_008;
        }
        switch (configModel) {
//            case 0:
//                return CMCdnProductCodeEnum. ?;
//            case 1:
//                return CMCdnProductCodeEnum.CODE_006;
//            case 2:
//                return CMCdnProductCodeEnum. ?;
//            case 3:
//                return CMCdnProductCodeEnum.CODE_001;
//            case 4:
//                return CMCdnProductCodeEnum.CODE_004;
//            case 5:
//                return CMCdnProductCodeEnum. ?;
//            case 6:
//                return CMCdnProductCodeEnum. ?;
//            case 7:
//                return CMCdnProductCodeEnum. ?;
            default:
                return CMCdnProductCodeEnum.CODE_008;
        }
    }

    /**
     * 转变成-ipv6
     */
    public static Integer turnIntoIpv6Enable(Boolean isIpv6Enabled) {
        if (isIpv6Enabled == null) {
            return null;
        }
        return isIpv6Enabled ? SwitchEnum.Open.getCode() : SwitchEnum.Close.getCode();
    }

    /**
     * 转变成-回源协议
     */
    public static CMCdnOriginProtocolEnum turnIntoOriginProtocol(String originProtocolPolicy) {
        if (StringUtils.isBlank(originProtocolPolicy)) {
            return CMCdnOriginProtocolEnum.follow_request;
        }
        switch (originProtocolPolicy) {
            case "http-only":
                return CMCdnOriginProtocolEnum.http;
            case "https-only":
                return CMCdnOriginProtocolEnum.https;
            default:
                return CMCdnOriginProtocolEnum.follow_request;
        }
    }

    /**
     * 转变成-ssl协议类型
     */
    public static String turnIntoSsl(String minimumProtocolVersion) {
        if (StringUtils.isBlank(minimumProtocolVersion)) {
            return minimumProtocolVersion;
        }
        String[] strings = minimumProtocolVersion.split(",");
        Set<String> collect = Arrays.stream(strings).map(e -> {
            if (e.contains("TLSv1.1")) {
                return "TLSv1.1";
            } else if (e.contains("TLSv1.2")) {
                return "TLSv1.2";
            } else if (e.contains("TLSv1.3")) {
                return "TLSv1.3";
            } else {
                return e;
            }
        }).collect(Collectors.toSet());
        return String.join(",", collect);
    }

    /**
     * 转变成-优先级
     */
    public static Integer turnIntoPriority(Integer sortIndex) {
        if (ObjectUtils.isEmpty(sortIndex)) {
            return 10;
        }
        if (sortIndex < 1) {
            return 1;
        } else if (sortIndex > 100) {
            return 100;
        }
        return sortIndex;
    }

    /**
     * 转变成-是否带参数缓存
     */
    public static Integer turnIntoCacheWithArgs(Integer queryString) {
        if (ObjectUtils.isEmpty(queryString)) {
            return 1;
        }
        if (queryString == 0) {
            return 0;
        }
        return 1;
    }

    /**
     * 转变成-缓存文件类型
     * <p>
     * pathPattern             CM-mode              CM-fileType
     * -----------------------------------------------------------
     * *, /, /*                  3                    /
     * /path/, /path/*           1                    /path/
     * /path/a.png, /*.png       4                    /path/a.png /*.png
     * .png, *.png		         0                    png
     */
    public static Map<String, Object> turnIntoModeAndFileType(String pathPattern) {
        if (pathPattern.contains("?")) {
            throw new RuntimeException("invalid path character: " + pathPattern + ", contains ‘?’");
        }
        if (pathPattern.indexOf("*") != pathPattern.lastIndexOf("*")) {
            throw new RuntimeException("invalid path character:" + pathPattern + ", two or more ‘*’");
        }
        String pattern = pathPattern.trim();
        Map<String, Object> map = new HashMap<>();
        if ("".equals(pattern) || "/".equals(pattern) || "*".equals(pattern) || "/*".equals(pathPattern)) {
            map.put("mode", CMCdnCacheModeEnum.CODE_3.getCode());
            map.put("fileType", "/");
            return map;
        }

        if (pattern.endsWith("/")) {
            map.put("mode", CMCdnCacheModeEnum.CODE_1.getCode());
            map.put("fileType", pattern.substring(0, pattern.length() - 1));
            return map;
        }

        if (pattern.endsWith("/*")) {
            map.put("mode", CMCdnCacheModeEnum.CODE_1.getCode());
            map.put("fileType", pattern.substring(0, pattern.length() - 2));
            return map;
        }

        if (pattern.contains("/")) {
            if (pattern.contains(".")) {
                map.put("mode", CMCdnCacheModeEnum.CODE_4.getCode());
                map.put("fileType", pattern);
            } else {
                map.put("mode", CMCdnCacheModeEnum.CODE_1.getCode());
                map.put("fileType", pattern);
            }
            return map;
        }

        // 默认
        map.put("mode", CMCdnCacheModeEnum.CODE_0.getCode());
        map.put("fileType", pattern.replaceAll("\\*", "").replaceAll("\\.", ""));
        return map;
    }

}
