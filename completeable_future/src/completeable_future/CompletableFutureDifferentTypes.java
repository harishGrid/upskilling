package completeable_future;
import java.util.concurrent.*;

public class CompletableFutureDifferentTypes {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> " apples");

        CompletableFuture<String> thenCombine = future1.thenCombine(future2, (f1,f2)->f1 +" "+f2);
        System.out.println(thenCombine.join());
    }
}