/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.entity.inheritance;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author user
 */
@Entity
@Table(name = "BUSINESS_PARTNER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BUSINESS_PARTNER_TYPE")
public abstract class BusinessPartnerEntity implements  Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "GEN_BUSINESS_PARTNER")
    @TableGenerator(name = "GEN_BUSINESS_PARTNER", table = "GEN_ID",
            pkColumnName = "PK_GEN", valueColumnName = "VALUE_GEN",
            pkColumnValue = "TBL_BUSINESS_PARTNER", initialValue = 0, allocationSize = 1)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
