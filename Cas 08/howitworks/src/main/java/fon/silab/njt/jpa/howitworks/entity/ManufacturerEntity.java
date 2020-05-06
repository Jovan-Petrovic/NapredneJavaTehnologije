/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author user
 */
@Entity
@Table(name = "MANUFACTURER")
public class ManufacturerEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MANUFACTURER")
    @TableGenerator(name = "MANUFACTURER", table = "GEN_ID", 
            pkColumnName = "PK_GEN",valueColumnName = "VALUE_GEN",
            pkColumnValue = "TBL_MANUFACTURER",
            initialValue = 0, allocationSize = 1)
    private Long id;
    private String name;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "CITY_ID")//referencedColumnName = "CODE"
    private CityEntity city;
    
    @OneToMany(cascade = {CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "MANUFACTURER_ID",referencedColumnName = "ID")
    private List<ContactPersonEntity> contactPersons;
    
    public ManufacturerEntity() {
        contactPersons=new ArrayList<>();
    }

    public ManufacturerEntity(Long id, String name, CityEntity city) {
        this();
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public List<ContactPersonEntity> getContactPersons() {
        return contactPersons;
    }

    public void setContactPersons(List<ContactPersonEntity> contactPersons) {
        this.contactPersons = contactPersons;
    }

    @Override
    public String toString() {
        return "ManufacturerEntity{" + "id=" + id + ", name=" + name + ", city=" + city + ", contactPersons=" + contactPersons + '}';
    }

    public void addPerson(ContactPersonEntity contactPerson) {
        contactPerson.setManufacturerId(id);
        contactPersons.add(contactPerson);
    }
    
    
    
}
