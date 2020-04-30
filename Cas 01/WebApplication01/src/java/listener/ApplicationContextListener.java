/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;
import servlet.ServletSum;

/**
 *
 * @author student1
 */
@WebListener
public class ApplicationContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("================ApplicationContextListener: contextInitialized==============================");
        ServletContext servletContext =  sce.getServletContext();
        servletContext.setAttribute("numbers", new ArrayList<>());
       
        
        //add servlet sum mapping
        ServletRegistration.Dynamic servletSum = servletContext.addServlet("ServletSum", ServletSum.class);
        servletSum.addMapping("/sum");
        servletSum.addMapping("/sumsum");
        
        
        System.out.println("============================================================================================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
}
