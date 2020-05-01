/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author student1
 */
public class Util {
    private static Util instance;
    private Properties properties;
    private Util() throws FileNotFoundException, IOException{
        properties=new Properties();
        properties.load(new FileInputStream("db.properties"));
    }
    
    public static Util getInstance() throws IOException{
        if(instance==null){
            instance=new Util();
        }
        return instance;
    }
    
    public String getDriver(){
        String current=properties.getProperty("current");
        return properties.getProperty(current+"_driver");
    }
    
    public String getConnectionFactory(){
        String current=properties.getProperty("current");
        return properties.getProperty(current+"_connectionfactory");
    }
    
    public String getURL(){
        String current=properties.getProperty("current");
        return properties.getProperty(current+"_url");
    }
    
    public String getUser(){
        String current=properties.getProperty("current");
        return properties.getProperty(current+"_user");
    }
    
    public String getPassword(){
        String current=properties.getProperty("current");
        return properties.getProperty(current+"_password");
    }
}
