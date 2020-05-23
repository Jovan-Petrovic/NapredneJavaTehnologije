package fon.silab.njt.spring.mvc.demomvcapplication.validator;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CityDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CityValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CityDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CityDto cityDto = (CityDto) target;

        System.out.println("Validating city: " + cityDto);

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "userDto.name.empty", "userDto.name.empty = Default message");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "userDto.number.empty", "userDto.number.empty = Default message");

        if (errors.hasErrors()) {
            return;
        }

        if (cityDto.getName().length() < 2) {
            errors.rejectValue("name", "userDto.name.size", "userDto.name.size = Default message");
        }
        
    }
}
