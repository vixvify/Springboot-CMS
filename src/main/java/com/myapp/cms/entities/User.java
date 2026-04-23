package com.myapp.cms.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue()
    private UUID id;

    private String email;
    private String password;
    private String username;
    private LocalDateTime created_at;

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs;
}
