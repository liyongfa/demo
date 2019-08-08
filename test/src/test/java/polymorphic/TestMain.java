package polymorphic;

import org.junit.Test;

/**
 * @Auther: lyf
 * @Date: 2019-08-06 18:57
 * @Description:
 */
public class TestMain {
    @Test
    public void test1() {
        Person p = new Student();
        System.out.println(p.name);//如果访问属性的话,那么就会直接访问'右边类型的可访问属性'
        p.say();//如果是方法的话,子类实现了覆盖就会调用子类的覆盖后的方法,如果没有就调用父类的方法
    }
}
class Person {
    public String name = "我是一个人";

    public void say() {
        System.out.println(name);
    }
}
class Student extends Person {
    //如果子类的属性和父类的属性相同的话,那么子类的属性就会覆盖父类的属性
    //但是父类对象仍可以访问它的属性,只是子类使用的不在是父类的属性
    //列如:Person p = new Student();  p.name获取到的值是"我是一个人",但是子类方法say通过this.name
    //获取到的值却是"gjaigaio"
    public String name = "gjaigaio";
    @Override
    public void say() {
        System.out.println(this.name);
    }
}


