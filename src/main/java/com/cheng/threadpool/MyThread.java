package com.cheng.threadpool;

/**
 * 线程类
 * Created by niecheng on 2019/4/1.
 *
 */
public class MyThread extends Thread{

    public MyThread() {

    }

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
//        super.run();
        System.out.println(Thread.currentThread().getName()+"正在执行....");
    }


    public static void main(String[] args) {
        Thread thread = new MyThread("A");
        thread.start();
    }
}
