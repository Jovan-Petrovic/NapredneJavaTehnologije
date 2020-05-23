/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fon.silab.spring.springjpa.start;

import com.fon.silab.spring.springjpa.ApplicationConfiguration;
import com.fon.silab.spring.springjpa.domain.User;
import com.fon.silab.spring.springjpa.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Korisnik
 */
@Component
public class Main {
    @Autowired
    private UserRepository userRepository;
    
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        Main main = context.getBean(Main.class);
        main.workWithRepository();
    }

    private void workWithRepository() {
        //user get all
        userGetAll();
    }

    private void userGetAll() {
        List<User> users = userRepository.getAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
