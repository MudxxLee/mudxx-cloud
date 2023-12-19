package cdn;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import net.agilewing.phoenix.common.model.DateUtils;
import net.agilewing.phoenix.common.model.RsaTool;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author laiw
 * @date 2023/12/6 10:40
 */
public class TestRsa {

    private static final String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALL5b5A+ykwkxksXTbTXn10UDxKQZD1Jr7PfGEA6LF10BwDuhrAMuymXTOqFTyLlhAzSiQN7kdwZIOqbiCeC+KXTDY7Po0uirQkOv9YjkEhNeMOr9dA/OS+7l73jIqI2oklf5uQIeULitGu3AatUv+xycOCCf2rx4CPQPv6tiBADAgMBAAECgYB5GIri54lLYeqFblwWi3p5qRPVtLsOOOhYZQ/sjS/tf48pkzqwrbyJlKTnXZHBA9iIMH+iSp7TdHEwLFJAob6ImGE5Z3PRLCifsk5lQ8RVDBVPD/Jd5EsC2mTAW5loEQEiLyZAg7Pm6qwWK7YsWoyOeueC+ESLLzJA/r1gBZO+cQJBAPUyxBaMzmlRXHmd62z10Ke35I60SyC6+t9/mKvpRpHAEe8G/TFJZXvVOfyrDDp/6xCRuDEjMT919UwA43FsaukCQQC629OXq+JCtL/UqnAJwbzTNxIbdrn96OTaS51b+jrvyKD2H2/+hGjSHUen09vQm56qAfKHx/HJqSv3AWWjyLgLAkAFZwzzAj86CtTiyRv61p+2UlLy4f4Vxojoi8MtZoJri7PZdGn3wApAZD5W1t36G/9t6ggI7SGUqGCzQAHC6gShAkA3KvHEpN2vXhgI3K0pZEawgWDaNOpiuaDfhlWWM0G1S6GiKNPy6/ralgRy20zZwShN/zcwuWp8ZHLzgTkV6wvTAkEAqNrGnldxFPzmrdug7/xQGLbFGvjiHXtWJB69AmHbXKlzKYVKDfnj7R8ip1WXiMjRXKMe8bwbAoL3eMnpt8phjA==";

    private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCy+W+QPspMJMZLF020159dFA8SkGQ9Sa+z3xhAOixddAcA7oawDLspl0zqhU8i5YQM0okDe5HcGSDqm4gngvil0w2Oz6NLoq0JDr/WI5BITXjDq/XQPzkvu5e94yKiNqJJX+bkCHlC4rRrtwGrVL/scnDggn9q8eAj0D7+rYgQAwIDAQAB";

    public static void main(String[] args) {

//        String key = RsaTool.encryptByPublicKey("8117$e727634660c304e13063db4270b19ac6bd0a65c774e7428e6cb6edcf1aca2760b63916fc7f841b151e5bd24a073e6494ac91beb1683ddcaf8d081310b13ea6fa", publicKey);
//        System.out.println(key);
//        System.out.println(key.length());
//        System.out.println(RsaTool.decryptByPrivateKey(key, privateKey));

        Date date = DateUtils.addDay(new Date(), -90);
        System.out.println(DateUtils.format(date, DateUtils.DATE_PATTERN.YYYY_MM_DD_HH_MM_SS));

        Date start = DateUtils.getDayStart(date);
        System.out.println(DateUtils.format(start, DateUtils.DATE_PATTERN.YYYY_MM_DD_HH_MM_SS));

        LocalDateTime localDateTime = ofUTC(start.getTime());
        System.out.println(localDateTime.toString());

        System.out.println(start.getTime() / 1000);
        System.out.println(localDateTime.atZone(ZoneId.of("UTC")).toInstant().getEpochSecond());
        System.out.println(start.getTime());
        System.out.println(localDateTime.atZone(ZoneId.of("UTC")).toInstant().toEpochMilli());

        System.out.println(localTimeToISO8601(localDateTime));


    }


    /**
     * yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
     * yyyy-MM-dd'T'HH:mm:ss.SSS
     * yyyy-MM-dd'T'HH:mm:ss
     * @param dateTime
     * @return
     */
    public static String localTimeToISO8601(LocalDateTime dateTime){
        TimeZone utc = TimeZone.getTimeZone("UTC");
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        dft.setTimeZone(utc);
        return dft.format(Date.from(dateTime.atZone(ZoneId.of("UTC")).toInstant()));
    }

    public static LocalDateTime ofUTC(long epochMilli) {
        return ofUTC(Instant.ofEpochMilli(epochMilli));
    }

    public static LocalDateTime ofUTC(Instant instant) {
        return of(instant, ZoneId.of("UTC"));
    }

    public static LocalDateTime of(Instant instant, ZoneId zoneId) {
        return null == instant ? null : LocalDateTime.ofInstant(instant, ObjectUtil.defaultIfNull(zoneId, ZoneId::systemDefault));
    }

}
