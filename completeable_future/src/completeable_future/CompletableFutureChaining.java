package com.completeable_future;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureChaining {
	
	public static CompletableFuture<String> fetchUserId() {
        return CompletableFuture.supplyAsync(() -> {
            return "user123";
        });
    }
    public static CompletableFuture<String> fetchUserProfile(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            return "Profile of " + userId;
        });
    }
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> userProfileFuture = fetchUserId()
            .thenCompose(userId -> fetchUserProfile(userId));
        System.out.println(userProfileFuture.get());  
    }

}
