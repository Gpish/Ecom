package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryModel {
    private long id;
    private String name;

    public CategoryModel(String name) {
        this.id = 1;
        this.name = name;
    }
}