package com.javaminds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootEksApplication {


    @GetMapping("/greetings")
    public String message() {
        return "Welcome to javatechie ! app deployed in AWS EKS";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEksApplication.class, args);
    }

}
