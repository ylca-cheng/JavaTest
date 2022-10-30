package com.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 作用：简单测试任务调度
 * Created by niecheng on 2019/5/29.
 */
public class HelloScheduler {

    public static void main(String[] args) throws Exception {
        HelloScheduler helloScheduler = new HelloScheduler();
        helloScheduler.simpleScheduler();

    }

    public void simpleScheduler() throws Exception{
        /*//创建一个jobDetail的实例，将该实例与HelloJob Class绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myJob").build();
        //创建一个Trigger触发器的实例，定义该job立即执行，并且每2秒执行一次，一直执行
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
        //创建schedule实例
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);*/
    }
}
