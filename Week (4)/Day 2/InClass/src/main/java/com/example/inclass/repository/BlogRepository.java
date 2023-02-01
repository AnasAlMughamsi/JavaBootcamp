package com.example.inclass.repository;

import com.example.inclass.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

    Blog findBlogByTitle(String title);
    Blog findBlogById(Integer id);
    @Query("select blog from Blog blog where blog.title=?1")
    Blog searchByTitle(String title);

}
