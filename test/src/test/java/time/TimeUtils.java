package time;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: lyf
 * @Date: 2019-08-02 11:31
 * @Description: 常用的时间工具类有Calendar, DateTime, LocalDateTime, SimpleDateTimeFormat,Date(日期对象)
 */
public abstract class TimeUtils {

    /**
     * 获取当天00:00:00的秒数
     *
     * @param dateOfSeconds
     * @return
     */
    public static int getDayStart(int dateOfSeconds) {
        DateTime dateTime = new DateTime(Long.valueOf(dateOfSeconds) * 1000);
        return (int) dateTime.withTimeAtStartOfDay().getMillis() / 1000;
    }

    /**
     * 获取当天00:00:00的毫秒数
     *
     * @param dateOfMillis
     * @return
     */
    public static long getDayStart(long dateOfMillis) {
        DateTime dateTime = new DateTime(dateOfMillis);
        return dateTime.withTimeAtStartOfDay().getMillis();
    }

    /**
     * 获取当天23:59:59的秒数
     *
     * @param dateOfSeconds
     * @return
     */
    public static int getDayEnd(int dateOfSeconds) {
        DateTime dateTime = new DateTime(Long.valueOf(dateOfSeconds));
        return (int) dateTime.millisOfDay().withMaximumValue().getMillis() / 1000;
    }

    /**
     * 获取当天23:59:59的毫秒数
     *
     * @param dateOfMills
     * @return
     */
    public static long getDateEnd(long dateOfMills) {
        DateTime dateTime = new DateTime(dateOfMills);
        return dateTime.millisOfDay().withMaximumValue().getMillis();
    }

    /**
     * 将日期按照yyyy-MM-dd格式进行返回
     *
     * @param date
     * @return
     */
    public static String dateToShortString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 将日期按照yyyy-MM-dd HH:mm:ss格式进行返回
     *
     * @param date
     * @return
     */
    public static String dateToLongString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 给当前日前加上多少年
     *
     * @param date
     * @param years
     * @return
     */
    public static Date plusYears(Date date, int years) {
        DateTime dateTime = new DateTime(date);
        dateTime.plusYears(years);
        return dateTime.toDate();
    }

    /**
     * 给日期加上多少个月
     *
     * @param date
     * @param month
     * @return
     */
    public static Date plusMonths(Date date, int month) {
        DateTime dateTime = new DateTime(date);
        dateTime.plusMonths(month);
        return dateTime.toDate();
    }

    /**
     * 给当前日期加上多少天
     *
     * @param date
     * @param days
     * @return
     */
    public static Date plusDays(DateTime date, int days) {
        DateTime dateTime = new DateTime(date);
        dateTime.plusDays(days);
        return dateTime.toDate();
    }
}
