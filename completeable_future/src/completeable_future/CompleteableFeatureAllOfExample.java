package completeable_future;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompleteableFeatureAllOfExample {
	public static void main(String[] args) {
	
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "sleep 1";
		});
		
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "sleep 2";
		});
		
		CompletableFuture<String> f3 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "sleep 3";
		});

		CompletableFuture<Void> allOf = CompletableFuture.allOf(f1,f2,f3);
		
		CompletableFuture<List<String>> thenApply = allOf.thenApply(v->Stream.of(f1,f2,f3).map(CompletableFuture::join)
				.collect(Collectors.toList()));
		
		List<String> join = thenApply.join();
		System.out.println(join);
		
	}
}
