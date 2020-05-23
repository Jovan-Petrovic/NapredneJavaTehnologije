/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.spring.mvc.demomvcapplication.repository.impl;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CityDto;
import fon.silab.njt.spring.mvc.demomvcapplication.repository.CityRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 *
 * @author laptop-02
 */
@Component
public class CityRepositoryImpl implements CityRepository {

    List<CityDto> cities;

    public CityRepositoryImpl() {
        cities = new ArrayList<>();
    }

    @Override
    public void save(CityDto city) {
        cities.add(city);
    }

    @Override
    public List<CityDto> getAll() {
        return cities;
    }

    @Override
    public CityDto findByNumber(Long numberId) {
        CityDto cityDto = cities.stream().filter(city -> numberId.equals(city.getNumber())).findAny().orElse(null);
        return cityDto;
    }

    @Override
    public void delete(Long numberId) {
        cities.removeIf(e -> {
            System.out.println(e.getNumber()+" compare with "+numberId);
            return e.getNumber().equals(numberId);
        });
    }
}
