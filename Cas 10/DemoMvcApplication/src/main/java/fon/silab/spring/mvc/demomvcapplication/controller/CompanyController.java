/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.spring.mvc.demomvcapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author KORISNIK
 */
@Controller
public class CompanyController {
    @RequestMapping(value = "/company/home", method = RequestMethod.GET)
    public String home() {
        System.out.println("This is home method");
        return "company/home";
    }
    
    @GetMapping(value = "/company/home/home")
    public String anotherHome() {
        System.out.println("This is another home method");
        return "company/home";
    }
}
