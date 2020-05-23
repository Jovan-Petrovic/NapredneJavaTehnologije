/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.spring.mvc.demomvcapplication.service.impl;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CountryDto;
import fon.silab.njt.spring.mvc.demomvcapplication.entity.Country;
import fon.silab.njt.spring.mvc.demomvcapplication.repository.CountryRepository;
import fon.silab.njt.spring.mvc.demomvcapplication.service.CountryService;
import java.util.ArrayList;
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
        List<Country> countries = countryRepository.getAll();
        // TODO: napraviti converter iz ENTITY u DTO
        List<CountryDto> countryDtos = new ArrayList<>();
        for (Country country : countries) {
            countryDtos.add(new CountryDto(country.getShortName(), country.getName()));
        }
        return countryDtos;
    }

    @Override
    public CountryDto findByName(String name) {
        // return  countryRepository.findByName(name);
        return new CountryDto();
    }
    
}
