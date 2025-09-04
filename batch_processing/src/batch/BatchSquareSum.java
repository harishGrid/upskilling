package batch;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class BatchSquareSum {
    public static void main(String[] args) {
    	
    	List<Integer> numbers = IntStream.rangeClosed(1, 30).boxed().collect(Collectors.toList());
    	
    	int batchSize=7;
    	
    	List<List<Integer>> batches = createBranches(numbers, batchSize);
    	
    	List<CompletableFuture<List<Integer>>> futures = batches.stream().map(batch->CompletableFuture.supplyAsync(()->processBatch(batch)))
    	      .collect(Collectors.toList());
    	
    	CompletableFuture<Void> allDone = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    	
    	CompletableFuture<Integer> thenApply = allDone.thenApply(v->futures.stream().flatMap(f->f.join().stream())
    			.mapToInt(Integer::intValue)
    			.sum()); 
    	
    	System.out.println(thenApply.join());
    	       
    }
    
    static List<Integer> processBatch(List<Integer> batch){
    	return batch.stream().map(i->i*i).collect(Collectors.toList());
    }
    
    static List<List<Integer>> createBranches(List<Integer> numbers,int batchSize){
    	List<List<Integer>> batches=new ArrayList<>();
    	int totalSize=numbers.size();
    	
    	for(int i=0;i<totalSize;i+=batchSize) {
    		batches.add(numbers.subList(i,Math.min(totalSize, i+batchSize)));
    	}
    	return batches;
    }
}