package com.example.demo.dtos;

import com.example.demo.models.ProductModel;
import com.example.demo.models.CategoryModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // this is the contract with the Frontend Client, as to what fields to return
public class ProductResponseDTO {
    private long id;
    private String title;
    private String description;
    private float price;
    private String imageURL;
    private String category;

}