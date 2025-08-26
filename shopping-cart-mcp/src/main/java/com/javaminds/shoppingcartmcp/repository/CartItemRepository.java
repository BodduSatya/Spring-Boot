package com.javaminds.shoppingcartmcp.repository;

import com.javaminds.shoppingcartmcp.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, String> {

    CartItem findByProductName(String productId);
    void deleteByProductName(String productName);

}
