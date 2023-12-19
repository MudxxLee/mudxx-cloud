package cdn.domain;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author laiw
 * @date 2023/11/27 10:40
 */
public class TestUtc {
    public static void main(String[] args) {

        DateTime dt = DateUtil.date();
        System.out.println(dt.toString());
        LocalDateTime utc = LocalDateTimeUtil.ofUTC(dt.getTime());
        System.out.println(utc.toString());

        String dateStr = "2020-01-23 12:23:56";
        DateTime date = DateUtil.parse(dateStr);
        System.out.println(date.toString());
        LocalDateTime localDateTime = LocalDateTimeUtil.ofUTC(date.getTime());
        System.out.println(localDateTime.toString());

        LocalDateTime dateTime = DateUtil.parseLocalDateTime(dateStr);
        System.out.println(localTimeToISO8601(dateTime));

    }


    public static String localTimeToISO8601(LocalDateTime dateTime){
        TimeZone utc = TimeZone.getTimeZone("UTC");
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        dft.setTimeZone(utc);
        return dft.format(Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()));
    }

}
