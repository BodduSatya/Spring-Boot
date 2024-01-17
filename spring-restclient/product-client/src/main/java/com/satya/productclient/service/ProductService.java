package com.satya.productclient.service;

import com.satya.productclient.dto.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
@Service
public class ProductService {

    private RestClient restClient;

    @Value("${endpoint.baseUrl}")
    private String baseUrl;

//    public ProductService(){
//        this.restClient = RestClient.builder()
//                .baseUrl("http://127.0.0.1:8080")
//                .build();
//    }

    @PostConstruct
    public void init() {
        // baseUrl is guaranteed to be initialized here
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public Object addNewProduct(Product product) {
        return restClient.post()
                .uri("/api/product/add")
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(Object.class);
    }

    public List<Product> getAllProducts() {
        return restClient.get()
                .uri("/api/product")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Product>>() {
                });
    }

    public Product getProduct(long id) {
        return restClient.get()
                .uri("/api/product/{id}", id)
                .retrieve()
                .body(Product.class);
    }

    public Object updateProduct(long id, Product product) {
        return restClient.put()
                .uri("/api/product/update/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(Object.class);
    }


    public Object deleteProduct(Long id) {
        return restClient.delete()
                .uri("/api/product/delete/{id}", id)
                .retrieve()
                .body(Object.class);
//                .toBodilessEntity();
    }
}
