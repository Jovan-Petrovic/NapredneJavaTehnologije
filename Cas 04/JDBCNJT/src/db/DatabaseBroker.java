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
import java.sql.SQLException;
import java.sql.Statement;
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
        driver.connect(url, properties);

        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        System.out.println("Uspesna konekcija!");
    }

    private void inicijalizacijaPoolDataSource() throws Exception {
        ds = PoolDataSourceFactory.getPoolDataSource();

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
}
