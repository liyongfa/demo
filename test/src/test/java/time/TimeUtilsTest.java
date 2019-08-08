package time;

import java.util.Date;

/**
 * @Auther: lyf
 * @Date: 2019-08-02 11:31
 * @Description:
 */
public class TimeUtilsTest {

    public static void main(String[] args) {
        //测试效果
        System.out.println(TimeUtils.dateToShortString(new Date()));
        System.out.println(TimeUtils.dateToLongString(new Date()));
        System.out.println(TimeUtils.dateToLongString(new Date(TimeUtils.getDayStart(new Date().getTime()))));
        System.out.println(TimeUtils.dateToLongString(new Date(TimeUtils.getDateEnd(new Date().getTime()))));
    }

}
