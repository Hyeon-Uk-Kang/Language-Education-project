package language_edu_8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SignDataManagement extends DBConnection {

	protected JOptionPane a = new JOptionPane();
	private String ID;
	private String PW;
	private String NICKNAME;
	private PreparedStatement pstmt;


	public boolean isLogIn(String ID, String PW) {
		try {
			String sql;
			sql = "SELECT UserPw FROM SignData WHERE UserId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(PW)) {
					return true;
				} else
					return false;
			}
			return false;

		} catch (Exception e) {
			System.out.println("오류");
			return false;
		}
	}

	public String getNickname(String ID) {
		
		String Nickname = "";
		
		try {
			String sql;
			sql = "SELECT userNickname FROM SignData WHERE UserId= '" + ID +"';";
			pstmt = con.prepareStatement(sql);
			//pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if(rs.next())
				Nickname = rs.getString(1);
			return Nickname;
		}
		catch (Exception e) {
			System.out.println("뭐여 여기여?");
			
			System.out.println(e.getMessage());}
		
		return Nickname;
	}

	public boolean SignUp(String ID, String PW, String NICKNAME) {
		
		try {
			String sql;
			sql = "INSERT INTO SignData values('" + ID + "','" + PW + "','" + NICKNAME + "');";
			st.executeUpdate(sql);
			
			//String sql2 = "CREATE TABLE "+ NICKNAME + "(word varchar(15), mean varchar(20));";
			//String sql3 = "ALTER TABLE "+ NICKNAME +" convert to character set utf8;";
			//st.executeUpdate(sql2);
			//st.execute(sql3);
			//System.out.println(NICKNAME +" table 생성 완료");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
