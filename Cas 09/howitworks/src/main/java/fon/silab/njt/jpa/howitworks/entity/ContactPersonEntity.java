/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "CONTACT_PERSON")
public class ContactPersonEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lasntname;
    @Column(name = "MANUFACTURER_ID")
    private Long manufacturerId;

    public ContactPersonEntity() {
    }

    public ContactPersonEntity(Long id, String firstname, String lasntname) {
        this.id = id;
        this.firstname = firstname;
        this.lasntname = lasntname;
    }

    public String getLasntname() {
        return lasntname;
    }

    public void setLasntname(String lasntname) {
        this.lasntname = lasntname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ContactPersonEntity{" + "id=" + id + ", firstname=" + firstname + ", lasntname=" + lasntname + ", manufacturerId=" + manufacturerId + '}';
    }

    public Long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
    
    
}
