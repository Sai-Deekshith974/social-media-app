package com.task.social_media.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.social_media.dto.LoginRequestDTO;
import com.task.social_media.dto.LoginResponseDTO;
import com.task.social_media.dto.UserRequestDTO;
import com.task.social_media.dto.UserResponseDTO;
import com.task.social_media.exception.IncorrectPasswordException;
import com.task.social_media.service.UserService;
import com.task.social_media.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private UserService userService;
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> addUser(@RequestBody UserRequestDTO user) {
    	logger.info("Add user api is getting executed.");
    	return new ResponseEntity<UserResponseDTO>(userService.saveUser(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
    	logger.info("login api is getting executed.");
        if(userService.validateUser(request.getUserName(), request.getPassword())) {
        	final UserDetails user = userDetailsService.loadUserByUsername(request.getUserName());
        	final String token = jwtUtil.generateToken(user.getUsername());
        	logger.info("Login successful.");
        	return ResponseEntity.ok(new LoginResponseDTO(user.getUsername(), token));
        }
        logger.error("Incorrect password");
        throw new IncorrectPasswordException("Incorrect username or password");
    }
    
}
