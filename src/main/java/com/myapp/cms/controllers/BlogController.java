package com.myapp.cms.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.cms.entities.Blog;
import com.myapp.cms.services.BlogService;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    private final BlogService blogservice;

    public BlogController(BlogService blogservice) {
        this.blogservice = blogservice;
    }

    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return this.blogservice.createBlog(blog);
    }

    @GetMapping
    public List<Blog> getAllblogs() {
        return blogservice.getAllBlogs();
    }

    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable UUID id) {
        return blogservice.getBlogById(id);
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable UUID id, @RequestBody Blog blog) {
        return blogservice.updateBlog(id, blog);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable UUID id) {
        blogservice.deleteBlog(id);
    }
}
