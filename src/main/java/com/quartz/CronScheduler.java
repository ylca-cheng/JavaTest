package com.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * cron表达式测试任务调度
 *
 * Created by niecheng on 2019/5/29.
 */
public class CronScheduler {
    public static void main(String[] args) throws Exception {
        //jobDetail
        // 2.3.0
//        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("cronJob").build();
        JobDetail jobDetail = new JobDetail("cronJob", Scheduler.DEFAULT_GROUP, HelloJob.class);
        //cronTrigger
        //每日的9点40触发任务
        // 2.3.0
        /*CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("cronTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 35 14 * * ? ")).build();*/
        CronTrigger cronTrigger = new CronTrigger("cronTrigger",Scheduler.DEFAULT_GROUP,"50 21 16 * * ? ");
        //Scheduler实例
//        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
//        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//        scheduler.start();
        scheduler.scheduleJob(jobDetail,cronTrigger);


    }
}
