package com.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample3 {
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Future<?> future = executor.submit(()->{
			try {
				for(int i=0;i<10;i++) {
					System.out.println("Working....");
					Thread.sleep(1000);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		Thread.sleep(3000);
		System.out.println("Cancelling task...");
		future.cancel(true);
		
		executor.shutdown();
	}
}

