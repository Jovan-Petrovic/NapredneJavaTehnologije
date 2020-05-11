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
@DiscriminatorValue("NATURAL")
public class NaturalEntity extends BusinessPartnerEntity{
    private String uniqueNaturalNumber;
    private String firstname;
    private String lastname;

    public NaturalEntity() {
    }

    public NaturalEntity(String uniqueNaturalNumber, String firstname, String lastname) {
        this.uniqueNaturalNumber = uniqueNaturalNumber;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUniqueNaturalNumber() {
        return uniqueNaturalNumber;
    }

    public void setUniqueNaturalNumber(String uniqueNaturalNumber) {
        this.uniqueNaturalNumber = uniqueNaturalNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "NaturalEntity{" + "uniqueNaturalNumber=" + uniqueNaturalNumber + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.uniqueNaturalNumber);
        hash = 73 * hash + Objects.hashCode(this.firstname);
        hash = 73 * hash + Objects.hashCode(this.lastname);
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
        final NaturalEntity other = (NaturalEntity) obj;
        if (!Objects.equals(this.uniqueNaturalNumber, other.uniqueNaturalNumber)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        return true;
    }
    
}
