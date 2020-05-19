/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.spring.mvc.demomvcapplication.repository;

import fon.silab.spring.mvc.demomvcapplication.model.CityDto;

/**
 *
 * @author KORISNIK
 */
public interface CityRepository {
    void save(CityDto cityDto);
}
