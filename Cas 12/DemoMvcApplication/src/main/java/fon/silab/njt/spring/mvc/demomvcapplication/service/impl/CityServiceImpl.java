package fon.silab.njt.spring.mvc.demomvcapplication.service.impl;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CityDto;
import fon.silab.njt.spring.mvc.demomvcapplication.repository.CityRepository;
import fon.silab.njt.spring.mvc.demomvcapplication.service.CityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void save(CityDto cityDto) {
        cityRepository.save(cityDto);
    }

    @Override
    public List<CityDto> getAll() {
        return cityRepository.getAll();
    }

    @Override
    public CityDto findByNumber(Long numberId){
         return  cityRepository.findByNumber(numberId);
     }

    @Override
    public void delete(Long numberId) {
        cityRepository.delete(numberId);
    }
}
