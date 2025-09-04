package completeable_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureCombineMultiple {
	public static void main(String[] args) {
	
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Task 1";
		});
		
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Task 2";
		});
		
		CompletableFuture<String> f3 = CompletableFuture.supplyAsync(()->{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Task 3";
		});
		List<CompletableFuture<String>> list=Arrays.asList(f1,f2,f3);
		
		CompletableFuture<Void> allOf = CompletableFuture.allOf(f1,f2,f3);
		
		CompletableFuture<List<String>> thenApply = allOf.thenApply(v->list.stream()
				     .map(CompletableFuture::join).collect(Collectors.toList()));
		
		CompletableFuture<String> handle = allOf.handle((ignored, ex) -> {
		    if (ex != null) {
		        for (CompletableFuture<String> f : list) {
		            if (!f.isCompletedExceptionally()) {
		                return f.join(); 
		            }
		        }
		        return "No Success";
		    }

		    return list.get(0).join();
		});
		
		System.out.println(thenApply.join());
		
		System.out.println(handle.join());
		
	}
}
