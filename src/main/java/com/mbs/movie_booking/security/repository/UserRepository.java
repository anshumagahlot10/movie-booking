package com.mbs.movie_booking.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbs.movie_booking.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}