package com.gdut.hystrix.controller;

import com.gdut.hystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lyf
 * @Date: 2019-07-22 10:07
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(String name) {
        return helloService.hello(name);
    }
}
