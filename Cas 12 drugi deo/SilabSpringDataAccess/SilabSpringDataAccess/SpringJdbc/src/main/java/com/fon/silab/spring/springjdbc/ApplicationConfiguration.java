/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fon.silab.spring.springjdbc;

import com.fon.silab.spring.springjdbc.config.DatabaseConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Korisnik
 */

@Configuration
@Import(DatabaseConfiguration.class)
@ComponentScan(basePackages={"com.fon.silab.spring.springjdbc.repository",
                             "com.fon.silab.spring.springjdbc.service"})
@EnableTransactionManagement
public class ApplicationConfiguration {
   
    
}
