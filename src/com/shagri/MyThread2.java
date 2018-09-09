package com.shagri;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyThread2 implements Runnable {

	@Override
	public void run() {
		Random rand = new Random();
        int randomNum = rand.nextInt((10) + 1);
		try {
			//TimeUnit.MILLISECONDS.sleep(randomNum*1000);
			Thread.sleep(randomNum*1000);
			System.out.println(Thread.currentThread()+"ÀØ√ﬂ¡À"+randomNum+"√Î£°");
		} catch (InterruptedException e) {
			System.out.println(e);
		}

	}
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			es.execute(new MyThread2());
		}
	}
}
