package com.javaminds.mail.controller;

import com.javaminds.mail.dto.MailRequest;
import com.javaminds.mail.dto.MailResponse;
import com.javaminds.mail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SendMail {

    @Autowired
    private EmailService service;

    @PostMapping("/sendEmail")
    public MailResponse sendEmail(@RequestBody MailRequest request){
        Map<String, Object> modal = new HashMap<>();
        modal.put("name",request.getName());
        modal.put("location","Vizag,India.");
        return service.sendEmail(request,modal);

    }
}
