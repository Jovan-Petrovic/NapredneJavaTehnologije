/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fon.silab.spring.springjdbc.repository;

import com.fon.silab.spring.springjdbc.domain.User;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public interface UserRepository {
    List<User> getAll();
    User getById(Long id);
    void add(User user);
}
