package com.cheng.loader;

import com.cheng.Test.loader.CustomCL;

import java.lang.reflect.Method;

/**
 * Created by niecheng on 2019/1/2.
 */
public class ClassloaderTest {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
//                while (true) {
                    try {
                        // 每次都创建出一个新的类加载器
                        CustomCL cl = new CustomCL("src\\main\\resources\\swap", new String[]{"Foo"});
                        Class cls = cl.loadClass("Foo");
                        Object foo = cls.newInstance();

                        Method m = foo.getClass().getMethod("sayHello", new Class[]{});
                        m.invoke(foo, new Object[]{});
                        Thread.sleep(2000);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
//            }
        };
        thread.start();

    }
}