/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.service;

import fon.silab.njt.jpa.howitworks.entity.ProductCategoryEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dusan
 */
public class ProductCategoryService {

    private final EntityManagerFactory emf;

    public ProductCategoryService() {
        emf = Persistence.createEntityManagerFactory("JpaHowItWorksPU");
    }

    public ProductCategoryEntity save(ProductCategoryEntity productCategory) {
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        ProductCategoryEntity entity = em.merge(productCategory);
        System.out.println("ID: " + entity.getId());
        em.getTransaction().commit();
        System.out.println("ID: " + entity.getId());
        em.close();
        
        return entity;

    }
}
