package com.myapp.cms.services;

import org.springframework.stereotype.Service;
import java.util.List;
import com.myapp.cms.entities.Blog;
import com.myapp.cms.repositories.BlogRepository;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
        Blog blog = getBlogById(id);
        blog.setName(updatedBlog.getName());
        blog.setContent(updatedBlog.getContent());
        blog.setAuthor(updatedBlog.getAuthor());
        return blogRepository.save(blog);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}