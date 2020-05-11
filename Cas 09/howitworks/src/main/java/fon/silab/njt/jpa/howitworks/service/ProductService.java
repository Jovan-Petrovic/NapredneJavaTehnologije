/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.service;

import fon.silab.njt.jpa.howitworks.entity.ProductEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class ProductService {
    private final EntityManagerFactory emf;
    public ProductService() {
        emf = Persistence.createEntityManagerFactory("JpaHowItWorksPU");
    }

    public void save(ProductEntity product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        entityTransaction.begin();
        em.persist(product);
        entityTransaction.commit();

        em.close();
    }

    public ProductEntity update(ProductEntity product) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        entityTransaction.begin();
        ProductEntity entity = em.merge(product);
        entityTransaction.commit();

        em.close();
        return  entity;
    }
    
    public void deleteById(Long id){
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        
        ProductEntity entity = em.find(ProductEntity.class, id);
        if (entity!=null) em.remove(entity);
        
        entityTransaction.commit();
        em.close();
    }
}
