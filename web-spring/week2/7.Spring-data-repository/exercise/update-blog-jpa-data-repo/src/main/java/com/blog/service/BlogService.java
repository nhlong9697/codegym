package com.blog.service;

import com.blog.model.Blog;
import com.blog.model.Category;

import java.util.List;

public interface BlogService {
    Iterable<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Iterable<Blog> findAllByCategory(Category category);

    Iterable<Blog> findByTitleContains(String title);
}
