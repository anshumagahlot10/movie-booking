package com.mbs.movie_booking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.movie_booking.dto.LoginRequest;
import com.mbs.movie_booking.dto.LoginResponse;
import com.mbs.movie_booking.service.AuthService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @CookieValue(name = "access_token", required = false) String accessToken,
            @CookieValue(name = "refresh_token", required = false) String refreshToken,
            @RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest, accessToken, refreshToken);
    }

    // @PostMapping("/refresh")
    // public ResponseEntity<LoginResponse> refreshToken(@CookieValue(name = "refresh_token", required = true) String refreshToken) {
    //     return authService.refresh(refreshToken);
    // }

    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshToken(@RequestHeader(value = "Refresh-Token", required = true) String refreshToken) {
        return authService.refresh(refreshToken);
}

   
    // @PostMapping("/logout")
    // public ResponseEntity<LoginResponse> logout(
    //         @CookieValue(name = "access_token", required = false) String accessToken,
    //         @CookieValue(name = "refresh_token", required = false) String refreshToken) {
    //     return authService.logout(accessToken, refreshToken);
    // }

    //  @PreAuthorize("isAuthenticated()")
    // @GetMapping("/info")
    // public ResponseEntity<UserLoggedDto> userLoggedInfo() {
    //     return ResponseEntity.ok(authService.getUserLoggedInfo());
    // }
}
