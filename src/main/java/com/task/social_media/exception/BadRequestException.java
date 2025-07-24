package com.task.social_media.exception;

public class BadRequestException extends RuntimeException {
	public BadRequestException(String message) {
        super(message);
    }
}
