package com.completeable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompleteableFutureAnyOf {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(()->"Hello");
		CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(()->"Harish");
		
		CompletableFuture<Object> anyOf = CompletableFuture.anyOf(supplyAsync,supplyAsync2);
		
		System.out.println(anyOf.get());
	}

}
