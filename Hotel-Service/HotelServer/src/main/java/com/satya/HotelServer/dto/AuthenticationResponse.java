package com.satya.HotelServer.dto;

import com.satya.HotelServer.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String token;
    private Long userId;
    private UserRole userRole;
}
