package com.javaminds.redis.respository;

import com.javaminds.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    public static final String HASH_KEY = "Product";

    private final RedisTemplate template;

    public ProductDao(RedisTemplate template) {
        this.template = template;
    }

    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id){
        System.out.println("called findProductById() from DB");
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }

    public String deleteProduct(int id){
         template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }
}
