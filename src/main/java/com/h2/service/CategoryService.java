package com.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2.dao.CategoryRepo;
import com.h2.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
    
    public Category createCategory(Category category) {
    	return categoryRepo.save(category);
    }
    
    public List<Category> createCategories(List<Category> categories) {
    	return categoryRepo.saveAll(categories);
    }
    
    public Category getCategoryById(int id) {
    	return categoryRepo.findById(id).orElse(null);
    }
    public List<Category> getCategories() {
    	return categoryRepo.findAll();
    }
    
    public Category updateUser(Category category) {
    	Category temp;
    	Optional<Category> optionalCategory=categoryRepo.findById(category.getId());
    
    	if(optionalCategory.isPresent()) {
    	Category oldCategory=optionalCategory.get();
    		temp=oldCategory;
    		oldCategory.setDesc(category.getDesc());
    		oldCategory.setName(category.getName());
    		categoryRepo.save(oldCategory);
    	}
    	else {
    		return new Category();
    	}
    	return temp;
    }
}
