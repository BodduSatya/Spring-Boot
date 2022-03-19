package com.javaminds.springbootiq.product;

import com.javaminds.springbootiq.product.exception.ProductNotFoundException;
import com.javaminds.springbootiq.product.modal.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Log4j2
public class ProductController {

    private static HashMap<String, Product> products = new HashMap<>();
    private HashMap<String, Product> products2 = null;
    static {
        products.put("1",new Product(1,"Android"));
        products.put("2",new Product(2,"MAC"));
        products.put("3",new Product(3,"Chrome"));
        products.put("4",new Product(4,"Windows"));
        products.put("5",new Product(5,"Linux"));
    }

    @RequestMapping( path = "/product/{id}",method = RequestMethod.GET)
    private ResponseEntity<Product> findObject(@PathVariable("id") String id){
        log.info("product id=>"+id);
        log.info("products size=>"+products.size());
        if( !products.containsKey(id) ) throw new ProductNotFoundException();

        return new ResponseEntity<Product>(products.get(id), HttpStatus.OK);

        // to produce null pointer exception.
//        return new ResponseEntity<Product>(products2.get(id), HttpStatus.OK);
    }

}
