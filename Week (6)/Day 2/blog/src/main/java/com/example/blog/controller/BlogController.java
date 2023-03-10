package com.example.blog.controller;

import com.example.blog.api.ApiResponse;
import com.example.blog.model.Blog;
import com.example.blog.model.MyUser;
import com.example.blog.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return ResponseEntity.status(HttpStatus.OK).body(blogs);
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addBlog(@AuthenticationPrincipal MyUser myUser, @Valid @RequestBody Blog blog) {
        blogService.addBlog(myUser.getId(), blog);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Blog added ", 200));
    }

    @PutMapping("/update/{blog_id}")
    public ResponseEntity<ApiResponse> updateBlog(@AuthenticationPrincipal MyUser myUser, @Valid @RequestBody Blog blog, @PathVariable Integer blog_id) {
        blogService.updateBlog(blog_id, myUser.getId(), blog);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Blog updated! ", 200));
    }

    @DeleteMapping("/delete/{blog_id}")
    public ResponseEntity<ApiResponse> deleteBlog(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer blog_id) {
        blogService.deleteBlog(blog_id, myUser.getId());
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Blog deleted!", 200));
    }
}
