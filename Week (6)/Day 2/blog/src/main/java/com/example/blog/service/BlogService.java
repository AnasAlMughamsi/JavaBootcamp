package com.example.blog.service;

import com.example.blog.api.ApiException;
import com.example.blog.model.Blog;
import com.example.blog.model.MyUser;
import com.example.blog.repository.BlogRepository;
import com.example.blog.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MyUserRepository myUserRepository;

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(Integer blog_id, Integer user_id) {
        Blog blog = blogRepository.findBlogById(blog_id);
        if(blog == null) {
            throw new ApiException("Blog not found!");
        }
        if(blog.getMyUser().getId() != user_id) {
            throw new ApiException("Sorry, you dont have the authority to get this blog");
        }

        return blog;
    }

    public void addBlog(Integer user_id, Blog blog) {
        MyUser myUser = myUserRepository.findMyUserById(user_id);
        if(myUser == null) {
            throw new ApiException("User not found!");
        }
        blog.setMyUser(myUser);
        blogRepository.save(blog);
    }


    public void updateBlog(Integer blog_id, Integer user_id, Blog updateBlog) {
        Blog blog = blogRepository.findBlogById(blog_id);
        MyUser myUser = myUserRepository.findMyUserById(user_id);

        if(blog == null) {
            throw new ApiException("Blog not found!");
        } else if(blog.getMyUser().getId() != user_id) {
            throw new ApiException("Sorry, you don't the right to edit this blog");
        }

        updateBlog.setId(blog_id);
        updateBlog.setMyUser(myUser);
        blogRepository.save(updateBlog);
    }

    public void deleteBlog(Integer blog_id, Integer user_id) {
        Blog blog = blogRepository.findBlogById(blog_id);
        if(blog == null) {
            throw new ApiException("Blog not found!");
        } else if(blog.getMyUser().getId() != user_id) {
            throw new ApiException("Sorry, you don't the right to delete this blog");
        }
        blogRepository.delete(blog);
    }
}
