/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import db.DatabaseBroker;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Proizvod;

/**
 *
 * @author student1
 */
public class Start {
    public static void main(String[] args) throws Exception {
        DatabaseBroker dbbr=new DatabaseBroker();
        dbbr.uspostaviKonekcijuTreciNacin();
        
        Proizvod p = new Proizvod(1, "Cokoladna bananica", BigDecimal.valueOf(15));
        try{
            //dbbr.insertProizvod(p);
            List<Proizvod> proizvodi=new ArrayList<>();
            proizvodi.add(new Proizvod(22, "n2", BigDecimal.valueOf(2)));
            proizvodi.add(new Proizvod(33, "n3", BigDecimal.valueOf(3)));
            proizvodi.add(new Proizvod(44, "n4", BigDecimal.valueOf(4)));
            dbbr.insertProizvodsBoljiNacin(proizvodi);
            dbbr.potvrdiTransakciju();
        }catch(Exception e){
            dbbr.ponistiTransakciju();
            e.printStackTrace();
        }
        
        dbbr.raskiniKonekciju();
    }
}
