package com.picture.service;
import com.picture.model.Comment;
import com.picture.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findOne(Long id) {
        return commentRepository.findOne(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void addLike(Long id) {
        Comment comment = commentRepository.findOne(id);
        comment.setLikes(comment.getLikes() + 1);
        save(comment);
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
       return commentRepository.findAll(pageable);
    }
}
