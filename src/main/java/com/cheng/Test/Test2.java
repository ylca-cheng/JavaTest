package com.cheng.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //创建一个可重用固定线程数的线程池
        ExecutorService pool= Executors.newSingleThreadExecutor();
        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口;
        Thread t1=new MyThread("thread1","thread11");
        Thread t2=new MyThread("thread2","thread22");
        Thread t3=new MyThread("thread3","thread33");
        Thread t4=new MyThread("thread4","thread44");
        Thread t5=new MyThread("thread5","thread55");
//        t1.setName("thread1");
//        t2.setName("thread2");
//        t3.setName("thread3");
//        t4.setName("thread4");
//        t5.setName("thread5");
        //将线程放到池中执行；
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown();
    }
}
class MyThread extends Thread {

    private String name2;

    public MyThread(String name, String name2) {
        super(name);
        this.name2 = name2;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        //        super.run();
        System.out.println(Thread.currentThread().getName()+"正在执行....");
        System.out.println(this.name2);
    }
}