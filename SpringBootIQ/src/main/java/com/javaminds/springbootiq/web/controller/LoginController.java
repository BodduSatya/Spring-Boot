package com.javaminds.springbootiq.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(path="/",method=RequestMethod.GET)
    public String loginPage(ModelMap map){
        map.put("name","Welcome to App!");
        return "welcome";
    }
}
