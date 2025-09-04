package completeable_future;

import java.util.concurrent.CompletableFuture;

public class DataProcessingPipeline {
	static String fetchData() {
	        simulateDelay(500);
	        System.out.println("Fetched raw data");
	        return "raw data";
	    }
	    static String cleanData(String data) {
	        simulateDelay(700);
	        System.out.println("Cleaned data");
	        return data.trim();
	    }
	    static String transformData(String data) {
	        simulateDelay(600);
	        System.out.println("Transformed data");
	        return data.toUpperCase();
	    }
	    static void saveData(String data) {
	        simulateDelay(400);
	        System.out.println("Saved data: " + data);
	    }
	    static void simulateDelay(int millis) {
	        try { Thread.sleep(millis); } catch (InterruptedException e) { }
	    }
	    public static void main(String[] args) {
			CompletableFuture<Void> pipeline = CompletableFuture.supplyAsync(()->fetchData())
			            .thenApplyAsync(data-> cleanData(data))
			            .thenApplyAsync(cleanedData->transformData(cleanedData))
			            .thenAcceptAsync(transformed->saveData(transformed));
			
			pipeline.join();
		}
}

