package com.gdut.configclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: lyf
 * @Date: 2019-07-12 15:54
 * @Description:
 */
@RestController
public class TestController {

    //有点类似就是用来做远程访问的
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test() {
        HttpEntity<String> entity = new HttpEntity<>();
        restTemplate.postForEntity("http://xxx.abc", entity, String.class);
        ResponseEntity<String> response = restTemplate.getForEntity("http://xxx.png", String.class, "参数");
        return response.getBody();
    }
}
