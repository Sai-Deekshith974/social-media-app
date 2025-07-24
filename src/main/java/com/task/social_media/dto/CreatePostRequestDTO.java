package com.task.social_media.dto;

public class CreatePostRequestDTO {
	private String title;
    private String content;
    private String userId;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public CreatePostRequestDTO(String title, String content, String userId) {
		super();
		this.title = title;
		this.content = content;
		this.userId = userId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public CreatePostRequestDTO() {}
}
