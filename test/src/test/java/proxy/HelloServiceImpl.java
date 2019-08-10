package proxy;

public class HelloServiceImpl implements HelloService  {

    @Override
    public void sayHello() {
        System.out.println("大家好！我是哈哈！");
    }
}
