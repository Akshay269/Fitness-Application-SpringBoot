package com.project.fitness.service;

import java.time.Instant;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(RegisterRequest request) {

        //Builder pattern way
        User user=User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .createdAt(Instant.now().atZone(ZoneOffset.UTC).toLocalDateTime())
                .updatedAt(Instant.now().atZone(ZoneOffset.UTC).toLocalDateTime())
                .build();

        //Old way, not effecient and scalable
        // User user = new User(
        //         null,
        //         request.getEmail(),
        //         request.getPassword(),
        //         request.getFirstName(),
        //         request.getLastName(),
        //         Instant.now().atZone(ZoneOffset.UTC).toLocalDateTime(),
        //         Instant.now().atZone(ZoneOffset.UTC).toLocalDateTime(),
        //         List.of(),
        //         List.of()
        // );

        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    private UserResponse mapToResponse(User savedUser) {
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;
    }
}
