/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.njt.jpa.howitworks.service.generics;

import java.util.List;

/**
 *
 * @author user
 * @param <T>
 */
public interface GenericService<T> {
    T save(T entity);
    List<T> findAll(Class clazz);
    //T findById(T entity...);
}
