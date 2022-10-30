package com.cheng.tyrcatch;

/**
 * 测试finally和return的执行顺序
 * Created by niecheng on 2019/3/27.
 * @author niecheng
 *
 * [try]中return，则finally之后的代码不会执行
 * [catch]中return，则finaly之后不能有代码，否则报错
 * [try]中没有return，则finally之后的代码会执行
 * [return]之后，会把return后的值临时存储起来，即使之后return后面的变量的值变了，除非重新return，否则最终的return结果不变
 */
public class TryCatchFinallyReturn {

    public static void main(String[] args) {
        System.out.println(test2());
    }

    public static String test2() {

        try {

            System.out.println("try block");
            return test3();
        }
        catch (Exception e) {

            System.out.println("catch block");

        }
        finally {

            System.out.println("finally block");
        }

        System.out.println("last block1");
        return "last block2";
    }

    public static String test3() {
        System.out.println("return block");
        return "output return block";
    }

}
