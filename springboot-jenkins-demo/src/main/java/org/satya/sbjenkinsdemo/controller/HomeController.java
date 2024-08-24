package org.satya.sbjenkinsdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/info")
    public String welcome(){
        return "version :: 1.0";
    }
}
