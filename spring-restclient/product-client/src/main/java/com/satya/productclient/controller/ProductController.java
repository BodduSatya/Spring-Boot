package com.satya.productclient.controller;

import com.satya.productclient.dto.Product;
import com.satya.productclient.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/product-client")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public Object addProduct(@RequestBody Product product) {
        return productService.addNewProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) throws Exception {
        return productService.getProduct(id);
    }

    @PutMapping("/update/{id}")
    public Object updateProduct(@PathVariable long id, @RequestBody Product productRequest) throws Exception {
        return productService.updateProduct(id, productRequest);
    }

    @DeleteMapping("/delete/{id}")
    public Object deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}
