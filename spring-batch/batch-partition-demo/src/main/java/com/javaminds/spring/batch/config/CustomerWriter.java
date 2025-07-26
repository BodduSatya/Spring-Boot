package com.javaminds.spring.batch.config;

import com.javaminds.spring.batch.entity.Customer;
import com.javaminds.spring.batch.repository.CustomerRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class CustomerWriter implements ItemWriter<Customer> {

    private final CustomerRepository customerRepository;

    public CustomerWriter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void write(Chunk<? extends Customer> chunk) throws Exception {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        customerRepository.saveAll(chunk.getItems());
    }
}


