package completeable_future;
import java.util.concurrent.*;

public class CompletableFutureAnyOfExample {
    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            sleep(700);
            return "Task 1 completed";
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            sleep(300);
            return "Task 2 completed";
        });

       CompletableFuture<Object> anyOf = CompletableFuture.anyOf(f1,f2);
       System.out.println(anyOf.join());
    }

    private static void sleep(int millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) { }
    }
}