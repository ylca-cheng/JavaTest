package com.cheng.threadpool.thread;

/**
 * 测试多线程
 * Created by niecheng on 2019/8/22.
 */
public class ThreadTest2 {

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<100;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
            thread.start();
            System.out.println(Thread.currentThread().getName()+"-----------"+Thread.currentThread().getState());
        }
        /*while (true){
            System.out.println(Thread.currentThread().getName()+"-----------"+Thread.currentThread().getState());
            Thread.sleep(1000);
        }*/
    }
}
