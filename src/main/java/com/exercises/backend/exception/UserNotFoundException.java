package com.exercises.backend.exception;

public class UserNotFoundException extends RuntimeException {
 
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(long id) {
        super("User ID " + id + " not found");
    }

}
