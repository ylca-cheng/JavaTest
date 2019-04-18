package com.cheng.threadpool.queue;

//提供一个出队的线程，实际使用的消费者
public class Consumer implements Runnable {
	private static Consumer consumer;
	public static volatile boolean isRunning = true;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (TaskQueue.getTaskQueue().isEmpty()) {
			System.out.println("此时无人等候！");
		}
		// 测试线程是否已经中断isInterrupted()

		while (Thread.currentThread().isInterrupted() == false && isRunning) {
			try {
			    if(!TaskQueue.getTaskQueue().isEmpty()){
                    System.out.println(TaskQueue.getTaskQueue() + "我们正在排队");
                    System.out.println("经过1.5秒");
                    System.out.println("出队+" + TaskQueue.getTaskQueue().take() + "✌！我买到票了");
                    Thread.sleep(1 * 3000);
                }else {
			        // 睡1s
                    Thread.sleep(1 * 1000);
                }
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static Consumer getInstance() {
		if (consumer == null) {
			consumer = new Consumer();
			System.out.println("初始化消费线程");
		}
		return consumer;

	}

}
