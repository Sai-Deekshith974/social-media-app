package com.task.social_media.dto;

public class CreatePostResponseDTO {
	private long postId;
    private String title;
    private String content;
    private String authorId;
    private int likeCount;
	public long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public CreatePostResponseDTO(long postId, String title, String content, String authorId, int likeCount) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.authorId = authorId;
		this.likeCount = likeCount;
	}
    public CreatePostResponseDTO() {}
}
