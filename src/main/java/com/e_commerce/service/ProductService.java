package com.e_commerce.service;

import com.e_commerce.entity.Category;
import com.e_commerce.entity.Product;
import com.e_commerce.model.ProductListViewResponse;
import com.e_commerce.repository.CategoryRepository;
import com.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(String productName, String brandName, Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        if (optionalCategory.isPresent()) {
            Product product = new Product();
            product.setProductName(productName);
            product.setBrandName(brandName);
            product.setCategoryId(categoryId);
            return productRepository.save(product);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    public String updateProduct(Long id, String productName, String brandName) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        String response = "";
        if (optionalProduct.isPresent()) {
            optionalProduct.get().setProductName(productName);
            optionalProduct.get().setBrandName(brandName);
            productRepository.save(optionalProduct.get());
            response = "Product updated successfully";
        } else {
            response = "Product not found for given id";
        }
        return response;
    }

    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public String deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        String response = "";
        if (optionalProduct.isPresent()) {
            productRepository.delete(optionalProduct.get());
            response = "Product deleted successfully";
        } else {
            response = "Product not found for given id";
        }
        return response;
    }

    public ProductListViewResponse getProductsWithPagination(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Product> productsWithPagination = productRepository.findAll(paging);
        ProductListViewResponse productListViewResponse = new ProductListViewResponse();
        productListViewResponse.setProducts(productsWithPagination.getContent());
        productListViewResponse.setPage(productListViewResponse.getPage());
        productListViewResponse.setHasNext(productListViewResponse.isHasNext());
        productListViewResponse.setHasPrevious(productListViewResponse.isHasPrevious());
        productListViewResponse.setTotalPages(productListViewResponse.getTotalPages());
        productListViewResponse.setTotalRecords(productListViewResponse.getTotalRecords());
        return productListViewResponse;
    }
}
