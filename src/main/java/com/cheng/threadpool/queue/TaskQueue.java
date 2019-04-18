package com.cheng.threadpool.queue;

import java.util.concurrent.LinkedBlockingQueue;

//使用单例模式创建一个无界队列，并提供入队得方法
public class TaskQueue {
	private static LinkedBlockingQueue<Object> queues = null;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static   LinkedBlockingQueue getTaskQueue() {
		if (queues == null) {
			queues = new LinkedBlockingQueue();
			System.out.println("初始化队列");
		}
		return queues;
	}

	@SuppressWarnings("unchecked")
	public static synchronized void add(Object obj) {
		if (queues == null)
			queues = getTaskQueue();
		queues.offer(obj);
		System.out.println("------------------------------");
		System.out.println("入队+" + obj);
	}
}
