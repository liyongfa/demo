package com.gdut.configclient.config;

import java.io.Serializable;

/**
 * @Auther: lyf
 * @Date: 2019-07-04 17:26
 * @Description:
 */
public class User implements Serializable {

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
}
