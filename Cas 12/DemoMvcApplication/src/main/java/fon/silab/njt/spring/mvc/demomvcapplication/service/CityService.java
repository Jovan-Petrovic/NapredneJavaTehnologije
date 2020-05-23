package fon.silab.njt.spring.mvc.demomvcapplication.service;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CityDto;
import java.util.List;

public interface CityService {
    void save(CityDto cityDto);
    List<CityDto> getAll();
    CityDto findByNumber(Long numberId);
    void delete(Long numberId);
}
