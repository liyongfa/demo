package proxy;

public class TestMain {

    public static void main(String[] args) {
        //创建真实对象
        HelloService helloService = new HelloServiceImpl();
        //获取代理对象
        helloService = HelloServiceProxy.getProxyInstance(helloService);
        //调用方法，触发代理操作
        helloService.sayHello();
        System.out.println("---------------下面演示一下接口相关知识-------------");
        //可以直接访问接口里面的常量信息
        System.out.println(HelloService.MESSAGE);
        //实现HelloService里面的内部接口Introduce
        HelloService.Introduce introduce = new HelloService.Introduce() {
            @Override
            public void say() {
                System.out.println("哈哈哈");
            }
        };
        introduce.say();
        //如果大家感兴趣的话，可以自己去学学lambda表示式和stream流
        //这些是jdk1.8的特性，这里只是做一下介绍
        HelloService.Introduce introduce2 = () ->
                System.out.println("这是使用lambda表达式来实现接口");
        introduce2.say();


    }
}


