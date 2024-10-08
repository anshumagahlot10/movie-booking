package com.mbs.movie_booking.service;

import org.springframework.stereotype.Service;

import com.mbs.movie_booking.models.User;
import com.mbs.movie_booking.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(String name,String username, String password,String email,String phone) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        
        User user = User.builder()
                .name(name)
                .username(username)
                .password(passwordEncoder.encode(password))
                .email(email)
                .phone(phone)
                .build();

        userRepository.save(user);
    }
}
