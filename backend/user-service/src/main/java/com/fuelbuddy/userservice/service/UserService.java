package com.fuelbuddy.userservice.service;

import com.fuelbuddy.userservice.entity.User;
import com.fuelbuddy.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User signup(String email, String password, String name) {

        // 1. Check if email already exists
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already registered: " + email);
        }

        // 2. Hash the password (NEVER store plain text!)
        String hashedPassword = passwordEncoder.encode(password);

        // 3. Create the user
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(hashedPassword);
        newUser.setName(name);

        // 4. Save to database
        return userRepository.save(newUser);
    }
}