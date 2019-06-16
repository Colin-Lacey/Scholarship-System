import java.sql.*;
import com.mysql.jdbc.*;

public class DBConnect {

	
	private Connection con;
	private Statement st;

	
	public DBConnect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// (Database schema: scholarship), local root, local password
			con = DriverManager.getConnection("jdbc:mysql://localhost/scholarships", "root", "Vd.30000214");
			st = con.createStatement();
			
			
		}catch(Exception ex) {
			System.out.println("Error: "+ex);
		}
	}
	public void addScholarship(String user, double GPA, String faculty, String level) {
//		try {
//			// ID, Name, Faculty, Quantity, Level, Money offered, GPA
//			String query = "INSERT INTO scholarships VALUES (DEFAULT, %s, %s, 5, %s, 200, %d)"(user,);
//			PreparedStatement preparedStmt = con.prepareStatement(query);
//			preparedStmt.executeUpdate();		
//			
//		}catch(Exception ex) {
//			
//			System.out.println(ex);
//		}
	}
	public void deleteScholarship(String user, double GPA, String faculty, String level) {
//		try {
//			// ID, Name, Faculty, Quantity, Level, Money offered, GPA
//			String query = "INSERT INTO scholarships VALUES (DEFAULT, %s, %s, 5, %s, 200, %d)"(user,);
//			PreparedStatement preparedStmt = con.prepareStatement(query);
//			preparedStmt.executeUpdate();		
//			
//		}catch(Exception ex) {
//			
//			System.out.println(ex);
//		}
	}
	public boolean loginAdmin(String user, String password) {
		if (password.equals("swordfish")) return true;
		else return false;
	}
	public boolean loginStudent(String user, String password) {
		if (password.equals("swordfish")) return true;
		else return false;
	}
	public void addStudent(String user, double GPA, String faculty, String level, String password) {
		try {
			 //ID, username, password, student name, level, scholarship owned, scholarship offered, scholarships accepted, GPA, Faculty
			String query = "INSERT INTO student VALUES (DEFAULT, '"
					+ user
					+ "', NULL, NULL, '"
					+ level
					+ "', NULL, NULL, NULL, "
					+ String.valueOf(GPA)
					+ ", '"
					+ faculty
					+ "')";
			System.out.println(query);
//			String query = "INSERT INTO student VALUES (DEFAULT, 'vince', NULL, NULL, 'UnderGrad', NULL, NULL, NULL, 4.0, 'science')";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();		
			
		}catch(Exception ex) {
			
			System.out.println(ex);
		}
	}
	public void close() {
		try {
			if (this != null) {
				this.close();	
			}
		}catch(Exception e){
			
		}
		
	}
}	