/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.service.generics.impl;

import fon.silab.njt.jpa.howitworks.entity.MyEntity;
import fon.silab.njt.jpa.howitworks.service.generics.GenericService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */

public class GenericServiceImpl implements GenericService<MyEntity>{
    private final EntityManagerFactory emf;
    
    public GenericServiceImpl(){
        emf = Persistence.createEntityManagerFactory("JpaHowItWorksPU");
    }
    
    @Override
    public MyEntity save(MyEntity entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        entityTransaction.begin();
        em.persist(entity);
        entityTransaction.commit();
        em.close();
        return entity;
    }

    @Override
    public List<MyEntity> findAll(Class clazz) {
         EntityManager em = emf.createEntityManager();
         List<MyEntity> result = em.createQuery("SELECT obj FROM "+clazz.getCanonicalName()+" obj").getResultList();         
         em.close();              
         return result;
    }
    
    //uraditi implentaciju findAll preko NativeQuery
    
}
