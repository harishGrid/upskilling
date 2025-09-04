package completeable_future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureThenAcceptAsync {
	public static void main(String[] args) {
		CompletableFuture<Void> f1 = CompletableFuture.supplyAsync(()->{
			System.out.println("Processed in thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Hello";
		}).thenAcceptAsync(result->{
			System.out.println("Processed in thread: " + Thread.currentThread().getName());
            System.out.println("Result: " + result);
		});
		
		
		
		System.out.println(f1.join());
	}
}

