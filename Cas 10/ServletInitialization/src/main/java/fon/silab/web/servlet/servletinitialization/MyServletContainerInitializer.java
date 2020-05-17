/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.silab.web.servlet.servletinitialization;

import fon.silab.web.servlet.servlet.ServletOne;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author user
 */
@HandlesTypes({HttpServlet.class})
public class MyServletContainerInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("**************************************************");
        System.out.println("MyServletContainerInitializer - onStartup");

        for (Class<?> currentClass : c) {
            System.out.println(currentClass);
            System.out.println(currentClass.getCanonicalName());
            System.out.println(currentClass.getSimpleName());
            try{
            Class servletClass = Class.forName(currentClass.getTypeName());
            //dinamicki registruj servlet
            ServletRegistration.Dynamic servlet = ctx.addServlet(currentClass.getSimpleName(), servletClass);
            servlet.addMapping("/"+currentClass.getSimpleName().toLowerCase());
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }
    }

}
