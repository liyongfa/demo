package proxy;

//接口中的所有方法默认是被public abstract 修饰的
//接口中的所有属性，默认是被public static final 修饰的
//所以接口的所有方法都是抽象公共的，接口的所有属性都是公共的常量属性
public interface HelloService {

    //默认是被public abstract修饰的
    void sayHello();

    //默认是被public static final修饰的
    String MESSAGE = "往事如烟";

    //内部接口和内部类的意思都差不多，把接口定义在指定接口里面
    //会显得接口的归属性比较强一些，具体应该场景也不是太懂
    //但是Map.Entry就是一个内部接口
    //内部接口,可以实现也可以不实现
    interface Introduce {
        void say();
    }
}
