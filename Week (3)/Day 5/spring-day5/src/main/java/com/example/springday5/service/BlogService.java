package com.example.springday5.service;


import com.example.springday5.pojo.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// service classes handle the logic operation.
@Service
public class BlogService {

    ArrayList<Blog> blogs = new ArrayList<>();

    public ArrayList<Blog> getBlogs() {
        return blogs;
    }

    public void addBlog(Blog blog) {
        blogs.add(blog);
    }

    public boolean updateBlog(int id, Blog updateBlog) {
        for (int i = 0; i <= blogs.size(); i++) {
            if(blogs.get(i).getId() == id) {
                blogs.set(i, updateBlog);
                return true;
            }
        }
        return false;
    }

    public boolean removeBlog(int id) {
        for (int i = 0; i < blogs.size(); i++) {
            if(blogs.get(i).getId() == id) {
                blogs.remove(i);
                return true;
            }
        }
        return false;
    }
}
