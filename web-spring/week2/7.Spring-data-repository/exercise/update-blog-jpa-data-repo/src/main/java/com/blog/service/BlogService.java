package com.blog.service;

import com.blog.model.Blog;
import com.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Iterable<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Iterable<Blog> findAllByCategory(Category category);

    Iterable<Blog> findByTitleContains(String title);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
