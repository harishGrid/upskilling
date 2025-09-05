package com.completeable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> supplyAsync = CompletableFuture
				.supplyAsync(()->"Hello World");
		System.out.println(supplyAsync.get());
	}
}
