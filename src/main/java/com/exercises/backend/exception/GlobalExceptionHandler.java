package com.exercises.backend.exception;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleUserNotFound(UserNotFoundException ex) {
		return new ResponseEntity<>(
				Map.of("timestamp", LocalDateTime.now(), "error", "User Not Found", "message", ex.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex) {
	    return new ResponseEntity<>(
	            Map.of(
	                    "timestamp", LocalDateTime.now(),
	                    "error", ex.getMessage()
	            ),
	            HttpStatus.BAD_REQUEST
	    );
	}
}
