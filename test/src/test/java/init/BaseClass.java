package init;

/**
 * @Auther: lyf
 * @Date: 2019-08-08 19:10
 * @Description:
 */
public class BaseClass {

    public BaseClass() {
        System.out.println("----调用BaseClass的空参构造方法-----");
    }

    public BaseClass(Integer id) {
        System.out.println("如果id的值不等于0,那么就说明属性的初始化顺序是优先于构造器的:" + this.id);
        this.id = id;
    }

    private Integer id = 123456;

    static {
        System.out.println("----BaseClass被加载进来了-----");
    }

}
