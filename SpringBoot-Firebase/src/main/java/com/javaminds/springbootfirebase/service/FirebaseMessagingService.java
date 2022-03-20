package com.javaminds.springbootfirebase.service;

import com.google.firebase.messaging.*;
import com.javaminds.springbootfirebase.bean.Note;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {

    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public String sendNotificationByToken(Note note,String token) throws Exception{
        /*Notification notification = Notification
                .builder()
                .setTitle(note.getSubject())
                .setBody(note.getContent())
                .setImage(note.getImage())
                .build();

        Message message = Message
                .builder()
                .setToken(token)
                .setNotification(notification)
                .putAllData(note.getData())
                .build();

        return firebaseMessaging.send(message);*/

        return firebaseMessaging.send(webpushMessage(note,token));

    }

    public String sendNotificationByTopic(Note note,String topic) throws Exception{
        Notification notification = Notification
                .builder()
                .setTitle(note.getSubject())
                .setBody(note.getContent())
                .setImage(note.getImage())
                .build();

        Message message = Message
                .builder()
                .setTopic(topic)
                .setNotification(notification)
                .putAllData(note.getData())
                .build();

        return firebaseMessaging.send(message);


    }

    public Message webpushMessage(Note note,String token) {
        // [START webpush_message]
        Message message = Message.builder()
                .setWebpushConfig(WebpushConfig.builder()
                        .setNotification(new WebpushNotification(
                                note.getSubject(),
                                note.getContent(),
                                note.getImage()))
                        .setFcmOptions(WebpushFcmOptions.withLink("https://facebook.com"))
                        .build())
                .setToken(token)
//                .setTopic("industry-tech")
                .build();
        // [END webpush_message]
        return message;
    }

    /*public Message allPlatformsMessage() {
        // [START multi_platforms_message]
        Message message = Message.builder()
                .setNotification(new Notification(
                        "$GOOG up 1.43% on the day",
                        "$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day."))
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(3600 * 1000)
                        .setNotification(AndroidNotification.builder()
                                .setIcon("stock_ticker_update")
                                .setColor("#f45342")
                                .build())
                        .build())
                .setApnsConfig(ApnsConfig.builder()
                        .setAps(Aps.builder()
                                .setBadge(42)
                                .build())
                        .build())
                .setTopic("industry-tech")
                .build();
        // [END multi_platforms_message]
        return message;
    }*/

    public Message apnsMessage() {
        // [START apns_message]
        Message message = Message.builder()
                .setApnsConfig(ApnsConfig.builder()
                        .putHeader("apns-priority", "10")
                        .setAps(Aps.builder()
                                .setAlert(ApsAlert.builder()
                                        .setTitle("$GOOG up 1.43% on the day")
                                        .setBody("$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.")
                                        .build())
                                .setBadge(42)
                                .build())
                        .build())
                .setTopic("industry-tech")
                .build();
        // [END apns_message]
        return message;
    }

    public Message androidMessage() {
        // [START android_message]
        Message message = Message.builder()
                .setAndroidConfig(AndroidConfig.builder()
                        .setTtl(3600 * 1000) // 1 hour in milliseconds
                        .setPriority(AndroidConfig.Priority.NORMAL)
                        .setNotification(AndroidNotification.builder()
                                .setTitle("$GOOG up 1.43% on the day")
                                .setBody("$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.")
                                .setIcon("stock_ticker_update")
                                .setColor("#f45342")
                                .build())
                        .build())
                .setTopic("industry-tech")
                .build();
        // [END android_message]
        return message;
    }
}
