package com.example.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.example.demo.models.ProductModel;
import com.example.demo.services.FakeStoreService;
import com.example.demo.dtos.FakeStoreResponseDTO;

@Service    // since required to be injected to ProductController
public class FakeStoreService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductModel getProductById(long id) {

        // call FakeStore API, which returns a JSON response.
        // calling 3rd Party APIs require RestTemplate.
        System.out.println("Calling restTemplate.getForEntity(url, FKDTO.class)");
        ResponseEntity<FakeStoreResponseDTO> response = restTemplate.
            getForEntity( "https://fakestoreapi.com/products/" + id, 
                    FakeStoreResponseDTO.class);

        // get the body into a dto;
        FakeStoreResponseDTO fakeStoreResponseDTO = response.getBody();

        if (fakeStoreResponseDTO == null) {
            System.out.println("Null response from FakeStore");
            return null;
        }
        
        return fakeStoreResponseDTO.toProduct();
    }

    public ProductModel[] getProducts() {

        System.out.println("Calling restTemplate.getForEntity(url, FKDTO.class)");
        ResponseEntity<FakeStoreResponseDTO[]> response = restTemplate.
            getForEntity("https://fakestoreapi.com/products", 
                    FakeStoreResponseDTO[].class);
        
        FakeStoreResponseDTO[] fakeStoreResponseDTO = response.getBody();

        ProductModel[] productModels = new ProductModel[fakeStoreResponseDTO.length];

        for (int i = 0; i < fakeStoreResponseDTO.length; ++i) {
            productModels[i] = fakeStoreResponseDTO[i].toProduct();
        }

        return productModels;

    }
    public void createProduct() {

    }
}