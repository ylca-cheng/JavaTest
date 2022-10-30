package com.cheng.threadpool.queue;

//提供一个入队的线程，实际使用的生产者
public class Produce implements Runnable {
	private static volatile int i = 1;
	private static volatile boolean isRunning = true;

	@Override
	public void run() {
		synchronized (this) {
			while (isRunning) {
				System.out.println("从我开始排队加入队列：");
				TaskQueue.add(Integer.valueOf(i + ""));
				Produce.i++;
				// System.out.println("入队+"+i);
				try {
					Thread.sleep(1 * 1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
