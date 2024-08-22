package com.example.demo.dtos;

import com.example.demo.models.ProductModel;
import com.example.demo.models.CategoryModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter     // this is the PUT/POST contract with the 3rd party service layer FakeStore
public class FakeStoreProductResponseDTO {
    private long id;
    private String title;
    private String description;
    private String price;
    private String image;
    private String category;

    // to convert FakeStoreProductResponseDTO to ProductModel to be served by service layer
    public ProductModel toProduct() {
        ProductModel productModel = new ProductModel();

        productModel.setId(this.id);
        productModel.setTitle(this.title);
        productModel.setDescription(this.description);
        productModel.setPrice(Float.valueOf(this.price));
        productModel.setImageURL(this.image);

        CategoryModel category = new CategoryModel();
        category.setName(this.category);
        category.setId(category.getName().length());
        productModel.setCategory(category);

        return productModel;
    }
}