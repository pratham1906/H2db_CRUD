package com.h2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
