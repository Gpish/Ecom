package com.example.demo.dtos;

import com.example.demo.models.ProductModel;
import com.example.demo.models.CategoryModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // this is the contract with the 3rd party, as to what fields to return
public class CategoryResponseDTO {
    private long id;
    private String name;
    
}