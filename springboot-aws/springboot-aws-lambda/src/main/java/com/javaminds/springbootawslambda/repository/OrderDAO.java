package com.javaminds.springbootawslambda.repository;

import com.javaminds.springbootawslambda.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class OrderDAO {

    public List<Order> buildOrders() {
        return Stream.of(
                new Order(101,"Mobile",20000,1),
                new Order(102,"Book",799,2),
                new Order(103,"Book",499,3),
                new Order(104,"Laptop",75000,1)
                ).collect(Collectors.toList());
    }
}
