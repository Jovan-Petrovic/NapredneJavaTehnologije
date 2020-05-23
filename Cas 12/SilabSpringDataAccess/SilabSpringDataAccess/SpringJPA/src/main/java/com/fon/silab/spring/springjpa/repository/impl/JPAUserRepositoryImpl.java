/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fon.silab.spring.springjpa.repository.impl;

import com.fon.silab.spring.springjpa.domain.User;
import com.fon.silab.spring.springjpa.repository.UserRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 *
 * @author Korisnik
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class JPAUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    //@Transactional(propagation = Propagation.NEVER)//bez
    //@Transactional(propagation = Propagation.SUPPORTS)//ako postoi u okviru nje, ako ne bez
    @Transactional(propagation = Propagation.REQUIRED)//ako postoi u okviru nje, ako ne bez
    @Override
    public List<User> getAll() {
        System.out.println("TransactionSynchronizationManager.isActualTransactionActive(): "+TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("TransactionAspectSupport.currentTransactionStatus(): "+ TransactionAspectSupport.currentTransactionStatus().isNewTransaction());
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        }

        System.out.println("com.fon.silab.spring.springjpa.repository.impl.UserRepositoryImpl.getAll()");
        String query = "select u from User u";
        return entityManager.createQuery(query, User.class).getResultList();
    }

    @Override
    public User getById(Long id) {
        System.out.println("com.fon.silab.spring.springjpa.repository.impl.UserRepositoryImpl.getById()");
        return entityManager.find(User.class, id);
    }

    @Override
    public void add(User user) {
        System.out.println("com.fon.silab.spring.springjpa.repository.impl.UserRepositoryImpl.add()");
        entityManager.persist(user);
    }

}
