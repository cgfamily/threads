package com.shagri;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread implements Runnable {
	
	private int count = 3;
	
	public MyThread() {
		super();
		System.out.println(Thread.currentThread()+"线程启动...");
	}

	@Override
	public void run() {
		while(count > 0 ){
			count--;
			System.out.println(Thread.currentThread()+"run内部打印一条消息...");
			Thread.yield();
		}
		System.out.println(Thread.currentThread()+"线程执行结束...");

	}
	
	public static void main(String[] args) {
		/*for(int i=0;i<5;i++){
			Thread thread = new Thread(new MyThread());
			thread.start();
		}*/
		/**
		 * 使用执行器创建
		 */
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			if(!es.isShutdown()){
				es.execute(new MyThread());
			}
			es.shutdown();
		}
	}

}
