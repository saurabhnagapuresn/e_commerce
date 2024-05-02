package com.e_commerce.model;

import com.e_commerce.entity.Product;

import java.util.List;

public class ProductListViewResponse {
  private List<Product> Products;
  private Long totalRecords;
  private Integer totalPages;
  private boolean hasNext = false;
  private boolean hasPrevious = false;
  private Integer page;
  private Integer size;

  public List<Product> getProducts() {
    return Products;
  }

  public void setProducts(List<Product> products) {
    Products = products;
  }

  public Long getTotalRecords() {
    return totalRecords;
  }

  public void setTotalRecords(Long totalRecords) {
    this.totalRecords = totalRecords;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public boolean isHasNext() {
    return hasNext;
  }

  public void setHasNext(boolean hasNext) {
    this.hasNext = hasNext;
  }

  public boolean isHasPrevious() {
    return hasPrevious;
  }

  public void setHasPrevious(boolean hasPrevious) {
    this.hasPrevious = hasPrevious;
  }

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }
}