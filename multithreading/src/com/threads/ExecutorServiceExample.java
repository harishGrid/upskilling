package com.threads;
import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task = () -> {
            Thread.sleep(500);
            return "Task completed by " + Thread.currentThread().getName();
        };

        Future<String> f1 = executor.submit(task);
        Future<String> f2 = executor.submit(task);
        Future<String> f3 = executor.submit(task);

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());

        executor.shutdown();
    }
}