package com.cheng.threadpool.queue;

import java.util.concurrent.ExecutorService;

public class TestQueue {
	public static void main(String[] args) {
		ExecutorService threadPool = ThreadPool.getThreadPool();
		Produce produce = new Produce();
		threadPool.execute(produce);
		Consumer consumer = Consumer.getInstance();
		threadPool.execute(consumer);
	}
}
