package cdn;

import com.mudxx.common.utils.date.LocalDateTimeUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author laiw
 * @date 2024/1/19 10:15
 */
public class TempTest {
    public static void main(String[] args) {

//        System.out.println(new BigDecimal("0.011").multiply(new BigDecimal("300")));
//        System.out.println(new BigDecimal("0.011").multiply(new BigDecimal("300")).setScale(0, BigDecimal.ROUND_HALF_UP));
//
//        LocalDate date = LocalDate.now(); // 获取当前日期
//        int days = date.lengthOfMonth();
//        System.out.println(days); // 输出当月的天数
//
//        LocalDateTime localDateTime = LocalDateTimeUtils.ofUtc(1575365018L * 1000);
//        System.out.println(LocalDateTimeUtils.formatUtcSssZ(localDateTime));
//        LocalDateTime ofBeijing = LocalDateTimeUtils.ofBeijing(1575365018L * 1000);
//        System.out.println(LocalDateTimeUtils.formatBeijingNormal(ofBeijing));
//        int dayOfMonth = localDateTime.toLocalDate().lengthOfMonth();
//        System.out.println(dayOfMonth); // 输出当月的天数

        System.out.println(Arrays.toString("/*.jpg".split("/")));
        System.out.println(Arrays.toString("/aaa/*.jpg".split("/")));

        String[] strings = "*.jpg".split("/")[0].split("\\*\\.");
        System.out.println(Arrays.toString(strings));

    }

}
