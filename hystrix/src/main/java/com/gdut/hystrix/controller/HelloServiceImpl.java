package com.gdut.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Auther: lyf
 * @Date: 2019-07-22 10:03
 * @Description:
 */
@Service
public class HelloServiceImpl {

    /**
     * 断路器,当相对应的服务发生异常的时候,就可以调用其他的服务进行返回
     * 就是服务降级的意思
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "spare")
    public String hello(String name){
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Welcome to China!"+name;
    }

    public String spare(String name){
        return "Hello,"+name;
    }
}
