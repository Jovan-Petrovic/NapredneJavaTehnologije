/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.service;

import fon.silab.njt.jpa.howitworks.entity.inheritance.BusinessPartnerEntity;
import fon.silab.njt.jpa.howitworks.entity.inheritance.LegalEntity;
import fon.silab.njt.jpa.howitworks.entity.inheritance.NaturalEntity;
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
@Service
public class BusinessPartnerService {
    private final EntityManagerFactory emf;
     
    public BusinessPartnerService() {
        emf = Persistence.createEntityManagerFactory("JpaHowItWorksPU");
    }
    
    public BusinessPartnerEntity save(BusinessPartnerEntity businessPartner){
        EntityManager em = emf.createEntityManager();
        EntityTransaction entityTransaction = em.getTransaction();

        entityTransaction.begin();
        BusinessPartnerEntity entity = em.merge(businessPartner);
        entityTransaction.commit();

        em.close();
        return entity;
    }
    
    public List<BusinessPartnerEntity> findAll(){
        EntityManager em = emf.createEntityManager();
        List<BusinessPartnerEntity> result=em.createQuery
                ("select entity from BusinessPartnerEntity entity").getResultList();
        em.close();
        return result;
    }
    
    public List<NaturalEntity> getAllNatural(){
        EntityManager em = emf.createEntityManager();
        List<NaturalEntity> result = em.createQuery("select obj from NaturalEntity obj").getResultList();
        em.close();
        return result;
    }
    
    public List<BusinessPartnerEntity> findAllLegal(){
        EntityManager em = emf.createEntityManager();
        List<BusinessPartnerEntity> result=em.createQuery("select entity from BusinessPartnerEntity entity WHERE TYPE(entity)= :type").setParameter("type", LegalEntity.class).getResultList();
        em.close();
        return result;
    }
}
