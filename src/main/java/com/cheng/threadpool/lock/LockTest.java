package com.cheng.threadpool.lock;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁测试
 * junit不支持多线程测试，如果要测试多线程，需要使用CountDownLatch阻止主线程结束
 * junit在主线程结束后就结束了，也不管子线程是否结束
 * Created by niecheng on 2019/4/17.
 */
public class LockTest {
    private final static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        list.add("a");
        list.add("b");
        list.add("c");
        read();
        ThreadFactory threadFactoryName = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2, 10,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),threadFactoryName);
        Thread.sleep(10000);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                read();
                System.out.println(list);
            }
        });
//        threadPoolExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                read();
//                System.out.println(list);
//            }
//        });
    }

    @Test
    public void test() throws InterruptedException {
        CountDownLatch cd = new CountDownLatch(2);
        list.add("a");
        list.add("b");
        list.add("c");
        ThreadFactory threadFactoryName = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2, 10,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),threadFactoryName);

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                read();
                System.out.println(Thread.currentThread().getName()+list);
                if(cd != null){
                    cd.countDown();
                }
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                write();
                System.out.println(Thread.currentThread().getName()+list);
                if(cd != null){
                    cd.countDown();
                }
            }
        });
        cd.await();
        System.out.println("11111111111");
    }


    public static  void read(){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在读取数据中..................");
            // 模拟读操作耗时
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"读取数据完毕..................");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }

    public void write(){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"正在更新数据中..................");
            // 模拟写操作耗时
            Thread.sleep(10000);
            list.add("test1");
            System.out.println(Thread.currentThread().getName()+"更新数据结束..................");
        }catch (Exception e){
            e.printStackTrace();
        } finally{
            lock.writeLock().unlock();
        }
    }
}
