package com.task.social_media.exception;

public class PostNotFoundException extends RuntimeException {
	public PostNotFoundException(String message) {
        super(message);
    }
}
