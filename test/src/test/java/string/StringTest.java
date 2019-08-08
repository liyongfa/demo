package string;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: lyf
 * @Date: 2019-08-02 17:30
 * @Description:
 */
public class StringTest {

    @Test
    public void test1() {
        User user = new User();
        user.setName("哈哈");
        user.setAge(22);
        user.setFriends(new String[]{"a", "b", "cv"});
        Student stu = new Student();
        stu.setId(5686896);
        stu.setSchool("娃哈哈");
        user.setStudent(stu);
        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.DEFAULT_STYLE));
    }

    @Test
    public void test2() {
        System.out.println("是不是由字母和数字组成:" + StringUtils.isAlphanumeric("4g76s7hs97hsgshgsHIOUIJHGIA"));
        System.out.println("是不是纯字母:" + StringUtils.isAlpha("hfaHIOHIOHI"));
        //获取缩写
        System.out.println("要求字符串的长度必须大于等于4:" + StringUtils.abbreviate("gaijgoajgoa", 6));
        System.out.println("第二个参数是后面省略的标志字符串:" + StringUtils.abbreviate("gjajghpoa", "---", 8));
    }

}
