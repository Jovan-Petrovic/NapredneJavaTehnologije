package transactionIsolation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NitPromenaStanjaUBazi extends Thread{
	
	@Override
	public void run() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/jdbcnjt";
			String user="root";
			String password="";
			Connection connection=DriverManager.getConnection(url, user, password);
			connection.setTransactionIsolation(connection.TRANSACTION_READ_COMMITTED);
			connection.setAutoCommit(false);
			
			
			Statement statement=connection.createStatement();
			System.out.println("Promena naziva proizvoda sa sifrom 33");
			statement.executeUpdate("UPDATE PROIZVOD SET NAZIV = 'Naziv u "+new SimpleDateFormat("hh:mm:ss").format(new Date())+"' WHERE IDproizvod=33");
			//this.sleep(10000);
			connection.commit();
			
			System.out.println("Potvrda promene");
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
