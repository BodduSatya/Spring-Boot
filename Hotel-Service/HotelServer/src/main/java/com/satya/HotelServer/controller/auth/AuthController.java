package com.satya.HotelServer.controller.auth;

import com.satya.HotelServer.dto.AuthenticationRequest;
import com.satya.HotelServer.dto.AuthenticationResponse;
import com.satya.HotelServer.dto.SignupRequest;
import com.satya.HotelServer.dto.UserDto;
import com.satya.HotelServer.entity.User;
import com.satya.HotelServer.repository.UserRepository;
import com.satya.HotelServer.service.auth.AuthService;
import com.satya.HotelServer.service.jwt.UserService;
import com.satya.HotelServer.util.JwtUtil;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
        try {
            UserDto createdUser = authService.createUser(signupRequest);
            return new ResponseEntity<>(createdUser, HttpStatus.OK);
        }catch (EntityExistsException e) {
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
        }catch (Exception e) {
            return new ResponseEntity<>("User not created, come again later", HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/login")
    public AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        }catch (BadCredentialsException e) {
            throw new BadCredentialsException("Incorrect username or password ");
        }

        final UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
        Optional<User> optionalUser = userRepository.findFirstByEmail(userDetails.getUsername());
        final String jwtToken = jwtUtil.generateToken(userDetails);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        if(optionalUser.isPresent()) {
            authenticationResponse.setToken(jwtToken);
            authenticationResponse.setUserId(optionalUser.get().getId());
            authenticationResponse.setUserRole(optionalUser.get().getUserRole());
        }
        return authenticationResponse;
    }
}
