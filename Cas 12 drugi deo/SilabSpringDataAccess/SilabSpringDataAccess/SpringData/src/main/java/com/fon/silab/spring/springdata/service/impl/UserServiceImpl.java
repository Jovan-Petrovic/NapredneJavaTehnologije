/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fon.silab.spring.springdata.service.impl;

import com.fon.silab.spring.springdata.domain.User;
import com.fon.silab.spring.springdata.repository.UserRepository;
import com.fon.silab.spring.springdata.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Korisnik
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    public UserServiceImpl() {
    }
    
    @Override
    public List<User> getAll() {
        //return userRepository.getAll();
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }
    
}
