package com.task.social_media.dto;

import java.util.List;

public class LikePostResponseDTO {
	
	private long postId;
	private List<String> userIds;
	public long getPostId() {
		return postId;
	}
	public void setPostId(long postId) {
		this.postId = postId;
	}
	public List<String> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}
	public LikePostResponseDTO(long postId, List<String> userIds) {
		super();
		this.postId = postId;
		this.userIds = userIds;
	}
	public LikePostResponseDTO() {}
}
