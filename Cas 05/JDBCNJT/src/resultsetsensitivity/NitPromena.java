/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultsetsensitivity;

import db.Util;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cartman
 */
public class NitPromena extends Thread{

    @Override
    public void run() {
        try {
            Class.forName(Util.getInstance().getDriver());
            String url = Util.getInstance().getURL();
            String user = Util.getInstance().getUser();
            String password = Util.getInstance().getPassword();
            
            Connection connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
            
            Statement statement=connection.createStatement();
            statement.executeUpdate("UPDATE Proizvod SET naziv='naziv u"+new SimpleDateFormat("hh:mm:ss").format(new Date())+"' WHERE IDProizvod=22");
            statement.close();
            connection.commit();
            System.out.println("promena");
            connection.close();
            
        } catch (Exception ex) {
            Logger.getLogger(NitPromena.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
