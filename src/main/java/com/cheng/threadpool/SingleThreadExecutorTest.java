package com.cheng.threadpool;

import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单一线程 线程池
 * Created by niecheng on 2019/4/1.
 */
public class SingleThreadExecutorTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        //创建一个可重用固定线程数的线程池
        ExecutorService pool= Executors.newSingleThreadExecutor();

        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口;


        Thread t1=new MyThread();

        Thread t2=new MyThread();

        Thread t3=new MyThread();

        Thread t4=new MyThread();

        Thread t5=new MyThread();

        //将线程放到池中执行；

        pool.execute(t1);

        pool.execute(t2);

        pool.execute(t3);

        pool.execute(t4);

        pool.execute(t5);

        //关闭线程池

        pool.shutdown();



    }



    @Test
    public void test(){

        for (int i = 0 ; i < 100; i++){
            calculation(i);
        }

    }

    private void calculation(Integer num){
        pool.execute(new Thread(){
            @Override
            public void run(){
                execTask(num);
                /*try {
                    // 睡眠一分钟
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        });
    }
    private ExecutorService pool= Executors.newSingleThreadExecutor();
    private Queue<Integer> taskQueue = new ConcurrentLinkedQueue<Integer>();
    private Thread taskThread = new Thread() {
        @Override
        public void run(){
            Integer task;
            while((task=taskQueue.poll())!=null){
                execTask(task);
                try {
                    // 睡眠一分钟
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private void execTask(Integer num){
        System.out.println(num);
    }



}
