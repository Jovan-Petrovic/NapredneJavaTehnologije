/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.spring.mvc.demomvcapplication.formater;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CountryDto;
import fon.silab.njt.spring.mvc.demomvcapplication.service.CountryService;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

/**
 *
 * @author KORISNIK
 */
public class CountryDtoFormater implements Formatter<CountryDto>{

    private final CountryService countryService;
    
    @Autowired
    public CountryDtoFormater(CountryService countryService) {
        this.countryService = countryService;
    }
    
    
    
    @Override
    public String print(CountryDto countryDto, Locale locale) {
        return countryDto.toString();
    }

    @Override
    public CountryDto parse(String name, Locale locale) throws ParseException {
        System.out.println("======================================");
        System.out.println("CountryDtoFormater: country -> name " + name);
        return countryService.findByName(name);
    }
    
}
