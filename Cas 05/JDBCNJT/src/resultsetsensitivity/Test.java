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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Proizvod;

/**
 *
 * @author Cartman
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, InterruptedException {
        Class.forName(Util.getInstance().getDriver());
        String url = Util.getInstance().getURL();
        String user = Util.getInstance().getUser();
        String password = Util.getInstance().getPassword();

        Connection connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        
        //Aktuelna verzija MySQL drajvera ne podržava različite tipove result set-a, osim TYPE_SCROLL_SENSITIVE! 
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        ResultSet rs=statement.executeQuery("SELECT p.IDPROIZVOD AS idproizvod, p.NAZIV AS naziv, p.CENA AS cena FROM Proizvod p");
        statement.setFetchSize(1);
        while(rs.next()){
            Proizvod proizvod=new Proizvod();
            proizvod.setIdProizvod(rs.getLong("idproizvod"));
            //proizvod.setIdProizvod(rs.getLong(1));
            proizvod.setNaziv(rs.getString("naziv"));
            proizvod.setCena(rs.getBigDecimal("cena"));
            System.out.println(proizvod);
        }
        NitPromena nit=new NitPromena();
        nit.start();
        Thread.currentThread().sleep(3000);
        rs.beforeFirst();
        
        while(rs.next()){
            Proizvod proizvod=new Proizvod();
            proizvod.setIdProizvod(rs.getLong("IDPROIZVOD"));
            //proizvod.setIdProizvod(rs.getLong(1));
            proizvod.setNaziv(rs.getString("Naziv"));
            proizvod.setCena(rs.getBigDecimal("cena"));
            System.out.println(proizvod);
        }
    }
}
