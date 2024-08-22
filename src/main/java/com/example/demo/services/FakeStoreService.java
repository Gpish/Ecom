package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.example.demo.models.ProductModel;
import com.example.demo.models.CategoryModel;
import com.example.demo.services.FakeStoreService;
import com.example.demo.dtos.FakeStoreProductResponseDTO;
import com.example.demo.dtos.FakeStoreCategoryResponseDTO;

@Service    // since required to be injected to ProductController
public class FakeStoreService implements ProductService, CategoryService {

    private RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductModel getProductById(long id) {

        // call FakeStore API, which returns a JSON response.
        // calling 3rd Party APIs require RestTemplate.
        System.out.println("Calling restTemplate.getForEntity(url, FKDTO.class)");
        ResponseEntity<FakeStoreProductResponseDTO> response = restTemplate.
            getForEntity( "https://fakestoreapi.com/products/" + id, 
                    FakeStoreProductResponseDTO.class);

        // get the body into a dto;
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = response.getBody();

        if (fakeStoreProductResponseDTO == null) {
            System.out.println("Null response from FakeStore");
            return null;
        }
        
        return fakeStoreProductResponseDTO.toProduct();
    }

    public CategoryModel[] getAllCategories() {
        System.out.println("Calling restTemplate.getForEntity(url, FKCatResDTO.class)");
        ResponseEntity<String[]> response = restTemplate.
            getForEntity("https://fakestoreapi.com/products/categories", 
                    String[].class);

        System.out.println("Getting Array of String body from response");
        String[] fakeStoreCategoryResponse = response.getBody();

        CategoryModel[] categoryModels = new CategoryModel[fakeStoreCategoryResponse.length];

        for (int i = 0; i < fakeStoreCategoryResponse.length; ++i) {
            CategoryModel newCategoryModel = new CategoryModel();
            newCategoryModel.setName(fakeStoreCategoryResponse[i]);
            newCategoryModel.setId(newCategoryModel.getName().length());

            categoryModels[i] = newCategoryModel;
        }

        return categoryModels;
    }

    public ProductModel[] getProductsByCategory(String categoryName) {
        // get all products first
        ResponseEntity<FakeStoreProductResponseDTO[]> response = restTemplate.
            getForEntity("https://fakestoreapi.com/products", 
                    FakeStoreProductResponseDTO[].class);
        
        FakeStoreProductResponseDTO[] products = response.getBody();

        int i = 0, j = 0;
        int n = products.length;
        System.out.println("Finding " + categoryName + " in " + products.length + "products");
        while(i < n) {
            if (categoryName.equals(products[i].getCategory())) {
                System.out.println("j = " + j + " product id = " + products[i].getId() + " category = " + products[i].getCategory());
                products[j] = products[i];
                j++;
            }
            i++;
        }

        ProductModel[] productsByCategory = new ProductModel[j];
        --j;
        while(j >= 0) {
            productsByCategory[j] = products[j].toProduct();
            j--;
        }

        return productsByCategory;        
    }

    public ProductModel[] getAllProducts() {

        System.out.println("Calling restTemplate.getForEntity(url, FKDTO.class)");
        ResponseEntity<FakeStoreProductResponseDTO[]> response = restTemplate.
            getForEntity("https://fakestoreapi.com/products", 
                    FakeStoreProductResponseDTO[].class);
        
        FakeStoreProductResponseDTO[] fakeStoreProductResponse = response.getBody();

        ProductModel[] productModels = new ProductModel[fakeStoreProductResponse.length];

        for (int i = 0; i < fakeStoreProductResponse.length; ++i) {
            productModels[i] = fakeStoreProductResponse[i].toProduct();
        }

        return productModels;

    }
    public ProductModel createProduct(String title, String description, 
            String price, String image, String category) {
        
        // create request body to send to FakeStore
        FakeStoreProductResponseDTO requestBody = new FakeStoreProductResponseDTO();
        // populate request body
        requestBody.setTitle(title);
        requestBody.setDescription(description);
        requestBody.setPrice(price);
        requestBody.setImage(image);
        requestBody.setCategory(category);

        // call 3rd party FakeStoreService, get response in the dto it mapped to
        FakeStoreProductResponseDTO createdProductDTO = restTemplate.
            postForObject("https://fakestoreapi.com/products", 
                    requestBody, FakeStoreProductResponseDTO.class);
        

        return createdProductDTO.toProduct();

    }
}