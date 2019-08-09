package annotation;

/**
 * @Auther: lyf
 * @Date: 2019-08-08 15:35
 * @Description:
 */
public class User extends BaseClass {

    @BeanNotNull("name不能为空")
    private String name;

    @BeanNotNull("age不能为空")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
