package com.gdut.hystrix.service.impl;

import com.gdut.hystrix.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Auther: lyf
 * @Date: 2019-07-22 10:03
 * @Description:
 */
@Service
public class HelloServiceImpl implements HelloService {

    /**
     * 断路器,当相对应的服务发生异常的时候,就可以调用其他的服务进行返回
     * 就是服务降级的意思
     * 'fallbackMethod'响应的方法
     *
     * @param name
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "defaultHello")
    public String hello(String name) {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Welcome to China!" + name;
    }

    /**
     * 进行服务降级时调用的方法,需要和原方法的参数和返回值必须一致
     *
     * @param name
     * @return
     */
    public String defaultHello(String name) {
        return "Hello," + name;
    }
}
