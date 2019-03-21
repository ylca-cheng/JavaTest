package com.cheng.domain;

import java.io.Serializable;

/**
 * Created by niecheng on 2018/3/28.
 */
public class User implements Serializable{

    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户年龄
     */
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "姓名："+ name + ",年龄："+ age;
    }
}
