package com.picture.service;


import com.picture.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICommentService {
    Iterable<Comment> findAll();

    Comment findOne(Long id);

    void save(Comment comment);

    void addLike(Long id);

    Page<Comment> findAll(Pageable pageable);
}
