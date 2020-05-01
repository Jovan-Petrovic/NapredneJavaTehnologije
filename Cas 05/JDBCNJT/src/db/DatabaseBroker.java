/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import model.Proizvod;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

/**
 *
 * @author student1
 */
public class DatabaseBroker {

    Connection connection;
    PoolDataSource ds;

    public DatabaseBroker() throws Exception {
        inicijalizacijaPoolDataSource();
    }

    public void uspostaviKonekciju() throws ClassNotFoundException, SQLException, IOException {
        Class.forName(Util.getInstance().getDriver());
        String url = Util.getInstance().getURL();
        String user = Util.getInstance().getUser();
        String password = Util.getInstance().getPassword();

        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        System.out.println("Uspesna konekcija!");
    }

    public void uspostaviKonekcijuDrugiNacin() throws ClassNotFoundException, SQLException, IOException, InstantiationException, IllegalAccessException {

        Driver driver = (Driver) Class.forName(Util.getInstance().getDriver()).newInstance();
        String url = Util.getInstance().getURL();
        String user = Util.getInstance().getUser();
        String password = Util.getInstance().getPassword();
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        connection = driver.connect(url, properties);

        //connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        System.out.println("Uspesna konekcija!");
    }

    private void inicijalizacijaPoolDataSource() throws Exception {
        ds = PoolDataSourceFactory.getPoolDataSource();

        //com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource
        //com.mysql.cj.jdbc.MysqlConnectionPoolDataSource
        ds.setConnectionFactoryClassName(Util.getInstance().getConnectionFactory());
        ds.setURL(Util.getInstance().getURL());
        ds.setUser(Util.getInstance().getUser());
        ds.setPassword(Util.getInstance().getPassword());

        ds.setInitialPoolSize(15);
        ds.setMinPoolSize(5);
        ds.setAbandonedConnectionTimeout(60);
        ds.setMaxPoolSize(50);

    }

    public void uspostaviKonekcijuTreciNacin() throws Exception {

        connection = ds.getConnection();
        connection.setAutoCommit(false);

        System.out.println("Uspesna konekcija!");
    }

    public void raskiniKonekciju() throws SQLException {
        if (connection != null) {
            connection.close();
            System.out.println("Raskinuta konekcija!");
        }
    }

    public void potvrdiTransakciju() throws SQLException {
        if (connection != null) {
            connection.commit();
        }
    }

    public void ponistiTransakciju() throws SQLException {
        if (connection != null) {
            connection.rollback();
        }
    }

    public void insertProizvod(Proizvod p) throws SQLException {
        String upit = "INSERT INTO PROIZVOD (IDPROIZVOD, NAZIV, CENA) VALUES (" + p.getIdProizvod() + ", '" + p.getNaziv() + "', " + p.getCena() + ")";
        Statement statement = connection.createStatement();
        statement.executeUpdate(upit);
        statement.close();
    }

    public void insertProizvodBoljiNacin(Proizvod p) throws SQLException {
        String upit = "INSERT INTO PROIZVOD (IDPROIZVOD, NAZIV, CENA) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(upit);

        statement.setLong(1, p.getIdProizvod());
        statement.setString(2, p.getNaziv());
        statement.setBigDecimal(3, p.getCena());

        statement.executeUpdate();
        statement.close();
    }

    public void insertProizvods(List<Proizvod> proizvodi) throws SQLException {
        String upit = "INSERT INTO PROIZVOD (IDPROIZVOD, NAZIV, CENA) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(upit);
        for (Proizvod p : proizvodi) {

            statement.setLong(1, p.getIdProizvod());
            statement.setString(2, p.getNaziv());
            statement.setBigDecimal(3, p.getCena());

            statement.executeUpdate();

        }
        statement.close();
    }
    
    public void insertProizvodsBoljiNacin(List<Proizvod> proizvodi) throws SQLException {
        String upit = "INSERT INTO PROIZVOD (IDPROIZVOD, NAZIV, CENA) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(upit);
        for (Proizvod p : proizvodi) {

            statement.setLong(1, p.getIdProizvod());
            statement.setString(2, p.getNaziv());
            statement.setBigDecimal(3, p.getCena());

            //statement.executeUpdate();
            statement.addBatch();

        }
        statement.executeBatch();
        statement.close();
    }
    
    public List<Proizvod> getAllProizvod() throws SQLException{
        List<Proizvod> proizvodi=new ArrayList<>();
        String upit="SELECT * FROM Proizvod";
        Statement statement=connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=statement.executeQuery(upit);
        while(rs.next()){
            Proizvod proizvod=new Proizvod();
            proizvod.setIdProizvod(rs.getLong("IDPROIZVOD"));
            //proizvod.setIdProizvod(rs.getLong(1));
            proizvod.setNaziv(rs.getString("NAZIV"));
            proizvod.setCena(rs.getBigDecimal("CENA"));
            proizvodi.add(proizvod);
        }
        
        //rs.previous();//ne moze da se izvrsi za ResultSet.TYPE_FORWARD_ONLY
        //rs.previous();
        //System.out.println(rs.getLong("IdProizvod"));
        rs.close();
        statement.close();
        return proizvodi;
    }
    
    public void insertProizvodResultSet(Proizvod p) throws SQLException {
        String upit="SELECT p.IDPROIZVOD AS idproizvod, p.naziv AS nazivProizvoda, p.cena AS cena FROM Proizvod p";//
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=statement.executeQuery(upit);
        while(rs.next()){
            Proizvod proizvod=new Proizvod();
            proizvod.setIdProizvod(rs.getLong("idproizvod"));
            //proizvod.setIdProizvod(rs.getLong(1));
            proizvod.setNaziv(rs.getString("nazivProizvoda"));
            proizvod.setCena(rs.getBigDecimal("cena"));
            System.out.println(proizvod);
        }
        
        rs.moveToInsertRow();
        rs.updateLong("idproizvod", p.getIdProizvod());
        rs.updateString("nazivProizvoda", p.getNaziv());
        rs.updateBigDecimal("cena", p.getCena());
        rs.insertRow();

        rs.close();
        statement.close();
    }
    
    public void updateProizvodResultSet(Proizvod p) throws SQLException {
        String upit="SELECT * FROM Proizvod";
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=statement.executeQuery(upit);
        /*while(rs.next()){
            Proizvod proizvod=new Proizvod();
            proizvod.setIdProizvod(rs.getLong("IDPROIZVOD"));
            //proizvod.setIdProizvod(rs.getLong(1));
            proizvod.setNaziv(rs.getString("Naziv"));
            proizvod.setCena(rs.getBigDecimal("cena"));
            System.out.println(proizvod);
        }
*/
        
        rs.absolute(3);
        rs.updateString("NAZIV", "NAZIV3");
        rs.updateRow();


        rs.close();
        statement.close();
    }
}
