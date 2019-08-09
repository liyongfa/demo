package reflect;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @Auther: lyf
 * @Date: 2019-08-05 13:29
 * @Description:
 */
public class ReflectionTest {

    @Test
    public void test1() {
        try {
            //通过反射来获取类型信息
            Class<?> clazz = Class.forName("reflect.User");
            //无参的构造方法
            User user = (User) clazz.newInstance();
            user.setName("往事如烟");
            user.setAge(22);
            System.out.println(ReflectionToStringBuilder.reflectionToString(user, ToStringStyle.SIMPLE_STYLE));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            Class<?> clazz = Class.forName("reflect.User");
            //有参数的构造方法
            User user = (User) clazz.getConstructor(String.class, int.class).newInstance("往事如烟", 22);
            System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.DEFAULT_STYLE));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        //所有User对象都是由同一个class类型信息创建的,
        //所以所有的User对象的getClass方法获取到的都是同一个类型信息
        //也就是User.class类型字面常量
        Class<User> clazz = User.class;//获取类型的字面常量
        System.out.println("-----类型信息还没有加载进来,因为静态代码块都没有被调用----------------");
        System.out.println(User.message);
        System.out.println("---------访问类的static变量可以让类型信息加载进来------------");
        try {
            //.class好像叫做类的类型字面常量,获取到的就是类的类型信息,不会导致类型被加载初始化
            //通过类型来创建对象
            User user = clazz.getConstructor(String.class, int.class).newInstance("往事如烟", 22);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        //貌似只有当b是常量,并且b是确定值的字符串时才不会引起类型的加载
        //其余情况好像都会引起Student类型被加载进并进行实例化
        System.out.println(Student.b);
    }

    @Test
    public void test5() {
        Class<User> clazz = User.class;
        try {
            User user = clazz.getConstructor(String.class, int.class).newInstance("往事如烟", 22);
            System.out.println("------------------------------------------------------");
            //获取到user内部的所有方法,不包含父类的方法
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                //因为只能这两个方法是不需要传参数的,所以只拿这两个方法来做简单的试验
                if (Arrays.asList("getName", "getAge").contains(method.getName())) {
                    Object obj = method.invoke(user);
                    System.out.println("反射调用方法的返回值:" + obj);
                } else if ("setName".equals(method.getName())) {
                    Object obj = method.invoke(user, "哈哈");
                    //当方法的返回值是void的时候,obj的值就是null
                    System.out.println("调用方法无返回值:" + obj);
                }
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test6() {
        Class<User> clazz = User.class;
        try {
            User user = clazz.getConstructor(String.class, int.class).newInstance("往事如烟", 22);
            //获取到指定构造器
            Constructor<User> constructor = clazz.getConstructor(String.class, int.class);
            //获取到构造器上的所有参数
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                //获取到每一个参数上面的注解
                Annotation[] annotations = parameter.getAnnotations();
                if (annotations != null && annotations.length > 0) {
                    //遍历每一个注解,进行相应的注解解析操作
                    for (Annotation annotation : annotations) {
                        //TODO 里面就是构造方法里面参数注解的相应解析操作
                        //具体内容就不写了,如果想解析构造器里面的自定义注解的话,就是这个流程
                    }
                }
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
