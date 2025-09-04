package batch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BatchProcessingLimitedParallelism {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		List<Integer> data = IntStream.rangeClosed(1, 25).boxed().collect(Collectors.toList());
        int batchSize = 5;

        List<List<Integer>> batches = createBatches(data, batchSize);
        
        List<CompletableFuture<List<Integer>>> collect = batches.stream()
        		.map(batch->CompletableFuture.supplyAsync(()->processBatch(batch),executor))
                .collect(Collectors.toList());
        
        CompletableFuture<Void> allDone = CompletableFuture.allOf(collect.toArray(new CompletableFuture[0]));
       
        CompletableFuture<List<Integer>> thenApply = allDone.thenApply(v->collect.stream()
        		.flatMap(f->f.join().stream()).collect(Collectors.toList()));
        
        System.out.println(thenApply.join());
        
        List<Integer> join = thenApply.join();
        System.out.println(join);
		
	}
	
	private static List<Integer> processBatch(List<Integer> batch) {
        System.out.println("Processing batch: " + batch + " in thread " + Thread.currentThread().getName());
        try { Thread.sleep(400); } catch (InterruptedException e) { }
        return batch.stream()
            .map(i -> i + 100)
            .collect(Collectors.toList());
    }
	
	 private static <T> List<List<T>> createBatches(List<T> source, int batchSize) {
         List<List<T>> batches = new ArrayList<>();
         int totalSize = source.size();
         for (int i = 0; i < totalSize; i += batchSize) {
             batches.add(source.subList(i, Math.min(totalSize, i + batchSize)));
         }
         return batches;
     }
}
