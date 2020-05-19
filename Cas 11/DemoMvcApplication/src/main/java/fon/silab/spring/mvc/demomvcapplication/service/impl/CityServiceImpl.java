/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.spring.mvc.demomvcapplication.service.impl;

import fon.silab.spring.mvc.demomvcapplication.model.CityDto;
import fon.silab.spring.mvc.demomvcapplication.repository.CityRepository;
import fon.silab.spring.mvc.demomvcapplication.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KORISNIK
 */
@Service
public class CityServiceImpl implements CityService{

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void save(CityDto cityDto) {
        cityRepository.save(cityDto);
    }
    
}
