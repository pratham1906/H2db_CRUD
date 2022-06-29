package com.h2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users){
		return userService.createUsers(users);
	}
	
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
	return userService.getUserById(id);	
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getUsers();	
	}
	
	    @PutMapping("/updateUser")
		public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);	
	}
	    
	    @DeleteMapping("/deleteUser/{id}")
	    public String deleteUser(@PathVariable int id) {
	    	return userService.deleteUserById(id);
	    }
	    
}
