package com.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Quartz 任务调度测试
 *
 * maven依赖：
 * <dependency>
     <groupId>org.quartz-scheduler</groupId>
     <artifactId>quartz</artifactId>
     <version>2.3.0</version>
  </dependency>
 * Created by niecheng on 2019/5/29.
 *
 * 作用：编写我们的具体要实现任务
 */
public class HelloJob implements Job{

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 打印当前的执行时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间："+sdf.format(date));
        // 具体的业务
        System.out.println("Hello Quartz!");
    }
}
