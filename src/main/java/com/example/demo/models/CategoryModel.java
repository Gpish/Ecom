package com.example.demo.models;

import com.example.demo.models.ProductModel;
import com.example.demo.models.CategoryModel;
import com.example.demo.dtos.CategoryResponseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryModel {
    private long id;
    private String name;
    
    // public static int counter = 0;

    public CategoryModel() {
        id = 0;
        name = "";
        // ++counter;
    }

    public CategoryResponseDTO toCategoryResponseDTO() {
        CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();

        categoryResponseDTO.setName(this.name);
        categoryResponseDTO.setId(this.id);
        return categoryResponseDTO;
    }
}