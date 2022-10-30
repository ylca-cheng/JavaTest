package com.cheng.Test;

import org.junit.Test;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    @Test
    public void doSomething() {
        final String str1 = "Hello";
         String str2 = "World!";
        // 创建一个方法里的局部内部类
        class Test {
            public void out() {
                System.out.println(str1);
                System.out.println(str2);
                // System.out.println(str2);
            }
        }
        Test test = new Test();
        test.out();

    }
}
