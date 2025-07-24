package com.task.social_media.dto;

public class CommonMessageResponse {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CommonMessageResponse(String message) {
		super();
		this.message = message;
	}
	public CommonMessageResponse() {}
}
