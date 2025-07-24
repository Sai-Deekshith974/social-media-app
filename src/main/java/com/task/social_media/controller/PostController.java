package com.task.social_media.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.social_media.dto.CommonMessageResponse;
import com.task.social_media.dto.CreatePostRequestDTO;
import com.task.social_media.dto.CreatePostResponseDTO;
import com.task.social_media.dto.LikePostResponseDTO;
import com.task.social_media.exception.PostNotFoundException;
import com.task.social_media.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@PostMapping("/createPost")
    public ResponseEntity<CreatePostResponseDTO> createPost(@RequestBody CreatePostRequestDTO newPost) {
		logger.info("Create post api is being executed");
        return new ResponseEntity<CreatePostResponseDTO>(postService.createPost(newPost), HttpStatus.ACCEPTED);
    }
	
	@GetMapping("/getAllPosts")
	public ResponseEntity<List<CreatePostResponseDTO>> getAllPosts() {
		logger.info("get all posts api is being executed");
		return new ResponseEntity<List<CreatePostResponseDTO>>(postService.getAllPosts(), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deletePost/{postId}")
	public ResponseEntity<CommonMessageResponse> deletePost(@PathVariable("postId") long postId) {
		logger.info("delete post api is being executed");
		if(postService.deletePost(postId)) {
			logger.info("post deleted successfully");
			return new ResponseEntity<CommonMessageResponse>(new CommonMessageResponse("Post deleted successfully"), HttpStatus.ACCEPTED);
		}
		logger.error("post not found");
		throw new PostNotFoundException("Post not found");
	}
	
	@PostMapping("/likeThePost/{userId}/{postId}")
	public ResponseEntity<LikePostResponseDTO> likeThePost(@PathVariable("userId") String userId, @PathVariable("postId") long postId) {
		logger.info("like post api is being executed");
		LikePostResponseDTO response = postService.likeThePost(postId, userId);
		return new ResponseEntity<LikePostResponseDTO>(response, HttpStatus.ACCEPTED);
	}
}
