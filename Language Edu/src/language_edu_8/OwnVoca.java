package language_edu_8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;




public class OwnVoca{

	protected Connection con2;
	protected Statement st2;
	protected ResultSet rs2;
	
	
	public OwnVoca() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/OwnVoca?serverTimezone=UTC", "root",
					"j@ron1075114");
			st2 = con2.createStatement();

		} catch (Exception e) {}
	}
	
	

	public void getOwnVoca(String Nickname, DefaultTableModel model) {
		
		Object[] userRow = new Object[2];
		String str="SELECT * from "+Nickname;
		String str2 = "ALTER TABLE "+ Nickname +" convert to character set utf8;";
		
		System.out.println(Nickname);
		try {
			st2 = con2.createStatement();
			st2.execute(str2);
			rs2 = st2.executeQuery(str);
			

			while(rs2.next()) {

				String word = rs2.getString("word");
				String mean = rs2.getString("mean");
				userRow[0] = word;
				userRow[1] = mean;
				model.addRow(userRow);
			}
			
		}catch(Exception e) {System.out.println(e.getMessage());}
	}

	public void deleteOwnVoca(String Nickname, DefaultTableModel model, int row, int column) {
		Object delete = model.getValueAt(row, column);
		System.out.println(delete);
		String str = "SET SQL_SAFE_UPDATES = 0;";
		String str2 = "ALTER TABLE "+ Nickname +" convert to character set utf8;";
		String str3 = "DELETE FROM "+ Nickname + " WHERE word= '"+delete+"';";
		try {
			
			st2 = con2.createStatement();
			st2.execute(str2);	
			st2.executeUpdate(str);
			st2.execute(str3);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void addOwnVoca(String Nickname, String word,String mean, DefaultTableModel model) {
		Object[] userRow = new Object[2];
		String str2 = "ALTER TABLE "+ Nickname +" convert to character set utf8;";
		try {
			st2.execute(str2);	
			String sql;
			sql = "INSERT INTO "+ Nickname +" values('" + word + "','" + mean + "');";
			st2.executeUpdate(sql);
			userRow[0] = word;
			userRow[1] = mean;
			model.addRow(userRow);
			
		} catch (Exception e) {}


	}


	public void makeOwnVoca(String Nickname) {
		String sql = "CREATE TABLE "+ Nickname + "(word varchar(15), mean varchar(20));";
		String sql2 = "ALTER TABLE "+ Nickname +" convert to character set utf8;";
		try {
			
			st2.executeUpdate(sql);
			st2.execute(sql2);
			System.out.println(Nickname+" table 생성 완료");
		}catch(Exception e){System.out.println("테이블 생성 오류");}
	}

}
