package com.e_commerce.service;


import com.e_commerce.entity.Category;
import com.e_commerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(String categoryName) {
        Category category = new Category();
        category.setCategoryName(categoryName);
        return categoryRepository.save(category);
    }

    public String updateCategory(Long id, String categoryName) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        String response;
        if (optionalCategory.isPresent()) {
            optionalCategory.get().setCategoryName(categoryName);
            categoryRepository.save(optionalCategory.get());
            response = "Category updated successfully";
        } else {
            response = "Category not found";
        }
        return response;
    }

    public Category getCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
       return optionalCategory.orElse(null);
    }

    public List<Category> getAllCategories() {
       return categoryRepository.findAll();
    }

    public String deleteCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        String response = "";
        if (optionalCategory.isPresent()) {
            categoryRepository.delete(optionalCategory.get());
            response = "Category deleted successfully";
        } else {
            response = "Category not found for given id";
        }
        return response;
    }
}
