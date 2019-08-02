package com.gdut.configclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Auther: lyf
 * @Date: 2019-07-04 17:05
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "student")
@RefreshScope//当统一配置文件发生改变的时候,进行相应属性的刷新操作
//属性类是没有办法直接转换成json格式返回给前端的
public class Student {
    //属性必须具备setter,getter方法,否则将无法进行属性的获取操作
    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
