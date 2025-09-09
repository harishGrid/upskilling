package com.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Runnable task1=()->System.out.println("task1");
		Runnable task2=()->System.out.println("task2");
		Runnable task3=()->System.out.println("task3");
		
		executor.submit(task1);
		executor.submit(task2);
		executor.submit(task3);
		
		executor.shutdown();
		
		executor.awaitTermination(5, TimeUnit.SECONDS);
		
		
	}

}
