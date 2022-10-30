package com.cheng.Test.pattern;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * @Author: niecheng
 * @Date: 2020/8/27 15:59
 * @Version 1.0
 */
public class PatternTest {

    @Test
    public void test(){
        String regx = ".*\\.jpg";
        String filename = "2.jpg";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        System.out.println(pattern.matcher(filename).matches());
    }
}
