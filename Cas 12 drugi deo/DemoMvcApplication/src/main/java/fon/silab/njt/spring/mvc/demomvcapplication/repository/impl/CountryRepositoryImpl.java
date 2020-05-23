/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.spring.mvc.demomvcapplication.repository.impl;

import fon.silab.njt.spring.mvc.demomvcapplication.entity.Country;
import fon.silab.njt.spring.mvc.demomvcapplication.repository.CountryRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laptop-02
 */
@Component
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class CountryRepositoryImpl implements CountryRepository {

    @PersistenceContext
    EntityManager entityManager;
    
    public CountryRepositoryImpl() {
    }

    @Override
    public List<Country> getAll() {
        String query = "select c from Country c";
        return entityManager.createQuery(query, Country.class).getResultList();
    }

    @Override
    public Country findById(Long id) {
        return entityManager.find(Country.class, id);
    }
}
