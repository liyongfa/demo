package com.gdut.eurekaserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lyf
 * @Date: 2019-06-28 17:33
 * @Description:
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String haha(){
        return "测试成功";
    }
}
