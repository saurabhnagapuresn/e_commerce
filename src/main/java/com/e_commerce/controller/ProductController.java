package com.e_commerce.controller;


import com.e_commerce.entity.Product;
import com.e_commerce.model.ProductListViewResponse;
import com.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestParam("productName") String productName,
                                 @RequestParam("brandName") String brandName,
                                 @RequestParam("categoryId") Long categoryId) {
        return productService.createProduct(productName, brandName, categoryId);
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable("id") Long id,
                                @RequestParam("productName") String productName,
                                @RequestParam("brandName") String brandName) {
        return productService.updateProduct(id, productName, brandName);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping
    public ProductListViewResponse getProductsWithPagination(@RequestParam(value = "page", defaultValue = "10", required = false) int page,
                                                             @RequestParam(value = "size", defaultValue = "0", required = false) int size) {
        return productService.getProductsWithPagination(page, size);

    }


    @GetMapping("/{id}")
    public Product getCategoryById(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        return productService.deleteProduct(id);
    }
}
