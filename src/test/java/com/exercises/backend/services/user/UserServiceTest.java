package com.exercises.backend.services.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserServiceTest {

	private final UserService userService = new UserService();

    @Test
    @DisplayName("Should fetch user data successfully for valid user ID")
    void testFetchUserDataSuccess() throws Exception {
        CompletableFuture<String> future = userService.fetchUserData(101L);
        String result = future.get();
        assertEquals("101: Alice - Software Engineer", result);
    }

    @Test
    @DisplayName("Should return error message for invalid user ID")
    void testFetchUserDataFailure() throws Exception {
        CompletableFuture<String> future = userService.fetchUserData(999L);
        String result = future.get();
        
        System.out.println("Result = " + result); // Debug print
        assertTrue(result.contains("Error: User ID 999 not found"));
    }


    @Test
    @DisplayName("Should combine two valid user data successfully")
    void testFetchCombinedDataSuccess() throws Exception {
        CompletableFuture<String> future = userService.fetchCombinedData(101L, 102L);
        String result = future.get();
        assertEquals("Id1: 101: Alice - Software Engineer, Id2: 102: Bob - Product Manager", result);
    }

    @Test
    @DisplayName("Should combine with error if any user ID is invalid")
    void testFetchCombinedDataWithInvalidUser() throws Exception {
        CompletableFuture<String> future = userService.fetchCombinedData(101L, 999L);
        String result = future.get();
        assertTrue(result.contains("Error: User ID 999 not found"));
    }

}
