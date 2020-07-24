package com.blog.repository;

import com.blog.model.Blog;
import com.blog.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
    Iterable<Blog> findAllByCategory(Category category);
    Iterable<Blog> findByTitleContains(String title);
}
