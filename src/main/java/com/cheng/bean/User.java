package com.cheng.bean;

import lombok.Data;

import java.util.Arrays;

/**
 * @author
 * @Description 类描述
 * @date 2021/4/14 15:41
 */
@Data
public class User {
    private int id;
    private String name;
    private Integer age;
    private String add;
    private String old;
    private String[] friends;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friends=" + Arrays.toString(friends) +
                '}';
    }
}
