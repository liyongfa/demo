import java.util.Calendar;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 14:17
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        long time=calendar.getTimeInMillis();
        calendar.set(Calendar.DAY_OF_MONTH,28);;
        long t=calendar.getTimeInMillis()-time;
        System.out.println(t/1000);
    }
}
