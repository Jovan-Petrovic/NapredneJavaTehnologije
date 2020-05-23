package fon.silab.njt.spring.mvc.demomvcapplication.validator;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CityDto;
import fon.silab.njt.spring.mvc.demomvcapplication.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CityValidator implements Validator {

    private final CityService cityService;
    
    @Autowired
    public CityValidator(CityService cityService) {
        this.cityService = cityService;
    }
    
    
    
    @Override
    public boolean supports(Class<?> clazz) {
        return CityDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CityDto cityDto = (CityDto) target;

        System.out.println("Validating city: " + cityDto);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "cityDto.name.empty", "cityDto.name.empty = Default message");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "cityDto.number.empty", "cityDto.number.empty = Default message");

        if (errors.hasErrors()) {
            return;
        }

        if (cityDto.getName().length() < 2) {
            errors.rejectValue("name", "cityDto.name.size", "cityDto.name.size = Default message");
        }
        
        // proveri da li postoji grad sa zadatim postanskim brojem
        if (cityService.findByNumber(cityDto.getNumber())!=null) errors.rejectValue("name", "valid.cityDto.exist", "Grad vec postoji");
    }
}
