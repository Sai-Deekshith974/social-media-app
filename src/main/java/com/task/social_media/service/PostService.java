package com.task.social_media.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.task.social_media.dto.CreatePostRequestDTO;
import com.task.social_media.dto.CreatePostResponseDTO;
import com.task.social_media.dto.LikePostResponseDTO;
import com.task.social_media.exception.BadRequestException;
import com.task.social_media.exception.PostNotFoundException;

@Service
public class PostService {
	
	List<CreatePostResponseDTO> posts = new ArrayList<>();
	List<LikePostResponseDTO> postLikeDetails = new ArrayList<>();
	
	private static final Logger logger = LoggerFactory.getLogger(PostService.class);
	
	//Business logic to create the post
	public CreatePostResponseDTO createPost(CreatePostRequestDTO post) {
		if(post.getTitle() == null || post.getTitle().length() == 0 || post.getContent() == null || post.getContent().length() == 0) {
			logger.error("Bad request occured");
			throw new BadRequestException("Enter the valid details");
		}
		CreatePostResponseDTO newPost = new CreatePostResponseDTO(posts.size()>0? posts.get(posts.size()-1).getPostId()+1: 1, post.getTitle(), post.getContent(), post.getUserId(), 0);
		posts.add(newPost);
		logger.info("Post created successfully");
		return newPost;
	}	
	
	//Business logic to get all posts
	public List<CreatePostResponseDTO> getAllPosts() {
		return posts;
	}
	
	//Business logic to delete a post
	public boolean deletePost(long postId) {
		for(int i = 0;i<posts.size();i++) {
			if(posts.get(i).getPostId() == postId) {
				posts.remove(i);
				for(int j = 0;j<postLikeDetails.size();j++) {
					if(postLikeDetails.get(j).getPostId() == postId) {
						postLikeDetails.remove(j);
						break;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	//Business logic to like and unlike the post
	public LikePostResponseDTO likeThePost(long postId, String userId) {
		for(int i = 0;i<posts.size();i++) {
			//Check whether the post id exists
			if(posts.get(i).getPostId() == postId) {
				CreatePostResponseDTO temp = posts.get(i);
				temp.setLikeCount(temp.getLikeCount()+1);
				posts.set(i, temp);
				int flag = 0;
				for(int j = 0;j<postLikeDetails.size();j++) {
					//if the postid contains in the postlikedetails object then we are going to add the user to the existing list or user will be added to the new list 
					if(postLikeDetails.get(j).getPostId() == postId) {
						flag = 1;
						List<String> temp1 = postLikeDetails.get(j).getUserIds();
						if(temp1.indexOf(userId) != -1) { 
							temp1.remove(userId);
							temp.setLikeCount(temp.getLikeCount()-2);
							posts.set(i, temp);
						} else { 
							temp1.add(userId);
						}
						postLikeDetails.set(j, new LikePostResponseDTO(postId, temp1));
						logger.info("Post liked or unliked successfully");
						return postLikeDetails.get(j);
					}
				}
				if(flag == 0) {
					List<String> newUserIds = new ArrayList<>();
					newUserIds.add(userId);
					postLikeDetails.add(new LikePostResponseDTO(postId, newUserIds));
					logger.info("Post liked or unliked successfully");
					return postLikeDetails.get(postLikeDetails.size()-1);
				}
			}
		}
		logger.error("Post not found");
		throw new PostNotFoundException("Post not found");
	}
	
	
	
}
