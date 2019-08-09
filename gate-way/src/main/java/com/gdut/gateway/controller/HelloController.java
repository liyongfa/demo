package com.gdut.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lyf
 * @Date: 2019-08-09 16:43
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String test() {
        return "success";
    }
}
