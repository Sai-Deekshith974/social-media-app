package com.task.social_media.exception;

public class IncorrectPasswordException extends RuntimeException {
	public IncorrectPasswordException(String message) {
        super(message);
    }
}
