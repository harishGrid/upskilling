package com.completeable_future;
import java.util.concurrent.CompletableFuture;

public class ThenApplyAsyncExample {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello");

        CompletableFuture<String> transformed = future.thenApplyAsync(s -> {
            System.out.println("Running in thread: " + Thread.currentThread().getName());
            return s.toUpperCase();
        });

        System.out.println(transformed.get());  // Output: HELLO
    }
}