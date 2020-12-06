package language_edu_8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {
	
	protected Connection con;
	protected Statement st;
	protected ResultSet rs;
	
	//protected Connection con2;
	//protected Statement st2;
	//protected ResultSet rs2;
	
	public DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LangEduSign?serverTimezone=UTC", "root","j@ron1075114");
			st = con.createStatement();
			System.out.println("Connect");
		} catch (Exception e) {
			System.out.println("asdfasdfasdfConnect");
		}
	}

}
