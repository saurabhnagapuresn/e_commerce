package com.e_commerce.controller;

import com.e_commerce.entity.Category;
import com.e_commerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category createCategory(@RequestParam("categoryName") String categoryName) {
       return categoryService.createCategory(categoryName);
    }

    @PutMapping("/{id}")
    public String updateCategory(@PathVariable("id") Long id,
                                 @RequestParam("categoryName") String categoryName) {
        return categoryService.updateCategory(id, categoryName);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) {
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        return categoryService.deleteCategory(id);
    }
}
