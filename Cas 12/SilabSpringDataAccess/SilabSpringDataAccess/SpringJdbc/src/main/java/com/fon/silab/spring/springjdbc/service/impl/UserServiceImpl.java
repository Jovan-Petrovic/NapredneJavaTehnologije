/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fon.silab.spring.springjdbc.service.impl;

import com.fon.silab.spring.springjdbc.domain.User;
import com.fon.silab.spring.springjdbc.repository.UserRepository;
import com.fon.silab.spring.springjdbc.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Korisnik
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    //@Autowired
    private final UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add(User user) {
        userRepository.add(user);
    }

}
