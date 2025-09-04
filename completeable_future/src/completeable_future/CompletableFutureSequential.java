package completeable_future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureSequential {
	public static void main(String[] args) {
		
	  CompletableFuture<String> thenCompose = CompletableFuture.supplyAsync(()->{
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  return "Hello";
	  }).thenCompose(result->CompletableFuture.supplyAsync(()->{
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  return result+" Harish";
	  }));
		
	  System.out.println(thenCompose.join());
	}
}
