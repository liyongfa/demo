package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxy implements InvocationHandler {

    //这里不能将真实对象设置成static静态属性，因为不安全
    //HelloService实现类的真实对象可能会存在很多个，而obj静态属性在HelloServiceProxy类型中
    //只会保存一个，所以会存在不安全的场景。所以应该将obj作为私有属性
    //这是真实对象
    private HelloService obj;

    /**
     * 将真实对象传进来，并返回一个动态代理对象
     *
     * @param helloService
     * @return
     */
    public static HelloService getProxyInstance(HelloService helloService) {
        //创建InvocationHandler实现类
        HelloServiceProxy proxy = new HelloServiceProxy();
        //将参数赋值给真实对象
        proxy.obj = helloService;
        //获取类型信息
        Class<? extends HelloService> clazz = helloService.getClass();
        //创建动态代理对象实例
        //第一个参数是类加载器，第二个参数是希望代理实现的接口列表（是接口，不是类或者抽象类，
        //这两个参数可以通过类型信息获取），第三个参数是InvocationHandler的一个实现
        return (HelloService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), proxy);
    }

    /**
     * @param proxy  动态代理的代理对象信息
     * @param method 调用的方法的对象信息
     * @param args   调用方法的所有参数信息
     * @return 返回调用方法的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----调用方法之前------");
        //result就是调用方法的返回值，如果方法的返回值是void的话
        //那么result的值就是null
        //obj是真实对象
        Object result = method.invoke(obj, args);
        //如果invoke方法出现异常，那么下面代码就不会再执行了
        System.out.println("-----调用方法之后------");
        return result;
    }
}
