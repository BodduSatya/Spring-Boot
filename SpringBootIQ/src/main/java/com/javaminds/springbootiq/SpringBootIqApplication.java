package com.javaminds.springbootiq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// use exclude tag of @SpringBootApplication or @EnableAutoConfiguration to disable autoconfiguration for perticular module.
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class SpringBootIqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIqApplication.class, args);
    }

}
