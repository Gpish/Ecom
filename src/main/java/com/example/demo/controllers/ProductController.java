package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
class ProductController {

    @PostMapping("/product")
    public void createProduct() {

    }

    @GetMapping("/products")
    public void getProducts () {

    }


    @GetMapping("/product/{id}")
    public void getProductById(@PathVariable("id") long id) {

    }

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") long id) {

    }
}