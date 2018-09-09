package com.shagri;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread implements Runnable {
	
	private int count = 3;
	
	public MyThread() {
		super();
		System.out.println(Thread.currentThread()+"�߳�����...");
	}

	@Override
	public void run() {
		while(count > 0 ){
			count--;
			System.out.println(Thread.currentThread()+"run�ڲ���ӡһ����Ϣ...");
			Thread.yield();
		}
		System.out.println(Thread.currentThread()+"�߳�ִ�н���...");

	}
	
	public static void main(String[] args) {
		/*for(int i=0;i<5;i++){
			Thread thread = new Thread(new MyThread());
			thread.start();
		}*/
		/**
		 * ʹ��ִ��������
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
