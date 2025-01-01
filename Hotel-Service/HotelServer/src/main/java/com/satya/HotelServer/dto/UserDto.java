package com.satya.HotelServer.dto;

import com.satya.HotelServer.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String name;
    private UserRole userRole;
}
