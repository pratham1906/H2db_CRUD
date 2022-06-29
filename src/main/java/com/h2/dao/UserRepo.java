package com.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
