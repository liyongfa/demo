package reflect;

/**
 * @Auther: lyf
 * @Date: 2019-08-08 17:49
 * @Description:
 */
public class User {

    static {
        System.out.println("User被加载进来了!");
    }

    static String message = "加载User类";

    private String name;

    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
