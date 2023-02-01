package com.example.inclass.service;


import com.example.inclass.exception.ApiException;
import com.example.inclass.model.Blog;
import com.example.inclass.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> getBlog() {
        return blogRepository.findAll();
    }
    public Blog findByTitle(String title) {
        Blog blog = blogRepository.findBlogByTitle(title);
        if(blog == null) {
            throw new ApiException("Title not found!");
        }
        return blog;
    }

    public Blog searchByTitle(String title) {
        Blog blog = blogRepository.searchByTitle(title);
        if(blog == null) {
            throw new ApiException("Title not found!");
        }
        return blog;
    }

    public void addBlog(Blog newBlog) {
        blogRepository.save(newBlog);
    }

    public void updateBlog(Integer id, Blog updateBlog) {
        Blog oldBlog = blogRepository.findBlogById(id);
        if(oldBlog == null) {
            throw new ApiException("wrong id from service class");
//            return false;
        }
//        updateBlog.getId();
        oldBlog.setTitle(updateBlog.getTitle());
        oldBlog.setBody(updateBlog.getBody());
        blogRepository.save(oldBlog);
//        return true;
    }

    public void deleteBlog(Integer id) {
        Blog blogId = blogRepository.findBlogById(id);
        if(blogId == null) {
            throw new ApiException("Can't delete blog, wrong id from service class");
        }
        blogRepository.delete(blogId);
    }


}
