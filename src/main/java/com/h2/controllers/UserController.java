package com.h2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.entity.User;
import com.h2.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
	return userService.createUser(user);	
	}
}
