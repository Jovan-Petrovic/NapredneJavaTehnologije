package metadata;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class JDBCMetadataPrimer {
 public Connection konekcija=null;
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/jdbcnjt";
		String user="root";
		String password="";
		JDBCMetadataPrimer m=new JDBCMetadataPrimer();
		m.konekcija=DriverManager.getConnection(url, user, password);
		
		m.getTables();
	}
	
	//metadata
    public ArrayList<String> getTables() throws SQLException, IOException {
        ArrayList<String> tabele = new ArrayList<String>();
        DatabaseMetaData metaData = konekcija.getMetaData();
        //Isprobati na bazi sa vise medjusobno poveyanih tabela!
        ResultSet rs = metaData.getTables("jdbcnjt", null, null, null);
        while (rs.next()) {
            String tabela = rs.getString(3);
            tabele.add(tabela);
            
            System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+", "+rs.getString(4)+"\n");
            prikaziAtribute(tabela);
            prikaziPrimarneKljuceve(tabela);
            prikaziSpoljneKljuceve(tabela);
        }
        rs.close();
        return tabele;
    }

    public void prikaziAtribute(String tabela) throws SQLException {
        ArrayList<String> attributes = new ArrayList<String>();
        DatabaseMetaData metaData = konekcija.getMetaData();
        ResultSet rs = metaData.getColumns(konekcija.getCatalog(), konekcija.getSchema(), tabela, null);
        System.out.println("katalog: "+konekcija.getCatalog()+";");
        System.out.println("Tabela: "+tabela+";");
        while (rs.next()) {
            String naziv = rs.getString(4);
            
            String tip = rs.getString(6);
            int velicina = rs.getInt(7);
            boolean autoInc = false;
            if (rs.getString(23).equals("YES")) {
                autoInc = true;
                
            }
            System.out.println("gc"+rs.getString(24));
            System.out.println("\tnaziv atributa: "+naziv+";\ttip: "+tip+";\tvelicina: "+velicina+";\tauto increment: "+autoInc+";");
        }
        rs.close();
    }

    public void prikaziPrimarneKljuceve(String tabela) throws SQLException {
        
        DatabaseMetaData metaData = konekcija.getMetaData();
        ResultSet rs = metaData.getPrimaryKeys(konekcija.getCatalog(), konekcija.getSchema(), tabela);
        System.out.println("Primarni kljucevi tabele "+tabela+":");
        while (rs.next()) {
            String naziv = rs.getString(4);
            System.out.println("\t"+naziv);
        }
        rs.close();
    }



    public void prikaziSpoljneKljuceve(String tabela) throws SQLException {

        DatabaseMetaData metaData = konekcija.getMetaData();
        ResultSet rs = metaData.getImportedKeys(null, null, tabela);
        System.out.println("Spoljni kljucevi tabele "+tabela+":");
        while (rs.next()) {
            String nazivPovezaneTabele = rs.getString(3);
            String nazivAtributaUPovezanojTabeli = rs.getString(4);
            String nazivTabele = rs.getString(7);
            String nazivAtributa = rs.getString(8);
            System.out.println("\tNaziv atributa: "+nazivAtributa+";\tNaziv tabele: "+nazivTabele+";\tNaziv povezane tabele: "+nazivPovezaneTabele+";\tNaziv vezanog atributa: "+nazivAtributaUPovezanojTabeli+";");
        }
        rs.close();
    }
}
