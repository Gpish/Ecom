package com.example.demo.models;

import com.example.demo.models.CategoryModel;
import com.example.demo.dtos.ProductResponseDTO;
import com.example.demo.dtos.FakeStoreProductResponseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductModel {
    private long id;
    private String title;
    private String description;
    private float price;
    private String imageURL;
    private CategoryModel category;
    
    public ProductResponseDTO toProductResponseDTO() {
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();

        productResponseDTO.setId(this.id);
        productResponseDTO.setTitle(this.title);
        productResponseDTO.setDescription(this.description);
        productResponseDTO.setPrice(this.price);
        productResponseDTO.setImageURL(this.imageURL);
        productResponseDTO.setCategory(this.category);

        return productResponseDTO;
    }
}