/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.spring.mvc.demomvcapplication.model;

import java.io.Serializable;

/**
 *
 * @author KORISNIK
 */
public class CityDto implements Serializable{
    private Long number;
    private String name;

    public CityDto() {
    }

    public CityDto(Long number, String name) {
        this.number = number;
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CityDto{" + "number=" + number + ", name=" + name + '}';
    }
    
    
}
