package com.mudxx.cloud.akamai.services.auth;

import com.mudxx.cloud.akamai.model.entity.AkamaiCredential;
import com.mudxx.cloud.akamai.model.entity.AkamaiRequester;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author laiw
 * @date 2023/12/11 10:21
 */
public class AkamaiAuthProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(AkamaiAuthProvider.class);
    private static final Pattern PATTERN_SPACES = Pattern.compile("\\s+");
    private static final String ALGORITHM_NAME = "EG1-HMAC-SHA256";
    private static final String ALGORITHM_DIGEST = "SHA-256";
    private static final String ALGORITHM_SIGNING = "HmacSHA256";

    private static final String AUTH_CLIENT_TOKEN_NAME = "client_token";
    private static final String AUTH_ACCESS_TOKEN_NAME = "access_token";
    private static final String AUTH_TIMESTAMP_NAME = "timestamp";
    private static final String AUTH_NONCE_NAME = "nonce";
    private static final String AUTH_SIGNATURE_NAME = "signature";

    public AkamaiAuthProvider() {
    }

    /**
     * 构建-Authorization
     */
    public static String buildAuthorization(AkamaiRequester requester, AkamaiCredential credential) {
        return buildAuthorization(requester, credential, System.currentTimeMillis(), generateNonce());
    }

    /**
     * 构建-Authorization
     * Authorization:EG1-HMAC-SHA256 client_token=xxx;access_token=xxx;timestamp=xxx;nonce=xxx;signature=xxx
     * 签名算法名字对象。这表明该算法包括 EdgeGrid V1、哈希消息身份验证代码、SHA–256。例如：EG1-HMAC-SHA256
     * client_token：客户端令牌。from 文件的值。client_token.edgerc
     * access_token：访问令牌。from 文件的值。access_token.edgerc
     * timestamp：时间戳。对请求进行签名时的 UTC 时间。时间戳采用以下格式：yyyyMMddTHH:mm:ss+0000
     * nonce：随机数。必须为请求分配一个随机数或使用一次的号码。这是一个随机字符串，用于检测重播的请求消息。
     * signature：签名。签名是要使用签名密钥签名的数据的 SHA–256 HMAC 的 base64 编码。签名密钥计算为时间戳字符串的 SHA–256 HMAC 的 base64 编码，其中 作为密钥。client secret
     */
    public static String buildAuthorization(AkamaiRequester requester, AkamaiCredential credential, long timestamp, String nonce) {
        String timeStamp = formatTimeStamp(timestamp);
        String authData = getAuthData(credential, timeStamp, nonce);
        String signature = getSignature(requester, credential, timeStamp, authData);
        LOGGER.debug("Signature: {}", signature);
        return getAuthorizationHeaderValue(authData, signature);
    }

    public static String generateNonce() {
        return UUID.randomUUID().toString();
    }

    public static String formatTimeStamp(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ssZ");
        Date date = new Date(time);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        return format.format(date);
    }

    private static String getAuthorizationHeaderValue(String authData, String signature) {
        return authData + AUTH_SIGNATURE_NAME + '=' + signature;
    }

    private static String getAuthData(AkamaiCredential credential, String timeStamp, String nonce) {
        return ALGORITHM_NAME +
                ' ' +
                AUTH_CLIENT_TOKEN_NAME +
                '=' +
                credential.getClientToken() +
                ';' +
                AUTH_ACCESS_TOKEN_NAME +
                '=' +
                credential.getAccessToken() +
                ';' +
                AUTH_TIMESTAMP_NAME +
                '=' +
                timeStamp +
                ';' +
                AUTH_NONCE_NAME +
                '=' +
                nonce +
                ';';
    }

    private static String getSignature(AkamaiRequester requester, AkamaiCredential credential, String timeStamp, String authData) {
        String signingKey = getSigningKey(timeStamp, credential.getClientSecret());
        String canonicalizedRequest = getCanonicalizedRequest(requester, credential);
        LOGGER.trace("Canonicalized request: {}", canonicalizedRequest);
        String dataToSign = getDataToSign(canonicalizedRequest, authData);
        LOGGER.trace("Data to sign: {}", dataToSign);
        return signAndEncode(dataToSign, signingKey);
    }

    private static String getSigningKey(String timeStamp, String clientSecret) {
        byte[] signingKeyBytes = sign(timeStamp, clientSecret);
        return Base64.getEncoder().encodeToString(signingKeyBytes);
    }

    private static String signAndEncode(String stringToSign, String signingKey) {
        byte[] signatureBytes = sign(stringToSign, signingKey);
        return Base64.getEncoder().encodeToString(signatureBytes);
    }

    private static byte[] sign(String s, String clientSecret) {
        return sign(s, clientSecret.getBytes(StandardCharsets.UTF_8));
    }

    private static byte[] sign(String s, byte[] key) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key, ALGORITHM_SIGNING);
            Mac mac = Mac.getInstance(ALGORITHM_SIGNING);
            mac.init(signingKey);
            byte[] valueBytes = s.getBytes(StandardCharsets.UTF_8);
            return mac.doFinal(valueBytes);
        } catch (NoSuchAlgorithmException var5) {
            throw new RuntimeException("Failed to sign: your JDK does not recognize signing algorithm <HmacSHA256>", var5);
        } catch (InvalidKeyException var6) {
            throw new RuntimeException("Failed to sign: invalid key", var6);
        }
    }

    private static String getCanonicalizedRequest(AkamaiRequester requester, AkamaiCredential credential) {
        StringBuilder sb = new StringBuilder();
        sb.append(requester.getMethod().toUpperCase());
        sb.append('\t');
        String scheme = "https";
        sb.append(scheme);
        sb.append('\t');
        String host = credential.getHost();
        sb.append(host.toLowerCase());
        sb.append('\t');
        String relativePath = getRelativePathWithQuery(requester.getUri());
        String relativeUrl = canonicalizeUri(relativePath);
        sb.append(relativeUrl);
        sb.append('\t');
        String canonicalizedHeaders = canonicalizeHeaders(requester.getHeaders(), credential);
        sb.append(canonicalizedHeaders);
        sb.append('\t');
        sb.append(getContentHash(requester.getMethod(), requester.getBody(), credential.getMaxBodySize()));
        sb.append('\t');
        return sb.toString();
    }

    private static String getRelativePathWithQuery(URI uri) {
        StringBuilder sb = new StringBuilder(uri.getRawPath());
        if (uri.getQuery() != null) {
            sb.append("?").append(uri.getQuery());
        }

        return sb.toString();
    }

    private static String canonicalizeUri(String uri) {
        if (uri != null && !"".equals(uri)) {
            if (uri.charAt(0) != '/') {
                uri = "/" + uri;
            }

            return uri;
        } else {
            return "/";
        }
    }

    private static String canonicalizeHeaders(Map<String, String> requestHeaders, AkamaiCredential credential) {
        if(ObjectUtils.isEmpty(credential.getHeadersToSign())) {
            return "";
        }
        return requestHeaders.entrySet().stream()
                .filter((entry) -> credential.getHeadersToSign().contains(entry.getKey()))
                .filter((entry) -> entry.getValue() != null)
                .filter((entry) -> !"".equals(entry.getValue()))
                .map((entry) -> entry.getKey().toLowerCase() + ":" + canonicalizeHeaderValue(entry.getValue()))
                .collect(Collectors.joining("\t"));
    }

    private static String canonicalizeHeaderValue(String headerValue) {
        headerValue = headerValue.trim();
        if (!"".equals(headerValue)) {
            Matcher matcher = PATTERN_SPACES.matcher(headerValue);
            headerValue = matcher.replaceAll(" ");
        }
        return headerValue;
    }

    private static String getDataToSign(String canonicalizedRequest, String authData) {
        return canonicalizedRequest + authData;
    }

    private static String getContentHash(String requestMethod, byte[] requestBody, int maxBodySize) {
        if (!"POST".equals(requestMethod)) {
            return "";
        } else if (requestBody != null && requestBody.length != 0) {
            int lengthToHash = requestBody.length;
            if (lengthToHash > maxBodySize) {
                LOGGER.info("Content length '{}' exceeds signing length of '{}'. Less than the entire message will be signed.", lengthToHash, maxBodySize);
                lengthToHash = maxBodySize;
            } else if (LOGGER.isTraceEnabled()) {
                LOGGER.trace("Content (Base64): {}", Base64.getEncoder().encodeToString(requestBody));
            }

            byte[] digestBytes = getHash(requestBody, 0, lengthToHash);
            LOGGER.debug("Content hash (Base64): {}", Base64.getEncoder().encodeToString(digestBytes));
            return Base64.getEncoder().encodeToString(digestBytes);
        } else {
            return "";
        }
    }

    private static byte[] getHash(byte[] requestBody, int offset, int len) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_DIGEST);
            md.update(requestBody, offset, len);
            return md.digest();
        } catch (NoSuchAlgorithmException var5) {
            throw new RuntimeException("Failed to get request hash: your JDK does not recognize algorithm <SHA-256>", var5);
        }
    }
}
