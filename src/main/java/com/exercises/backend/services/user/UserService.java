package com.exercises.backend.services.user;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.exercises.backend.exception.UserNotFoundException;


@Service
public class UserService {
	
	private static final Map<Long, String> USER_DATA = Map.of(
            101L, "Alice - Software Engineer",
            102L, "Bob - Product Manager",
            103L, "Charlie - UX Designer",
            104L, "Diana - QA Lead"
    );

    public CompletableFuture<String> fetchUserData(long userId) {
        return CompletableFuture.supplyAsync(() -> {
            simulateDelay();
            
            if (!USER_DATA.containsKey(userId)) {
                throw new UserNotFoundException(userId);
            }

            return userId + ": "+ USER_DATA.get(userId);
        }).exceptionally(ex -> "Error: " + (ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage()));
    }

    public CompletableFuture<String> fetchCombinedData(long userId1, long userId2) {
        CompletableFuture<String> future1 = fetchUserData(userId1);
        CompletableFuture<String> future2 = fetchUserData(userId2);

        return future1.thenCombine(future2, (result1, result2) ->
                "Id1: " + result1 + ", Id2: " + result2);
    }

    private void simulateDelay() {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(200, 600));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
