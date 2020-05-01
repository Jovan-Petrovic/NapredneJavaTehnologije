/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.math.BigDecimal;
import java.util.List;
import model.Proizvod;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtility;

/**
 *
 * @author KORISNIK
 */
public class Start {
    
    public static void main(String[] args) {
        Start start = new Start();
        Proizvod proizvod = new Proizvod(777, "Ruski kvas", new BigDecimal(59));
        Proizvod proizvod1 = new Proizvod(888, "Plazma", new BigDecimal(85));
        Proizvod proizvod2 = new Proizvod(999, "Najlepse zelje", new BigDecimal(102));
              
//        start.saveOrUpdate(proizvod);
//        start.insert(proizvod1);
        
//        Proizvod p = start.retreive(777l);
//        System.out.println(p);

//        start.update(proizvod);
        
//        List<Proizvod> proizvodi = start.listProizvod();
//        for (Proizvod proizvod3 : proizvodi) {
//            System.out.println(proizvod3);
//        }

//        List<Proizvod> proizvodi = start.criteriaProizvod();
//        for (Proizvod proizvod3 : proizvodi) {
//            System.out.println(proizvod3);
//        }

//        Proizvod p = start.loadByExample();
//        System.out.println(p);

        List<Proizvod> proizvodi = start.listProizvodSQL();
        for (Proizvod proizvod3 : proizvodi) {
            System.out.println(proizvod3);
        }
    }

    private Proizvod retreive(long i) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Proizvod p = session.load(Proizvod.class, i); // vraca Proizvod ili baca exception
//        Proizvod p = session.get(Proizvod.class, i); // vraca Proizvod ili null    
        session.getTransaction().commit();
        return p;
    }

    private void saveOrUpdate(Proizvod proizvod) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.saveOrUpdate(proizvod);
        
        session.getTransaction().commit();
        session.close();
    }

    private long insert(Proizvod proizvod) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        
        long id = (long) session.save(proizvod);
        
        session.getTransaction().commit();
        session.close();
        return id;
    }

    private void update(Proizvod proizvod) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(proizvod);
        session.getTransaction().commit();
        session.close();
    }

    private List<Proizvod> listProizvod() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Proizvod");
        List<Proizvod> lista = query.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

    private List<Proizvod> criteriaProizvod() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria crit = session.createCriteria(Proizvod.class);
        // postavlja maksimalni broj procitanih slogova
        crit.setMaxResults(2);
        // uvodi kriterijum da naziv proizvoda treba da pocinje slovom 'N'
        crit.add(Restrictions.like("naziv", "N%"));
        List lista = crit.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }

    private Proizvod loadByExample() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Proizvod p = new Proizvod();
        p.setCena(new BigDecimal(59));
        Criteria crit = session.createCriteria(Proizvod.class);
        crit.add(Example.create(p));
        p = (Proizvod) crit.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return p;
    }

    private List<Proizvod> listProizvodSQL() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "select {proizvod.*} from Proizvod proizvod";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity("proizvod", Proizvod.class);
        List lista = query.list();
        session.getTransaction().commit();
        session.close();
        return lista;
    }
}
