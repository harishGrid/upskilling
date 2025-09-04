package completeable_future;

import java.util.concurrent.CompletableFuture;

public class Program1 {
	
	public static void main(String[] args) {
		
		CompletableFuture<String> greet = CompletableFuture.supplyAsync(()->{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "Hello";
		});
		
		CompletableFuture<String> name = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Harish";
		});
		
		CompletableFuture<String> combinedFuture = greet.thenCombine(name, (g,n)->g+" "+n);
		
		System.out.println(combinedFuture.join());
	}

}
