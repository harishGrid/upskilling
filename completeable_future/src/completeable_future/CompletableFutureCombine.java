package com.completeable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureCombine {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<Integer> supplyAsync1 = CompletableFuture.supplyAsync(()->10);
		CompletableFuture<Integer> supplyAsync2 = CompletableFuture.supplyAsync(()->20);
		
		CompletableFuture<Integer> thenCombine = supplyAsync1
				.thenCombine(supplyAsync2, (a,b)->a+b);
		
		System.out.println(thenCombine.get());
	}

}
