/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.spring.mvc.demomvcapplication.config;

import fon.silab.spring.mvc.demomvcapplication.controler.CompanyController;
import fon.silab.spring.mvc.demomvcapplication.controler.HomeController;
import fon.silab.spring.mvc.demomvcapplication.controler.UserController;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author user
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "fon.silab.spring.mvc.demomvcapplication.controler",
    "fon.silab.spring.mvc.demomvcapplication.service",
    "fon.silab.spring.mvc.demomvcapplication.repository",
    "fon.silab.spring.mvc.demomvcapplication.validator"
    
})
public class DemoWebApplicationContextConfig {
    
    //konfiguracija view resolver-a
    @Bean
    public ViewResolver createViewResolver(){
        InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return  viewResolver;
    }
}
