package com.cheng.threadpool.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//创建一个无界自动回收的线程池
public class ThreadPool {
	private static ExecutorService threadPool = null;

	public static ExecutorService getThreadPool() {
		if (threadPool == null) {
			threadPool = Executors.newCachedThreadPool();
		}
		return threadPool;
	}
}
