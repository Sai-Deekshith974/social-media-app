package com.task.social_media.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String message) {
        super(message);
    }
}
