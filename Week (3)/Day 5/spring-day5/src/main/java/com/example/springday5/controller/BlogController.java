package com.example.springday5.controller;


import com.example.springday5.pojo.Blog;
import com.example.springday5.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    // this code, dependency inject the service to enables using the class
    // one method, blow.  OR using  @RequiredArgsConstructor annotation and make BlogService -> private final BlogService

      private final BlogService blogService;

//    BlogService blogService;
//    public BlogController(BlogService blogService) {
//        this.blogService = blogService;
//    }

    @GetMapping("/get")
    public ResponseEntity getBlog() {
        ArrayList<Blog> blog = blogService.getBlogs();
        return ResponseEntity.status(200).body(blog);
    }


    @PostMapping("add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog newBlog, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        blogService.addBlog(newBlog);
        return ResponseEntity.status(200).body("Blog added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBlog(@PathVariable int id, @Valid @RequestBody Blog updateBlog, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = blogService.updateBlog(id, updateBlog);
        if(isUpdated) {
            return ResponseEntity.status(200).body("Blog updated!");
        }
        return ResponseEntity.status(400).body("Can't update, blog not found");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable int id) {
        boolean isDeleted = blogService.removeBlog(id);
        if(isDeleted) {
            return ResponseEntity.status(200).body("Blog deleted!");
        }
        return ResponseEntity.status(400).body("Can't delete, blog not found");
    }
 }
