package com.javaminds.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @RequestMapping("/")
    public String welcome(){
        return "<b>Welcome spring-boot-security demo";
    }

    @GetMapping("/user")
    public String user(){
        return "<b>Welcome user";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<b>Welcome admin";
    }

}
