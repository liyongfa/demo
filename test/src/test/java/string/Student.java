package string;

import java.io.Serializable;

/**
 * @Auther: lyf
 * @Date: 2019-08-05 13:45
 * @Description:
 */
public class Student implements Serializable {

    private Integer id;

    private String school;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
