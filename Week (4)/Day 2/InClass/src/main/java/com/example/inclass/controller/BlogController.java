package com.example.inclass.controller;


import com.example.inclass.model.Blog;
import com.example.inclass.service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.spi.Resolution;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getBlogs() {
        List<Blog> blogs = blogService.getBlog();
        return ResponseEntity.status(200).body(blogs);
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("Can't add blog");
        }
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body("Blog add!");
    }

//    @PostMapping("/add-all")
//    public ResponseEntity addAllBlogs(@Valid @RequestBody Blog[] blogs, Errors errors) {
//        if(errors.hasErrors()) {
//            String message = errors.getFieldError().getDefaultMessage();
//            return ResponseEntity.status(400).body("Can't add blog");
//        }
//        blogService.addAllBlogs(blogs);
//        return ResponseEntity.status(200).body("All blogs add!");
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@PathVariable Integer id,@Valid @RequestBody Blog updateBlog, Errors errors) {
        if(errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("Can't add blog");
        }
        boolean isBlogUpdated = blogService.updateBlog(id,updateBlog);
        if(isBlogUpdated) {
            return ResponseEntity.status(200).body("Blog updated!");
        }
        return ResponseEntity.status(400).body("Can't update the blog, wrong id!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id) {
        boolean isBlogDeleted = blogService.deleteBlog(id);
        if (isBlogDeleted) {
            return ResponseEntity.status(200).body("Blog deleted!!");
        }
        return ResponseEntity.status(400).body("Can't delete the blog, Wrong Id!");
    }

}
