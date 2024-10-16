package com.javaminds.resource;

import com.javaminds.entity.Product;
import com.javaminds.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;


    @QueryMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category) {
        return service.getProductsByCategory(category);
    }


    @MutationMapping
    public Product updateStock(@Argument int id, @Argument int stock) {
        return service.updateStock(id, stock);

    }

    @MutationMapping
//    @SubscriptionMapping
    public Product receiveNewShipment(@Argument int id, @Argument int quantity) {
        return service.receiveNewShipment(id, quantity);

    }
}
