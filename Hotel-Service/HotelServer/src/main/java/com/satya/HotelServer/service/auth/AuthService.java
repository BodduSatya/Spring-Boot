package com.satya.HotelServer.service.auth;

import com.satya.HotelServer.dto.SignupRequest;
import com.satya.HotelServer.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
}
