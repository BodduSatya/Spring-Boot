package com.javaminds.springbootiq.controller;

//import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaminds.springbootiq.configuration.BasicConfiguration;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

@RestController
@Slf4j
//@Log4j2
public class TestController {

//    private static Logger log = LogManager.getLogger(TestController.class);

	@Value("${welcome.message}")
	private String welcomeMsg;
	
	@Autowired
	private BasicConfiguration conf = null;
	
    @RequestMapping(path = "/greetVisitor",method = RequestMethod.GET)
    public String greetVisitor(){
        log.trace("=====<> TestController.greetVisitor()");
        log.debug("=====<> TestController.greetVisitor()");
        log.info("=====<> TestController.greetVisitor()");
        log.warn("=====<> TestController.greetVisitor()");
        log.error("=====<> TestController.greetVisitor()");
        return "Hello Visitor, Welcome! Login Date & Time "+ LocalDateTime.now();
    }
    
    @GetMapping("/welcome")
    public String welcomeMsg() {
    	//System.out.println("BasicConfigruation from propertiest file value="+conf.isValue()+",number="+conf.getNumber()+",message="+conf.getMessage());
    	return welcomeMsg;
    }
    
    @RequestMapping("/dynamic-configuration")
    public Map<String,Object> dynamicConfiguration(){
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("value", conf.isValue());
    	map.put("number", conf.getNumber());
    	map.put("message", conf.getMessage());
    	return map;
    }

}
