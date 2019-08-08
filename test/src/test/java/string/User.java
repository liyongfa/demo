package string;

/**
 * @Auther: lyf
 * @Date: 2019-08-05 13:44
 * @Description:
 */
public class User {

    private String name;

    private Integer age;

    private String[] friends;

    private Student student;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }
}
