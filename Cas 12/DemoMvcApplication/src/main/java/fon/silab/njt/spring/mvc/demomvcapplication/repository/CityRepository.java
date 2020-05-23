/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.spring.mvc.demomvcapplication.repository;

import fon.silab.njt.spring.mvc.demomvcapplication.dto.CityDto;
import java.util.List;

/**
 *
 * @author laptop-02
 */
public interface CityRepository {
    void save(CityDto city);
    List<CityDto> getAll();
    CityDto findByNumber(Long numberId);
    void delete(Long numberId);
}
