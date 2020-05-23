/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.spring.mvc.demomvcapplication.repository.impl;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CountryDto;
import fon.silab.njt.spring.mvc.demomvcapplication.repository.CountryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author laptop-02
 */
@Component
public class CountryRepositoryImpl implements CountryRepository {

    List<CountryDto> countries;

    public CountryRepositoryImpl() {
        countries = new ArrayList<CountryDto>() {
            {
                add(new CountryDto("SRB", "Srbija"));
                add(new CountryDto("FR", "Francuska"));
                add(new CountryDto("ES", "Spanija"));
            }
        };
    }

    @Override
    public List<CountryDto> getAll() {
        return countries;
    }

    @Override
    public CountryDto findByName(String name) {
        return countries.stream().filter(country -> name.equals(country.getName())).findAny().orElse(null);
    }
}
