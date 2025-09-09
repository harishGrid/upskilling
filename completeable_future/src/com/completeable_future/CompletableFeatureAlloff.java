package com.completeable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFeatureAlloff {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
	
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "Task 1");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Task 2");
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "Task 3");
		
        CompletableFuture<Void> allOf = CompletableFuture.allOf(f1,f2,f3);
        allOf.join();
        
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
	}
}
