package com.javaminds.springbootawslambda;

import com.javaminds.springbootawslambda.domain.Order;
import com.javaminds.springbootawslambda.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringbootAwsLambdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsLambdaApplication.class, args);
    }

    @Autowired
    private OrderDAO orderDAO;

    @Bean
    public Supplier<List<Order>> getOrders() {
        return () -> orderDAO.buildOrders();
    }

    @Bean
    public Function<String,List<Order>> findOrderByName() {
        return (input) -> orderDAO.buildOrders().stream().filter(order -> order.getName().equals(input)).collect(Collectors.toList());
    }
}
