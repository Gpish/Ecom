package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.ProductModel;
import com.example.demo.models.CategoryModel;

import lombok.Getter;
import lombok.Setter;

@Getter // Actually dont need this since Fake Store sends an Array of Sting, String[] does the job no POJO reqd
@Setter // this is the contract with the 3rd party FS, as to what fields to return
public class FakeStoreCategoryResponseDTO {
    private String name;

    public CategoryModel toCategoryModel() {
        CategoryModel categoryModel = new CategoryModel();

        categoryModel.setName(this.name);
        categoryModel.setId(this.name.length());

        return categoryModel;
    }
}