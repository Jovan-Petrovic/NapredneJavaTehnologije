/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.service;

import fon.silab.njt.jpa.howitworks.entity.CityEntity;
import fon.silab.njt.jpa.howitworks.service.generics.impl.GenericServiceImpl;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dusan
 */
@Service
public class CityService extends GenericServiceImpl{
    private final EntityManagerFactory emf;
    public CityService() {
        emf = Persistence.createEntityManagerFactory("JpaHowItWorksPU");
    }

    public void saveOrUpdate(CityEntity city) {
        EntityManager em = emf.createEntityManager();
        CityEntity entity= em.find(CityEntity.class, city.getCode());
        em.getTransaction().begin();
        if (entity==null){
            System.out.println("City with code: "+city.getCode()+" does not exist!");
            em.persist(city);
        }  else{
            System.out.println("City with code: "+city.getCode()+" exists!");
           //azurirara
           entity.setName(city.getName());
        }
        em.getTransaction().commit();
        em.close();
    }
    
     public void update(CityEntity city) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CityEntity entity = em.merge(city);
        //ako nesto treba da uradim dodatno sa entity objektom
        em.getTransaction().commit();
        em.close();
    }
}
