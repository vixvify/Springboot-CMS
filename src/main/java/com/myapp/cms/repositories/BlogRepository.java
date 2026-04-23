package com.myapp.cms.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.cms.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, UUID> {

}
