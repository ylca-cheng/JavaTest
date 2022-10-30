package com.cheng.threaddemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("thread")
@RequiredArgsConstructor
public class ThreadController {
    private final TraceableExecutorService traceableExecutorService;

    @GetMapping("/task/{num}")
    public List<String> getTaskResult(@PathVariable int num){
        List<CompletableFuture<String>> futures = new ArrayList<>();

        for (int i = 10*(num-1); i < 10 * num; i++) {
            int finalI = i;
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> task(finalI), traceableExecutorService);
            futures.add(future);
        }
        List<String> result = new ArrayList<>();
        for (CompletableFuture<String> future : futures) {
            try {
                result.add(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public String task(int i){
        try {
            // 睡10s
            Thread.sleep(10000);
            // 输出线程名称
            // System.out.println(Thread.currentThread().getName());
            log.info("任务完成！");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Thread.currentThread().getName() + " -- " + i;
    }
}
