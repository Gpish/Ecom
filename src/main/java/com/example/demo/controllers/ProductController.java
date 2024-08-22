package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.models.ProductModel;
import com.example.demo.models.CategoryModel;

import com.example.demo.services.FakeStoreService;

import com.example.demo.dtos.ProductResponseDTO;
import com.example.demo.dtos.CategoryResponseDTO;
import com.example.demo.dtos.CreateProductDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
class ProductController {

    // dependecy on ProductService Interface
    private FakeStoreService svc;  // using particular implementation of ProductService Interface
    
    public ProductController(FakeStoreService svc) {
        this.svc = svc;
    }

    @GetMapping("/products/category/{name}")
    public List<ProductResponseDTO> getProductsByCategory(@PathVariable("name") String categoryName) {
        ProductModel[] products = svc.getProductsByCategory(categoryName);

        List<ProductResponseDTO> productsByCategory = new ArrayList<ProductResponseDTO>();

        for (int i = 0; i < products.length; ++i) {
            productsByCategory.add(products[i].toProductResponseDTO());
        }

        return productsByCategory;
    }

    @GetMapping("/products/categories") 
    public CategoryResponseDTO[] getAllCategories() {
        CategoryModel[] categories = svc.getAllCategories();

        CategoryResponseDTO[] categoryResponseDTOs = new CategoryResponseDTO[categories.length];

        for (int i = 0; i < categories.length; ++i) {
            categoryResponseDTOs[i] = categories[i].toCategoryResponseDTO();
        }

        return categoryResponseDTOs;
    }

    @PostMapping("/product")
    public ProductResponseDTO createProduct(@RequestBody CreateProductDTO createProductDTO) {
        // call to service, receive ProductModel
        ProductModel createdProductModel = svc.createProduct(createProductDTO.getTitle(),
                createProductDTO.getDescription(),
                createProductDTO.getPrice(),
                createProductDTO.getImage(),
                createProductDTO.getCategory());
        
        // return ProductResponseDTO
        return createdProductModel.toProductResponseDTO();
    }

    @GetMapping("/products")
    public ProductResponseDTO[] getAllProducts () {
        ProductModel[] products = svc.getAllProducts();

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
        // controller will return Contract View
        return product.toProductResponseDTO();
    }

    @DeleteMapping("/product/{id}")
    public void deleteProductById(@PathVariable("id") long id) {

    }
}