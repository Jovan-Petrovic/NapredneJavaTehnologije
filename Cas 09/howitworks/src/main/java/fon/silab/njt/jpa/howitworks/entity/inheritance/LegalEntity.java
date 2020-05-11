/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.entity.inheritance;

import java.util.Objects;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author user
 */
@Entity
@DiscriminatorValue(value = "LEGAL")
public class LegalEntity extends BusinessPartnerEntity{
    private String uniqueLegalNumber;//maticni broj
    private String name;

    public LegalEntity() {
        super();
    }
    
    public LegalEntity(String uniqueLegalNumber, String name) {
        super();
        this.uniqueLegalNumber = uniqueLegalNumber;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniqueLegalNumber() {
        return uniqueLegalNumber;
    }

    public void setUniqueLegalNumber(String uniqueLegalNumber) {
        this.uniqueLegalNumber = uniqueLegalNumber;
    }

    @Override
    public String toString() {
        return "LegalEntity{" + "uniqueLegalNumber=" + uniqueLegalNumber + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.uniqueLegalNumber);
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LegalEntity other = (LegalEntity) obj;
        if (!Objects.equals(this.uniqueLegalNumber, other.uniqueLegalNumber)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
}
