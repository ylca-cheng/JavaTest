package com.cheng.classtest;

import com.cheng.domain.User;

public class ClassTest {
    public static void main(String[] args) {
        Class z = User.class;
        System.out.println(z.getSuperclass().getSimpleName());
    }
}
