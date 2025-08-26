package com.javaminds.shoppingcartmcp.tools;

import com.javaminds.shoppingcartmcp.entity.CartItem;
import com.javaminds.shoppingcartmcp.repository.CartItemRepository;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Map;

@Service
public class ShoppingCartMcpService {

    private final CartItemRepository cartItemRepository;

    public ShoppingCartMcpService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    private static final Map<String, Double> PRODUCTS = Map.of(
            "iPhone", 79999.0,
            "MacBook Air", 129999.0,
            "Boat Airdopes", 1999.0
    );

    @Tool(name="add_to_cart",
            description="Add a product to the shopping cart")
    public String addToCart(String productName, int quantity) {
        String matchedProduct = findMatchingProduct(productName);
        if (matchedProduct == null) {
            return "Product not found";
        }

        double price = PRODUCTS.get(matchedProduct);
        var existingItem = cartItemRepository.findByProductName(matchedProduct);
        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            cartItemRepository.save(existingItem);
        } else {
            var newItem = new CartItem();
            newItem.setId(java.util.UUID.randomUUID().toString());
            newItem.setProductId(matchedProduct);
            newItem.setProductName(matchedProduct);
            newItem.setPrice(price);
            newItem.setQuantity(quantity);
            cartItemRepository.save(newItem);
        }
        return "Added to cart: " + matchedProduct + " (Quantity: " + quantity + ")";
    }

    /*private String findMatchingProduct(String inputName) {
        return PRODUCTS.keySet().stream()
                .filter(p -> p.toLowerCase().contains(inputName.toLowerCase()))
                .findFirst()
                .orElse(null);
    }*/

    private String findMatchingProduct(String inputName) {
        LevenshteinDistance distance = new LevenshteinDistance();
        return PRODUCTS.keySet().stream()
                .min(Comparator.comparingInt(p -> distance.apply(p.toLowerCase(), inputName.toLowerCase())))
                .orElse(null);
    }

    @Tool(name="remove_from_cart",
            description="Remove a product from the shopping cart")
    public String removeFromCart(String productName, int quantity) {
        String matchedProduct = findMatchingProduct(productName);
        var existingItem = cartItemRepository.findByProductName(matchedProduct);

        if (existingItem != null) {
            if( quantity == 0 ) {
                cartItemRepository.deleteByProductName(existingItem.getProductName());
            }
            else {
                existingItem.setQuantity(existingItem.getQuantity() - quantity);
                cartItemRepository.save(existingItem);
            }
            return "Removed from cart: " + existingItem.getProductName();
        } else {
            return "Product not found in cart";
        }
    }

    @Tool(name="view_cart",
            description="View all items in the shopping cart")
    public String viewCart() {
        var items = cartItemRepository.findAll();
        if (items.isEmpty()) {
            return "Your cart is empty";
        }
        StringBuilder cartDetails = new StringBuilder("Cart Items:\n");
        double total = 0.0;
        for (var item : items) {
            cartDetails.append(item.getProductName())
                    .append(" - Quantity: ").append(item.getQuantity())
                    .append(", Price: ").append(item.getPrice())
                    .append("\n");
            total += item.getPrice() * item.getQuantity();
        }
        cartDetails.append("Total: ").append(total);
        return cartDetails.toString();
    }

    @Tool(name="calculate_total",
            description="Calculate the total price of items in the shopping cart")
    public double calculateTotal() {
        var items = cartItemRepository.findAll();
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

}
