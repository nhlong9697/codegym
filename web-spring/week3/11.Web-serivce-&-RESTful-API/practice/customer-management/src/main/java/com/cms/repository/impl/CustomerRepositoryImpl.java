package com.cms.repository.impl;

import com.cms.model.Customer;
import com.cms.repository.ICustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c",
                Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = entityManager.createQuery("select case from Customer c where" +
                " c.id=:id", Customer.class);
        query.setParameter("id",id);
        try {
            return query.getSingleResult();
        } catch(NoResultException noResultException) {
            return null;
        }
    }

    @Override
    public void save(Customer model) {
        if(model.getId() != null) {
            entityManager.merge(model);
        } else {
            entityManager.persist(model);
        }
    }

    @Override
    public void remove(Long id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }
}
