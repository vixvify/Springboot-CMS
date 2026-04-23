package com.myapp.cms.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.cms.entities.User;

public interface AuthRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
