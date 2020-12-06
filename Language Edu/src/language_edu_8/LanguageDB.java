package language_edu_8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class LanguageDB {
	
	protected Connection con;
	protected Statement st;
	protected ResultSet rs;
	
	public LanguageDB() {try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Language?serverTimezone=UTC", "root",
				"j@ron1075114");
		st = con.createStatement();
		System.out.println("Connect");
	} catch (Exception e) {
		System.out.println("Connectasdfasfasdfasdf");
		System.out.println(e.getMessage());
	}}
	
	public void getLangList(String lang,DefaultTableModel model) {
		Object[] userRow = new Object[3];
		String str="SELECT * from "+ lang;
		
		try {
			st = con.createStatement();
			rs = st.executeQuery(str);

			while(rs.next()) {

				String word = rs.getString("word");
				String mean = rs.getString("mean");
				String sentence = rs.getString("sentence");
				
				userRow[0] = word;
				userRow[1] = mean;
				userRow[2] = sentence;
				model.addRow(userRow);
			}
		}catch(Exception e) {System.out.println(e.getMessage());}
	}
	
}
