/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.spring.mvc.demomvcapplication.service.impl;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CountryDto;
import fon.silab.njt.spring.mvc.demomvcapplication.repository.CountryRepository;
import fon.silab.njt.spring.mvc.demomvcapplication.service.CountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author laptop-02
 */
@Service
public class CountryServiceImpl implements  CountryService{
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<CountryDto> getAll() {
        return countryRepository.getAll();
    }

    @Override
    public CountryDto findByName(String name) {
        return  countryRepository.findByName(name);
    }
    
}
