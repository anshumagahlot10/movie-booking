package com.mbs.movie_booking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.movie_booking.DTO.UserRegister;
import com.mbs.movie_booking.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody UserRegister userRegister) {
        userService.registerUser(
            userRegister.getName(),
            userRegister.getUsername(), 
            userRegister.getPassword(), 
            userRegister.getEmail(),
            userRegister.getPhone());
        return ResponseEntity.ok("User registered successfully");
    }
}
