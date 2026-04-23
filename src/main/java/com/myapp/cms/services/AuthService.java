package com.myapp.cms.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myapp.cms.entities.User;
import com.myapp.cms.repositories.AuthRepository;

@Service
public class AuthService {
    private final AuthRepository authrepository;

    private final PasswordEncoder encoder;

    public AuthService(AuthRepository repo, PasswordEncoder encoder) {
        this.authrepository = repo;
        this.encoder = encoder;
    }

    public User createUser(User user) {
        LocalDateTime now = LocalDateTime.now();
        user.setCreated_at(now);
        user.setPassword(encoder.encode(user.getPassword()));
        return this.authrepository.save(user);
    }

    public List<User> getAllUsers() {
        return authrepository.findAll();
    }

    public User getUserById(UUID id) {
        return authrepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(User updateduser, UUID id) {
        User user = getUserById(id);
        user.setEmail(updateduser.getEmail());
        user.setPassword(encoder.encode(updateduser.getPassword()));
        user.setUsername(updateduser.getUsername());
        return this.authrepository.save(user);
    }

    public void deleteUser(UUID id) {
        authrepository.deleteById(id);
    }
}
