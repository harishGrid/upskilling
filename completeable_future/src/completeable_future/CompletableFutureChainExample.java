package completeable_future;
import java.util.concurrent.*;

public class CompletableFutureChainExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(()-> {
        	try {
				Thread.sleep(1000);
				if(true) throw new RuntimeException("Execution Failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	return 42;
        }).exceptionally(ex->{
        	System.out.println("Exception Caught : "+ex.getMessage());
            return 0;
        });
        
        CompletableFuture<String> thenCompose = supplyAsync.thenCompose(userId -> CompletableFuture.supplyAsync(()->{
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	return "User Details Fetched for "+userId;
        }));
        
        System.out.println(thenCompose.join());
    }
}