package pattern;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @Auther: lyf
 * @Date: 2019-08-05 14:20
 * @Description:
 */
public class PatternTest {

    @Test
    public void test1() {
        Pattern pattern = Pattern.compile("abc");
        //最多切分成3个字符串
        Arrays.stream(pattern.split("1323abc2323abc2323abc23abc23abc23abc", 3))
                .forEach(System.out::println);
    }

    @Test
    public void test2() {
        //compile是作为一个整体进行匹配的
        Pattern pattern = Pattern.compile("a+b?c*");
        //以'abc'作为分隔符进行分隔操作
        Arrays.stream(pattern.split("1323aaaac2323ab2323abc23ac23abc23abccc"))
                .forEach(System.out::println);
        System.out.println(pattern.flags());
    }

    public void test3() {
        Pattern pattern = Pattern.compile("abc");
    }
}
