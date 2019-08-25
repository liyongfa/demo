package reflect;

public class User {

    public static String A = "a";

    public static final String B = "b";

    public static final Integer C = new Integer(100);

    protected static int D=56;

    static {
        System.out.println("进行了类型的加载！");
    }
}
