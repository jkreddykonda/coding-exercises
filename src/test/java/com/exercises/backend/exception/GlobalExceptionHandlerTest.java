package com.exercises.backend.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;


public class GlobalExceptionHandlerTest {
	
	 private final GlobalExceptionHandler handler = new GlobalExceptionHandler();

		@Test
	    @DisplayName("Should handle UserNotFoundException correctly")
	    void shouldHandleUserNotFoundException() {
	        // Arrange
	        UserNotFoundException exception = new UserNotFoundException(999L);

	        // Act
	        ResponseEntity<?> response = handler.handleUserNotFound(exception);

	        // Assert
	       
	        assertEquals(404, response.getStatusCodeValue());

	        Map<?, ?> body = (Map<?, ?>) response.getBody();
	        assertEquals("User ID 999 not found", body.get("message"));
	        assertEquals("User Not Found", body.get("error"));
	        assertTrue(body.containsKey("timestamp"));
	    }

}
