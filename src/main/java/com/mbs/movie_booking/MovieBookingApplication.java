package com.mbs.movie_booking;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mbs.movie_booking.models.User;
import com.mbs.movie_booking.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MovieBookingApplication implements ApplicationRunner{

	private final UserRepository userRepository;
    // private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(MovieBookingApplication.class, args);
	}

	@Override
    public void run(ApplicationArguments args) throws Exception {
        createUsers();
    }

    public void createUsers() {
        if(!userRepository.findAll().isEmpty())
            return;

        User admin = User.builder()
                .userID(0)
                .username("admin")
                .password(passwordEncoder.encode("admin"))
				.email("admin@example.com") // Add email
                .name("Admin ") 
                .phone("123-456-7890")
                .build();

        User user = User.builder()
				.userID(0)
                .username("user")
                .password(passwordEncoder.encode("user"))
				.email("user@example.com") 
                .name(" User") 
                .phone("123-456-7890")
                .build();

        User manager = User.builder()
				.userID(0)
                .username("manager")
                .password(passwordEncoder.encode("manager"))
				.email("manager@example.com") 
                .name("Manager User") 
                .phone("123-456-7890")
                .build();

        userRepository.saveAll(List.of(user, admin, manager));
    }

}
