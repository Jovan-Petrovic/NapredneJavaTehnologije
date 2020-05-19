/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.spring.mvc.demomvcapplication.validator;

import fon.silab.spring.mvc.demomvcapplication.model.CityDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author KORISNIK
 */
@Component
public class CityValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return CityDto.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CityDto cityDto = (CityDto) o;
        System.out.println("Validate object: " + cityDto);
        
        ValidationUtils.rejectIfEmpty(errors, "number", null, "Number is required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "Name is required!");
    
        if(errors.hasErrors()) return;
        
        if(cityDto.getName().length() < 2) {
            errors.rejectValue("name", null, "Name length for name must be greater than 1 character");
        }
    }
    
}
