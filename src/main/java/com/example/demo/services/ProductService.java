package com.example.demo.services;

import com.example.demo.models.ProductModel;
import com.example.demo.services.FakeStoreService;

public interface ProductService {
    public ProductModel getProductById(long id);
    public void createProduct();
}