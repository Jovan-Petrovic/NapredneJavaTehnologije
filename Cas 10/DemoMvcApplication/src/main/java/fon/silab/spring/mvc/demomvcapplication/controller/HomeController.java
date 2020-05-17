/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.spring.mvc.demomvcapplication.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author KORISNIK
 */
public class HomeController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        System.out.println("*******************************************");
        System.out.println("************* HomeController **************");
        System.out.println("************* HandlerRequest **************");
        System.out.println("*******************************************");
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
    
}
