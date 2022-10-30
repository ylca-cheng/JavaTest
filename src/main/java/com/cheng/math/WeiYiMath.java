package com.cheng.math;

import org.junit.Test;

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

        System.out.println(-1 & 0xff);
        System.out.println(Integer.toBinaryString(-1));

        System.out.println(2 << 2);
    }

    @Test
    public void test(){
        System.out.println(33 & 3);
        System.out.println(Integer.toBinaryString( 3));
        System.out.println(Integer.toBinaryString( 33));

        System.out.println(Integer.toBinaryString((1<< 16)-1));
        System.out.println(Integer.toBinaryString(~((1<< 16)-1)));
        System.out.println((1<< 16)-1);
        System.out.println(12 & ~((1<< 16)-1));
    }
}
