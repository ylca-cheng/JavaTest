package com.cheng.threaddemo.pool;

import cn.hutool.core.thread.NamedThreadFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPool {

    @Bean("traceableExecutorService")
    public TraceableExecutorService getTraceableExecutorService(BeanFactory beanFactory) {
        return new TraceableExecutorService(beanFactory, new ThreadPoolExecutor(10,
                20,
                0,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new NamedThreadFactory("cheng", false)));
    }

}
