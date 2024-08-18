package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.demo.models.ProductModel;
import com.example.demo.services.FakeStoreService;
import com.example.demo.dtos.ProductResponseDTO;

@RestController
class ProductController {

    // dependecy on ProductService Interface
    private FakeStoreService svc;  // using particular implementation of ProductService Interface
    
    public ProductController(FakeStoreService svc) {
        this.svc = svc;
    }

    @PostMapping("/product")
    public void createProduct() {

    }

    @GetMapping("/products")
    public ProductResponseDTO[] getProducts () {
        ProductModel[] products = svc.getProducts();

        ProductResponseDTO[] productResponseDTOs = new ProductResponseDTO[products.length];

        for (int i = 0; i < products.length; ++i) {
            productResponseDTOs[i] = products[i].toProductResponseDTO();
        }

        return productResponseDTOs;
    }


    @GetMapping("/product/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") long id) {
        
        System.out.println("Calling FakeStoreService svc.getProductById");
        // service will return Internal Model
        ProductModel product = svc.getProductById(id);

        System.out.println("Product id is " + product.getId());
        System.out.println("Title is " + product.getTitle());
        System.out.println("Description is " + product.getDescription());
        System.out.println("Price is " + product.getPrice());
        System.out.println("ImageURL is " + product.getImageURL());
        System.out.println("ImageURL is " + product.getImageURL());
        // controller will return Contract View
        return product.toProductResponseDTO();
    }

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") long id) {

    }
}