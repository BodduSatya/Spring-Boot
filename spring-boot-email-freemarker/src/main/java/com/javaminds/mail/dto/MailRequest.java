package com.javaminds.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MailRequest {
    private String name;
    private String subject;
    private String from;
    private String to;
    private String cc;
    private String bcc;

}
