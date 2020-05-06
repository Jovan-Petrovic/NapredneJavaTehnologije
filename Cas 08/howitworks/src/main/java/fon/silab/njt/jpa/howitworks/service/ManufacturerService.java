/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.service;

import fon.silab.njt.jpa.howitworks.entity.CityEntity;
import fon.silab.njt.jpa.howitworks.entity.ManufacturerEntity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class ManufacturerService {

    private final EntityManagerFactory emf;

    public ManufacturerService() {
        emf = Persistence.createEntityManagerFactory("JpaHowItWorksPU");
    }
//verzija 0    
//    public void save(ManufacturerEntity manufacturer){
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        em.persist(manufacturer);
//        em.getTransaction().commit();
//        em.close();
//    }

//verzija 1    
    public void save(ManufacturerEntity manufacturer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        //proveri da li postoji grad
        CityEntity cityEntity = em.find(CityEntity.class, manufacturer.getCity().getCode());
        if (cityEntity == null) {
            em.persist(manufacturer.getCity());
        } else {
            manufacturer.setCity(cityEntity);
        }
        em.persist(manufacturer);

        em.getTransaction().commit();
        em.close();
    }

    public ManufacturerEntity saveOrUpdate(ManufacturerEntity manufacturer) throws Exception {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            if (manufacturer.getId() != null) {
                //znaci da proizvodjac mora da postoji u bazi
                ManufacturerEntity entity = em.find(ManufacturerEntity.class, manufacturer.getId());
                //ako ne postoji, ne bi smeli da sacuvamo entitet
                if (entity == null) {
                    throw new Exception("Manufacturer with that ID does not exist!");
                }
            }
            ManufacturerEntity entity = em.merge(manufacturer);
            em.getTransaction().commit();

            return entity;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void saveOrUpdate(Long id, ManufacturerEntity manufacturer) {

    }

    public ManufacturerEntity findById(Long id) {
        EntityManager em = emf.createEntityManager();
        ManufacturerEntity entity = em.find(ManufacturerEntity.class, id);
        entity.getContactPersons().size();
        em.close();
        return entity;
    }

    public void delete(ManufacturerEntity manufacturer) throws Exception {
        EntityManager em = emf.createEntityManager();

        //ManufacturerEntity entity = em.merge(manufacturer);
        //em.remove(entity);
        try {
            ManufacturerEntity entity = em.find(ManufacturerEntity.class, manufacturer.getId());
            if (entity == null) {
                throw new Exception("Manufacturer with that ID does not exist!");
            }
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw e;
        } finally {
            em.close();
        }
    }
}
