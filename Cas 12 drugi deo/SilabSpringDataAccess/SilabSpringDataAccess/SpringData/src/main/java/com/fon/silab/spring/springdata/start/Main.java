/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fon.silab.spring.springdata.start;

import com.fon.silab.spring.springdata.ApplicationConfiguration;
import com.fon.silab.spring.springdata.domain.User;
import com.fon.silab.spring.springdata.service.UserService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Korisnik
 */
public class Main {

    public static void main(String[] args) {
       ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        UserService userService = context.getBean(UserService.class);

        List<User> users = userService.getAll();
        for (Object user : users) {
            System.out.println(user);
        }
    }
}
