package fon.silab.njt.spring.mvc.demomvcapplication.service;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CountryDto;
import java.util.List;

public interface CountryService {
    List<CountryDto> getAll();
    CountryDto findByName(String shortName);
}
