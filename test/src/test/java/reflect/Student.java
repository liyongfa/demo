package reflect;

/**
 * @Auther: lyf
 * @Date: 2019-08-08 18:09
 * @Description:
 */
public class Student {

    static {
        System.out.println("Student类被加载进来了");
    }

    public static final String a = Integer.valueOf(36).toString();

    public static final String b = "没有引起初始化";

    public static final Integer c = new Integer(123); //RandomUtils.nextInt();

    public static String d = "娃哈哈";

    public static int e = 22;
}
