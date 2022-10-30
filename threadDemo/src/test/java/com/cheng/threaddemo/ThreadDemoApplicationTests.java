package com.cheng.threaddemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootTest(classes = ThreadDemoApplication.class)
@RunWith(SpringRunner.class)
public class ThreadDemoApplicationTests {

    @Autowired
    private TraceableExecutorService traceableExecutorService;

    @Test
    public void contextLoads() throws ExecutionException, InterruptedException {
        List<CompletableFuture<String>> result = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> task(finalI), traceableExecutorService);
            result.add(future);
        }
        for (CompletableFuture<String> stringCompletableFuture : result) {
            System.out.println(stringCompletableFuture.get());
        }
        // result.forEach(System.out::println);
    }

    public String task(int i){
        try {
            // 睡10s
            Thread.sleep(10000);
            // 输出线程名称
            // System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Thread.currentThread().getName() + " -- " + i;
    }

}
