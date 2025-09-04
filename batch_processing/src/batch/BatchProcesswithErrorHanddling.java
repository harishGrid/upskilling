package batch;

//getting error

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BatchProcesswithErrorHanddling {
	public static void main(String[] args) {
		
		List<Integer> numbers = IntStream.rangeClosed(1, 20).boxed().collect(Collectors.toList());
		
		int batchSize=5;
		
		List<List<Integer>> batches = createBatches(numbers, batchSize);
		
		List<CompletableFuture<Object>> collect = batches.stream().map(batch->processbatchWithRetry(batch,1)).collect(Collectors.toList());
		
		
		
		
	}
	
	private static CompletableFuture<Object> 
	       processbatchWithRetry(List<Integer> batch, int retriesLeft) {
		
		return CompletableFuture.supplyAsync(()->processBatch(batch))
				.handle((result,ex)->{
					if(ex==null) {
						return CompletableFuture.completedFuture(result);
					}else if(retriesLeft>1) {
						return processbatchWithRetry(batch, retriesLeft-1);
					}else {
						return CompletableFuture.completedFuture(Collections.emptyList());
					}
				});
	}
	
	static List<Integer> processBatch(List<Integer> batch){
		return batch.stream().map(i->i*i).collect(Collectors.toList());
	}

	static List<List<Integer>> createBatches(List<Integer> numbers,int batchSize){
		List<List<Integer>> batches = new ArrayList<>();
		int totalSize=numbers.size();
		
		for(int i=0;i<totalSize;i+=batchSize) {
			batches.add(numbers.subList(i, Math.min(totalSize, i+batchSize)));
		}
		return batches;
	}
}
