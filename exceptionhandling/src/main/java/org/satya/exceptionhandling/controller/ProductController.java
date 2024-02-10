package org.satya.exceptionhandling.controller;

import org.satya.exceptionhandling.dto.Product;
import org.satya.exceptionhandling.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/shopNow/getProductInfo/{id}")
    public String getProductInfo(@PathVariable int id ){
        String p = null;
        try {
            p = productService.getProductInfoById(id).getName();
        }catch (Exception e){
            return " order id not found exception caught in product controller = ";
        }
        return p;
    }
}
