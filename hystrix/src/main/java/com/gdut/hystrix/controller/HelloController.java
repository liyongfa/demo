package com.gdut.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Auther: lyf
 * @Date: 2019-07-22 10:07
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    private HelloServiceImpl helloService;

    @RequestMapping("/hello")
    public String hello(String name) {
        return helloService.hello(name);
    }

    @RequestMapping("/testCvs")
    public void testCvs(HttpServletResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append("账号,密码\n");
        sb.append("abc,123\n");
        sb.append("abc,123\n");
        sb.append("abc,123\n");
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(sb.toString());
            //以二进制流的格式进行输出
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            //需要指定一下下载的文件名,否则格式无法识别
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("账号密码", "UTF-8") + System.currentTimeMillis() + ".csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
