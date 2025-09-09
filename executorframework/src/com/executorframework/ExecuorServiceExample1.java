package com.executorframework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuorServiceExample1 {
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		List<Callable<String>> tasks=new ArrayList<>();
		
		for(int i=0;i<5;i++) {
			int taskId=i;
			tasks.add(()->{
				Thread.sleep(1000);
				return Thread.currentThread().getName()+"TaskId : "+taskId;
			});
		}
		
		List<Future<String>> invokeAll = executor.invokeAll(tasks);
		invokeAll.stream().forEach(s->{
			try {
				System.out.println(s.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}
}
