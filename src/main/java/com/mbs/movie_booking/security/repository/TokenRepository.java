package com.mbs.movie_booking.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbs.movie_booking.models.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByValue(String token);
}

