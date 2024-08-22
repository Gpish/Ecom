package com.example.demo.services;

import com.example.demo.models.ProductModel;
import com.example.demo.services.FakeStoreService;
import com.example.demo.dtos.ProductResponseDTO;

public interface ProductService {
    public ProductModel getProductById(long id);
    public ProductModel createProduct(String title, String description, 
            String price, String image, String category);
    public ProductModel[] getAllProducts();
    public ProductModel[] getProductsByCategory(String categoryName);
}