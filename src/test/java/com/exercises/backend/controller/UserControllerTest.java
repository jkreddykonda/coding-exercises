package com.exercises.backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.exercises.backend.services.user.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
    private MockMvc mockMvc;

	@MockBean
    private UserService userService;  // Fake UserService for testing

    @Test
    @DisplayName("Should fetch combined user data successfully")
    void testFetchCombinedUserData() throws Exception {
        // Mock the UserService behavior
        Mockito.when(userService.fetchCombinedData(101L, 102L))
               .thenReturn(CompletableFuture.completedFuture("User1: Alice - Developer, User2: Bob - Manager"));
      
        
        // Perform initial async request
        var mvcResult = mockMvc.perform(get("/api/users/fetch-combined?id1=101&id2=102"))
                .andExpect(status().isOk())
                .andReturn();
        
        // Wait for async result and assert
        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(content().string("User1: Alice - Developer, User2: Bob - Manager"));

        
    }

}
