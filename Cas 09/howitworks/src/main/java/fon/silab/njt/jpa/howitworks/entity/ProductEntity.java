/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author user
 */
@Entity
@Table(name = "PRODUCT")
public class ProductEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "GEN_PRODUCT")
    @TableGenerator(name = "GEN_PRODUCT", table = "GEN_ID",
            pkColumnName = "PK_GEN", valueColumnName = "VALUE_GEN",
            pkColumnValue = "TBL_PRODUCT", initialValue = 0, allocationSize = 1)
    private Long id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID")
    private ManufacturerEntity manufacturer;
    
    @ManyToMany
    @JoinTable(name = "PRODUCT_PRODUCT_CATEGORY",
            joinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_CATEGORY_ID",referencedColumnName = "ID" )
            )
    private List<ProductCategoryEntity> productCategories;

    public ProductEntity() {
        productCategories=new ArrayList<>();
    }
    //add
    public void addProductCategory(ProductCategoryEntity productCategory){
        productCategories.add(productCategory);
        productCategory.getProducts().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManufacturerEntity getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerEntity manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<ProductCategoryEntity> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<ProductCategoryEntity> productCategories) {
        this.productCategories = productCategories;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.manufacturer);
        hash = 67 * hash + Objects.hashCode(this.productCategories);
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
        final ProductEntity other = (ProductEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductEntity{" + "id=" + id + ", name=" + name + ", manufacturer=" + manufacturer + ", productCategories=" + productCategories + '}';
    }
    
}
