package com.task.social_media.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.task.social_media.dto.UserRequestDTO;
import com.task.social_media.dto.UserResponseDTO;
import com.task.social_media.exception.BadRequestException;
import com.task.social_media.exception.IncorrectPasswordException;
import com.task.social_media.exception.UserAlreadyExistsException;

@Service
public class UserService implements UserDetailsService {
	
	List<UserResponseDTO> users = new ArrayList<>();
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	//To add the user into the list
	public UserResponseDTO saveUser(UserRequestDTO user) {
		
		if(user.getUserName() == null || user.getUserName().length() == 0 || user.getPassword() == null || user.getPassword().length() == 0) {
			logger.error("Bad request");
			throw new BadRequestException("Enter valid details");
		}
		if(findUser(user.getUserName())==null) {
			if(user.getPassword().equals(user.getConfirmPassword())) {
				UserResponseDTO newUser = new UserResponseDTO(users.size()>0? users.get(users.size()-1).getId()+1: 1, user.getUserName(), user.getPassword());
				users.add(newUser);
				logger.info("User created successfully");
				return newUser;
			}
			logger.error("password and confirm password are not equal");
			throw new IncorrectPasswordException("Enter the valid details");
		}
		throw new UserAlreadyExistsException("User already exists");
	}
	
	//To find the user whether he is already exists or not
	public UserResponseDTO findUser(String username) {
		for(int i = 0;i<users.size();i++) {
			if(users.get(i).getUserName().equals(username)) {
				return users.get(i);
			}
		}
		return null;
	}
	
	//To valid user details
	public boolean validateUser(String username, String password) {
		for(int i = 0;i<users.size();i++) {
			if(users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	 @Override
	    public UserDetails loadUserByUsername(String username) {
		 	
	        UserResponseDTO user = findUser(username);

	        return new org.springframework.security.core.userdetails.User(
	                user.getUserName(), user.getPassword(), new ArrayList<>()
	        );
	    }
	
	
}
