package com.completeable_future;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureWhenComplete {

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Failure!");
            return "Success";
        });

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Task failed: " + ex.getMessage());
            } else {
                System.out.println("Task succeeded: " + result);
            }
            System.out.println("Cleanup task running...");
        }).get();
    }
}