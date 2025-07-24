package com.task.social_media.dto;

public class LoginResponseDTO {
	private String token;
	private String userName;

	public String getToken() {
		return token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoginResponseDTO(String userName, String token) {
		super();
		this.token = token;
		this.userName = userName;
	}
	public LoginResponseDTO() {}
}
