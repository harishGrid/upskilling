package com.completeable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenApplyAsyncCustomExecutor {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(()->"Hari");
		
		CompletableFuture<String> thenApply = supplyAsync.thenApplyAsync(s->{
			return s.toUpperCase();},executor);
		
	System.out.println(thenApply.get());
		
	}
}

