package com.mbs.movie_booking.service;

import org.springframework.http.ResponseEntity;

import com.mbs.movie_booking.dto.LoginRequest;
import com.mbs.movie_booking.dto.LoginResponse;

public interface AuthService {
  ResponseEntity<LoginResponse> login(LoginRequest loginRequest, String accessToken, String refreshToken);

  // ResponseEntity<LoginResponse> logout(String accessToken, String refreshToken);

  ResponseEntity<LoginResponse> refresh(String refreshToken);



}
