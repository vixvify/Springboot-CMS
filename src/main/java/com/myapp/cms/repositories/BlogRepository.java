package com.myapp.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.cms.entities.Blog;

public interface BlogRepository extends JpaRepository<Blog, Object> {

}
