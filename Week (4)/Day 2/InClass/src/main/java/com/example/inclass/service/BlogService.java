package com.example.inclass.service;


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

    public void addBlog(Blog newBlog) {
        blogRepository.save(newBlog);
    }

    public void addAllBlogs(List<Blog> newBlogs) {
        blogRepository.saveAll(newBlogs);
    }
    public boolean updateBlog(Integer id, Blog updateBlog) {
        Blog oldBlog = blogRepository.getById(id);
        if(oldBlog == null) {
            return false;
        }
//        updateBlog.getId();
        oldBlog.setTitle(updateBlog.getTitle());
        oldBlog.setBody(updateBlog.getBody());
        blogRepository.save(oldBlog);
        return true;
    }

    public boolean deleteBlog(Integer id) {
        Blog blogId = blogRepository.getById(id);
        if(blogId == null) {
            return false;
        }
        blogRepository.delete(blogId);
        return true;
    }


}
