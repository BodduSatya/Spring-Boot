package org.satya.exceptionhandling.service;

import org.satya.exceptionhandling.dto.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private static List<Product> products = Arrays.asList(
            new Product(1,"IPhone",10,95000),
                new Product(2,"Android",10,65000),
                new Product(3,"Windows",10,60000)
        );
    public Product getProductInfoById(int productId) {
        Optional<Product> product = products.stream().filter(p -> p.getProductId() == productId).findFirst();

        if( product.isEmpty() ){
            throw new RuntimeException("Product with given id not found!");
        }
        else {
            return product.get();
        }
    }
}
