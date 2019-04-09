package com.cheng.threadpool;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 大小无限制的线程池，支持定时和周期性的执行线程
 * Created by niecheng on 2019/4/2.
 */
public class NewScheduledThreadPool {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        exec.scheduleAtFixedRate(new Runnable() {
            //每隔一段时间就触发异常
            @Override
            public void run() {
                // TODO Auto-generated method stub
                //throw new RuntimeException();
                System.out.println("===================");

            }
        }, 1000, 5000, TimeUnit.MILLISECONDS);

        exec.scheduleAtFixedRate(new Runnable() {
            //每隔一段时间打印系统时间，证明两者是互不影响的

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println(System.nanoTime());

            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);


    }
}
