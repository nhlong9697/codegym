package com.picture.repository;

import com.picture.model.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICommentRepository extends PagingAndSortingRepository<Comment, Long> {
}
