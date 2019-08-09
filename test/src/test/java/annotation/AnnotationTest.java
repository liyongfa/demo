package annotation;

/**
 * @Auther: lyf
 * @Date: 2019-08-08 15:58
 * @Description: 注解必须要有对应的解析器进行解析, 注解才会起作用
 * 下面以小见大,介绍一下注解在表单验证时注解的一个小小的应用场景
 * 1.注解BeanNotNull作用在类的属性上,注解BeanNotNull的成员属性只有value一个
 * 2.BaseClass里面的isNull方法,就是调用BeanNotNull解析器的一个触发方法
 * 3.BaseClass的子类一调用isNull,就会先获取子类的类型信息Class,然后通过getDeclaredFields方法
 * 获取到类里面的所有属性(不包含父类的属性)
 * 4.遍历所有的属性对象Filed,通过属性对象拿到类的属性上面的BeanNotNull注解,
 * 如果注解存在就判断该属性是否是null,是的话,就将注解BeanNotNull里面value成员的值赋值给err_message字段
 * 并且返回true,告诉isNull调用者,这个类里面有属性的值为null
 * 5.isNull对基本数据类型不起作用(对基本数据类型起不起作用就不知道了,应该起的????)
 * 6.这个注解能作用在所有继承了Object的属性上,如果想对基本数据类型起作用,那么对isNull解析方法做一下兼容操作就行
 */
public class AnnotationTest {
    public static void main(String[] args) {
        User user = new User();
        user.setName("哈哈");
        //调用isNull方法,其实就是调用了注解的解析器
        if (user.isNull()) {
            //输出错误信息,其实就是@BeanNotNull("age不能为空")里面的'age不能为空'内容
            System.out.println(user.getErr_message());
        }
    }
}
