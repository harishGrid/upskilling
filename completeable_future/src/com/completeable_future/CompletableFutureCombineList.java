package com.completeable_future;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureCombineList {
	public static void main(String[] args) {
	
		CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(()->"Hello");
		CompletableFuture<String> supplyAsync2 = CompletableFuture.supplyAsync(()->"Harish");
		CompletableFuture<String> supplyAsync3 = CompletableFuture.supplyAsync(()->"Morning");
		
		CompletableFuture<Object> allOf = CompletableFuture
				.allOf(supplyAsync,supplyAsync2,supplyAsync3)
				.thenApply(v->Stream.of(supplyAsync,supplyAsync2,supplyAsync3)
			    .map(CompletableFuture::join)
			    .collect(Collectors.toList()));
		
		System.out.println(allOf.join());
				
	}
}
