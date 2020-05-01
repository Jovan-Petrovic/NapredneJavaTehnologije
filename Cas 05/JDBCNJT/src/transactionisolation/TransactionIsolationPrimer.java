package transactionIsolation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class TransactionIsolationPrimer {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://127.0.0.1:3306/jdbcnjt";
		String user="root";
		String password="";
		Connection connection=DriverManager.getConnection(url, user, password);
		//TRANSACTION_SERIALIZABLE - u oba citanja ce biti isti rezultat, jer ce commit druge transakcije da se desi tek nakon zavrsetka ove - tj. nakon drugog prikaza sadrzaja resultSeta (nema ni dirty ni phantom) ( you can READ and WRITE (SELECT, UPDATE) rows that are not included with serializable transaction, but you can't DELETE OR INSERT rows on TABLE level.)
		//TRANSACTION_READ_COMMITTED - citanja ce se razlikovati iako se isti upit ponavlja u istoj transakciji, jer u medjuvremenu druga transakcija vrsi promenu sa commit, ali ako se commit promene desava nakon drugog citanja, nece biti vidljiva
		//TRANSACTION_READ_UNCOMMITTED (Oracle 18c ne podrzava)- citanja ce se razlikovati iako se isti upit ponavlja u istoj transakciji, bez obzira da li ce u medjuvremenu druga transakcija vrsi promenu sa commit, ili se commit promene desava nakon drugog citanja, samo je bitno da se promena pozove u medjuvremenu
		//TRANSACTION_REPEATABLE_READ (Oracle 18c ne podrzava)- slicno Serializable, samo sto serializable zakljucava sve redove i sve operacije nad njima (nema inserta), a repeatable samo sprjecava da se mijenjaju redovi koji su zakljucani. (nema dirty ali ima phantom)
                //MySQL podryava sve izolacione nivoe
		connection.setTransactionIsolation(connection.TRANSACTION_READ_COMMITTED);
		connection.setAutoCommit(false);
		
		
		
		System.out.println("citanje");

		PreparedStatement statement=connection.prepareStatement("SELECT * FROM PROIZVOD",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=statement.executeQuery();
		
		System.out.println("Prikaz1");
		rs.beforeFirst();
		while(rs.next()) {
			
			System.out.println(rs.getInt(1)+" "+ rs.getString(2));
		}
		
		NitPromenaStanjaUBazi nit=new NitPromenaStanjaUBazi();
		nit.start();
		Thread.currentThread().sleep(5000);
		
		rs=statement.executeQuery();
                System.out.println("Prikaz2");
		rs.beforeFirst();
		while(rs.next()) {
			
			System.out.println(rs.getInt(1)+" "+ rs.getString(2));
		}
		connection.commit();

	}

}
