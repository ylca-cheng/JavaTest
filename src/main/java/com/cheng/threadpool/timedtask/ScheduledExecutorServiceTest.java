package com.cheng.threadpool.timedtask;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author niecheng
 * @explain 测试定时线程池 scheduleWithFixedDelay 和  scheduleAtFixedRate
 *
 * scheduleWithFixedDelay从字面意义上可以理解为就是以固定延迟（时间）来执行线程任务，
 * 它实际上是不管线程任务的执行时间的，每次都要把任务执行完成后再延迟固定时间后再执行下一次。
 *
 * scheduleAtFixedRate
 * 创建并执行一个周期性动作，在给定的初始延迟后首先启用，然后在给定的时间段内启用；
 * 即执行将在initialDelay之后开始，然后是initialDelay+period ，
 * 然后是initialDelay + 2 * period ，依此类推。 如果任务的任何执行遇到异常，则后续执行将被抑制。
 * 否则，任务只会通过取消或终止执行程序而终止。 如果此任务的任何执行时间超过其周期，则后续执行可能会延迟开始，但不会并发执行。
 *
 * scheduleWithFixedDelay 和 scheduleAtFixedRate 都是需要等上一个任务完成才执行下一个任务，
 * 区别在于：scheduleWithFixedDelay的下一个任务的执行时间是上一个任务执行完成的时间+延迟时间
 * scheduleAtFixedRate的下一个任务的执行时间是看上一个任务的，如果上一个任务的完成时间小于延迟时间，则下一个任务的执行时间为上一个任务开始执行时间+延迟时间
 * 如果上一个任务的执行时间大于延迟时间，则下一个任务的执行时间为上一个任务的完成时间
 */
public class ScheduledExecutorServiceTest {

    @Test
    public void scheduleWithFixedDelay() throws InterruptedException {

        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        // 响铃线程
        final Runnable beeper = new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long time = (long) (Math.random() * 10000);
                // 输出线程的名字和使用目标对象及休眠的时间
                System.out.println(sf.format(new Date())+"线程:"+Thread.currentThread().getName()+":Sleeping"+time+"ms");
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {

                }
            }
        };

        // 设定执行线程计划,初始10s延迟,每次任务完成后延迟10s再执行一次任务
        final ScheduledFuture<?> sFuture=scheduledExecutorService.scheduleWithFixedDelay(beeper,1,2, TimeUnit.SECONDS);

        // 40s后取消线程任务
        /*scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                sFuture.cancel(true);
                scheduledExecutorService.shutdown();
            }
        }, 40, TimeUnit.SECONDS);*/

        // 让主线程睡眠，以免主线程结束，程序终止
        Thread.sleep(100000);
        System.out.println("111111111111");
    }

    @Test
    public void scheduleAtFixedRate() throws InterruptedException {
        // 声明线程池
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        // 响铃线程
        final Runnable beeper = new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long time = (long) (Math.random() * 10000);
                // 输出线程的名字和使用目标对象及休眠的时间
                System.out.println(sf.format(new Date()) + " 线程：" + Thread.currentThread().getName() + ":Sleeping " + time + "ms");
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                }
            }
        };
        // 计划响铃，初始延迟10s然后以10s的频率执行响铃
        final ScheduledFuture<?> beeperHandle = scheduledExecutorService.scheduleAtFixedRate(beeper, 1, 2, TimeUnit.SECONDS);

        // 取消响铃并关闭线程
        final Runnable cancelBeeper = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "CANCEL...");
                beeperHandle.cancel(true);
                scheduledExecutorService.shutdown();
            }
        };
        // 60s后执行scheduleAtFixedRate
        scheduledExecutorService.schedule(cancelBeeper, 40, TimeUnit.SECONDS);

        // 让主线程睡眠，以免主线程结束，程序终止
        Thread.sleep(100000);
        System.out.println("22222222222");
    }


}

