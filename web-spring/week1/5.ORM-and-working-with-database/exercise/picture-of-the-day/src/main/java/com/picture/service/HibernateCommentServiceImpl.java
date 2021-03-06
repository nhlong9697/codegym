package com.picture.service;
import com.picture.model.Comment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class HibernateCommentServiceImpl implements ICommentService {
    @PersistenceContext
    private static EntityManager entityManager;
    //run 1 time and comment the following
//    static {
//        try {
//            SessionFactory sessionFactory = new Configuration()
//                    .configure("hibernate.conf.xml")
//                    .buildSessionFactory();
//            sessionFactory.close();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public List<Comment> findAll() {
        String queryStr = "SELECT c FROM Comment AS c";
        Query query = entityManager.createQuery(queryStr);
        return query.getResultList();
    }

    @Override
    public Comment findOne(Long id) {
        String queryStr = "SELECT c FROM Comment AS c WHERE c.id " +
                "= :id";
        TypedQuery<Comment> query = entityManager.createQuery(queryStr, Comment.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Comment comment) {
        if (comment.getId() != null) {
            entityManager.merge(comment);
        } else {
            entityManager.persist(comment);
        }
    }

    @Override
    public void addLike(Long id) {
        Comment comment = findOne(id);
        comment.setLikes(comment.getLikes() + 1);
        save(comment);
    }

}
