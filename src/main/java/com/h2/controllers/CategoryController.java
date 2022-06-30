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

import com.h2.entity.Category;
import com.h2.entity.User;
import com.h2.service.CategoryService;
import com.h2.service.UserService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/addCategory")
	public Category addCategory(@RequestBody Category category) {
	return categoryService.createCategory(category);	
	}
	
	
	@PostMapping("/addCategories")
	public List<Category> addCategories(@RequestBody List<Category> categories){
		return categoryService.createCategories(categories);
	}
	
	
	@GetMapping("/category/{id}")
	public Category getCategoryById(@PathVariable int id) {
	return categoryService.getCategoryById(id);	
	}
	
	@GetMapping("/categories")
	public List<Category> getAllCategories(){
		return categoryService.getCategories();	
	}
	
	    @PutMapping("/updateCategory")
		public Category updateCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);	
	}
	    
}
