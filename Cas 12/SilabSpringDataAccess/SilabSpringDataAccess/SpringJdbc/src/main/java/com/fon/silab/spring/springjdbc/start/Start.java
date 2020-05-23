/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fon.silab.spring.springjdbc.start;

import com.fon.silab.spring.springjdbc.ApplicationConfiguration;
import com.fon.silab.spring.springjdbc.domain.User;
import com.fon.silab.spring.springjdbc.service.UserService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Korisnik
 */
public class Start {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        UserService userService = context.getBean(UserService.class);

        //UserRepository userRepository = context.getBean(UserRepository.class);
        
        
        //User u = new User("zika", "zikic", "zika.zikic@gmail.com", "12321");
        //userService.add(u);
        //userRepository.add(u);
        
        //User usr = userService.getById(1l);
        //System.out.println(usr);

        List<User> users = userService.getAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
