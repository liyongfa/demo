package random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

/**
 * @Auther: lyf
 * @Date: 2019-08-05 12:50
 * @Description:使用commons.lang3包来实现常见的随机生成数字和字符串的应用场景
 */
public class RandomTest {

    @Test
    public void test1() {
        //返回一个1000-9999的随机数字
        System.out.println(RandomUtils.nextInt(1000, 10000));
    }

    @Test
    public void test2() {
        //可以生成六位的随机验证码,手机验证的时候可以使用
        System.out.println(RandomStringUtils.random(6, "0123456789"));
        System.out.println(RandomStringUtils.random(6, 'a', 'b', 'c', 'd', 'e'));
    }

    @Test
    public void test3() {
        //生成随机字符串
        //由纯英文字符组成
        System.out.println(RandomStringUtils.randomAlphabetic(20));
        //由英文字符和数字组成的随机字符串
        System.out.println(RandomStringUtils.randomAlphanumeric(20));
    }

    @Test
    public void test4() {
        //由纯字母组成
        System.out.println(RandomStringUtils.random(10, true, false));
        //由纯数字组成
        System.out.println(RandomStringUtils.random(10, false, true));
    }
}
