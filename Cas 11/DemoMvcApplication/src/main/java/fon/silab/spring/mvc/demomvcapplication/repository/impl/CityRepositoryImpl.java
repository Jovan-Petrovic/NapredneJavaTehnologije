/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.spring.mvc.demomvcapplication.repository.impl;

import fon.silab.spring.mvc.demomvcapplication.model.CityDto;
import fon.silab.spring.mvc.demomvcapplication.repository.CityRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author KORISNIK
 */
@Component
public class CityRepositoryImpl implements CityRepository{
    List<CityDto> cities;

    public CityRepositoryImpl() {
        cities = new ArrayList<>();
    }

    @Override
    public void save(CityDto cityDto) {
        cities.add(cityDto);
    }
    
    
}
