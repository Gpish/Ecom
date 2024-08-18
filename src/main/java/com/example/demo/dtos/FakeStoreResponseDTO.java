package com.example.demo.dtos;

import com.example.demo.models.ProductModel;
import com.example.demo.models.CategoryModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreResponseDTO {
    private long id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;

    // to convert FakeStoreResponseDTO to ProductModel to be served by service layer
    public ProductModel toProduct() {
        ProductModel productModel = new ProductModel();

        productModel.setId(this.id);
        productModel.setTitle(this.title);
        productModel.setDescription(this.description);
        productModel.setPrice(Float.parseFloat(this.price));
        productModel.setImageURL(this.image);
        productModel.setCategory(new CategoryModel(this.category));
        return productModel;
    }
}