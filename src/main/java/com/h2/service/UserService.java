package com.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.h2.dao.UserRepo;
import com.h2.entity.User;

@Service
public class UserService {
    @Autowired
	private UserRepo userRepo;
    
    public User createUser(User user) {
    	return userRepo.save(user);
    }
    
    public List<User> createUsers(List<User> users) {
    	return userRepo.saveAll(users);
    }
    
    public User getUserById(int id) {
    	return userRepo.findById(id).orElse(null);
    }
    public List<User> getUsers() {
    	return userRepo.findAll();
    }
    
    public User updateUser(User user) {
    	User temp;
    	Optional<User> optionalUser=userRepo.findById(user.getId());
    
    	if(optionalUser.isPresent()) {
    		User oldUser=optionalUser.get();
    		temp=oldUser;
    		oldUser.setAddress(user.getAddress());
    		oldUser.setName(user.getName());
    		userRepo.save(oldUser);
    	}
    	else {
    		return new User();
    	}
    	return temp;
    }
    
    public String deleteUserById(int id) {
    	userRepo.deleteById(id);
    	return "User got deleted";
    }
}
