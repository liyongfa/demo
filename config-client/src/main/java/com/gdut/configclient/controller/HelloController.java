package com.gdut.configclient.controller;

import com.gdut.configclient.config.Student;
import com.gdut.configclient.config.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lyf
 * @Date: 2019-07-04 17:08
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    private Student student;

    @GetMapping("/hello")
    public User hello() {
        System.out.println(student);
        User user = new User();
        BeanUtils.copyProperties(student, user);
        return user;
    }
}
