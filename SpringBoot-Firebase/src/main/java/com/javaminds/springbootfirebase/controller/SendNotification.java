package com.javaminds.springbootfirebase.controller;

import com.javaminds.springbootfirebase.bean.Note;
import com.javaminds.springbootfirebase.service.FirebaseMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SendNotification {

    @Autowired
    FirebaseMessagingService firebaseMessagingService;

    @PostMapping("/sendNotificationByToken")
    public String sendNotificationByToken(@RequestBody Note note, @RequestParam String token ) throws Exception {
        return firebaseMessagingService.sendNotificationByToken(note,token);
    }

    @PostMapping("/sendNotificationByTopic")
    public String sendNotificationByTopic(@RequestBody Note note, @RequestParam String topic) throws Exception {
        return firebaseMessagingService.sendNotificationByTopic(note,topic);
    }
}
