package com.mbs.movie_booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbs.movie_booking.models.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
}
