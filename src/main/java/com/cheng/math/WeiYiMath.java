package com.cheng.math;

/**
 * 位移运算测试
 * Created by niecheng on 2019/4/3.
 */
public class WeiYiMath {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(6297));
        System.out.println(Integer.toBinaryString(6297>>5));
        System.out.println(Integer.toBinaryString(6297<<5));
        System.out.println(Integer.toBinaryString(6297>>>5));
        System.out.println("==============================================");
        System.out.println(Integer.toBinaryString(-6297));
        System.out.println(Integer.toBinaryString(-6297>>5));
        System.out.println(Integer.toBinaryString(-6297<<5));
        System.out.println(Integer.toBinaryString(-6297>>>5));

        System.out.println(Integer.toBinaryString(-15));
        System.out.println(-1<<6);

    }
}
