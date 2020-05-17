/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.spring.mvc.demomvcapplication.config;

import fon.silab.spring.mvc.demomvcapplication.controller.CompanyController;
import fon.silab.spring.mvc.demomvcapplication.controller.HomeController;
import fon.silab.spring.mvc.demomvcapplication.controller.UserController;
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
 * @author KORISNIK
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "fon.silab.spring.mvc.demomvcapplication.controller"
})
public class DemoWebApplicationContextConfig {
    // konfigurisanje Handler mapper-a
    @Bean
    BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
        return new BeanNameUrlHandlerMapping();
    }
    @Bean(name = {"/home", "/home/home"})
    HomeController createHomeController() {
        HomeController homeController = new HomeController();
        return homeController;
    }
    
    @Bean
    public SimpleUrlHandlerMapping createSimpleUrlHandlerMapping() {
        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        Map<String, Object> urlMap = new HashMap<>();
        urlMap.put("/user", createUserController());
        urlMap.put("/user/home", createUserController());
        urlMap.put("/home", createUserController());
        simpleUrlHandlerMapping.setUrlMap(urlMap);
        return simpleUrlHandlerMapping;
    }
    @Bean
    UserController createUserController() {
        return new UserController();
    }
    
    // EnableWebMvc create RequestMappingHandlerMapping bean
//    @Bean
//    public RequestMappingHandlerMapping createMappingHandlerMapping() {
//        return new RequestMappingHandlerMapping();
//    }
    
//    @Bean
//    public CompanyController createCompanyController() {
//        return new CompanyController();
//    }
    
    // konfiguracija view resolver-a
    @Bean
    public ViewResolver createViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}