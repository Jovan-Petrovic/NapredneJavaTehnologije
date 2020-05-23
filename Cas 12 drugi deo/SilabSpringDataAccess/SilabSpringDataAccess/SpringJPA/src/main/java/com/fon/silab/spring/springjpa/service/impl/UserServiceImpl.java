/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fon.silab.spring.springjpa.service.impl;

import com.fon.silab.spring.springjpa.domain.User;
import com.fon.silab.spring.springjpa.repository.UserRepository;
import com.fon.silab.spring.springjpa.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Korisnik
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    public UserServiceImpl() {
    }
    
    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void add(User user) {
        userRepository.add(user);
    }
    
}
