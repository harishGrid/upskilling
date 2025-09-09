package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable{

	CountDownLatch latch;
	
	public Worker(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" execution starts");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" execution ends");
			latch.countDown();
	}
	
}

public class CountDownLatchExample2 {
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch=new CountDownLatch(3);
		for(int i=0;i<3;i++) {
          new Thread(new Worker(latch)).start();   
		}
		latch.await();
		
	}

}
