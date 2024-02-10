package org.satya.springbootcache.service;

import org.satya.springbootcache.modal.Product;
import org.satya.springbootcache.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    @Cacheable(cacheNames = "product", key="#id")
    public Product getProductById(long id){
        return repository.findById(id).orElse(null);
    }

    @Cacheable(cacheNames = "product", key="#name")
    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    @CacheEvict(cacheNames = "product", key = "#id")
    public String deleteProduct(long id){
        Product existingProduct = repository.findById(id).orElse(null);
        if( existingProduct!=null ) {
            repository.deleteById(id);
            return "Product with ID - " + id+" removed.";
        }
        else{
            return "Invalid Product ID, No product exist with given ID!";
        }
    }

    @CachePut(cacheNames = "product", key="#productId")
    public Product updateProduct(long productId,Product product){
        Product existingProduct = repository.findById(productId).orElse(null);
        if(existingProduct!=null ){
            existingProduct.setName(product.getName());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
            return repository.save(existingProduct);
        }
        else
            return null;
//            return "Invalid Product ID, No product exist with given ID!";
    }
}
