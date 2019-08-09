package init;

/**
 * @Auther: lyf
 * @Date: 2019-08-08 19:13
 * @Description:
 */
public class User extends BaseClass {

    private String name = "往事如烟";

    public User() {
        System.out.println("----user-----name=" + name);
        System.out.println("如果name的值是往事如烟,说明属性的初始化顺序优先构造器");

    }

    static {
        System.out.println("----User被加载进来了-----");
    }
}
