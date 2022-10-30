package com.cheng.threaddemo.task;

import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;

@AllArgsConstructor
public class TaskOne implements Callable {

    private int num;

    @Override
    public Object call() throws Exception {
        // 沉睡10s，模拟业务操作
        Thread.sleep(100000);
        // 输出当前线程名称
        System.out.println(Thread.currentThread().getName());
        return num;
    }
}
