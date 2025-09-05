package com.completeable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ChainThenApply {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<Integer> f = CompletableFuture.supplyAsync(()->5);
		
		CompletableFuture<String> result=f.thenApply(s->s*2).thenApply(s->"Result "+s);
		
		CompletableFuture<Void> thenAccept = result.thenAccept(s->System.out.println(s));
	
		thenAccept.get();
	}
	

}
