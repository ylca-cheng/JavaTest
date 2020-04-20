package com.cheng.math;

import org.junit.Test;

import java.util.Random;

/**
 * Created by niecheng on 2019/5/5.
 */
public class MathTest {
    public static void main(String[] args) {
        int i = 1,j = 1;
        System.out.println(Math.round(0.49));
        System.out.println(i++);
        System.out.println(++j);

        Random random = new Random();
        System.out.println(random.nextInt(10));
    }

    @Test
    public void integerTest(){
        Integer i = Integer.getInteger("a");
        System.out.println(i.intValue());
    }
}
