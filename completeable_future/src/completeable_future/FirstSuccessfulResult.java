package completeable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FirstSuccessfulResult {
	public static void main(String[] args) {
		
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
				throw new RuntimeException("Failed 1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Task 1";
		});
		
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
				throw new RuntimeException("Failed 1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Task 2";
		});
		
		CompletableFuture<String> f3 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
				throw new RuntimeException("Failed 1");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Task 3";
		});
		List<CompletableFuture<String>> list=Arrays.asList(f1,f2,f3);
		
		CompletableFuture<Object> allOf = CompletableFuture.anyOf(f1,f2,f3);
		
		CompletableFuture<Object> handle = allOf.handle((result,ex)->{
			if(ex==null) {
				return result;
			}
			for(CompletableFuture f:list) {
				if(!f.isCompletedExceptionally()) {
					try {
						return f.get();
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
			return "No Succesful Result";
		});
		
		System.out.println(handle.join());
		
	}
}
