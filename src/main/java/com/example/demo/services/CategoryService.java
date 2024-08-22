package com.example.demo.services;

import com.example.demo.models.CategoryModel;
import com.example.demo.services.FakeStoreService;
import com.example.demo.dtos.ProductResponseDTO;

public interface CategoryService {
    public CategoryModel[] getAllCategories();
}