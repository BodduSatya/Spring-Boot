package com.satya.productservice.controller;

import com.satya.productservice.entity.Product;
import com.satya.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        Map<String, Object> response = new HashMap<>();
        try {
            // Save the product
            Product savedProduct = productService.saveProduct(product);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedProduct.getId())
                    .toUri();

            response.put("message", "Product created successfully");
            response.put("product", savedProduct);
            response.put("location", location.toString().replaceFirst("/add",""));
            response.put("status", HttpStatus.CREATED);

            return new ResponseEntity<>(response, HttpStatus.CREATED);

        } catch (Exception e) {
            response.put("message", "Failed to save the product!");
            response.put("product", null);
            response.put("location", "");
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        try{
            Product updatedProduct = productService.updateProduct(id,product);
            if( updatedProduct !=null ){
                response.put("message", "Product updated successfully");
                response.put("product", updatedProduct);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else{
                response.put("message", "Product with given id not available!");
                response.put("product", null);
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            System.out.println("e.getMessage() = " + e.getMessage());
            response.put("message", "something went wrong!");
            response.put("product", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id){
        Map<String, Object> response = new HashMap<>();
        String msg = productService.deleteProduct(id);
        response.put("message",msg);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
