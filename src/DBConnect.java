import java.sql.*;
import java.util.ArrayList;
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
	public void addScholarship(String name, double GPA, String faculty, String level, int award) {
		try {
			// scholarship columns
			String query = "INSERT INTO scholarship VALUES (DEFAULT, '"
					+ name
					+ "', NULL, NULL, '"
					+ level
					+ "', NULL, NULL, NULL, "
					+ String.valueOf(GPA)
					+ ", '"
					+ faculty
					+ "')";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();		
		
		}catch(Exception ex) {
			System.out.println(ex);
		}
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
	public ArrayList<Scholarship> getScholarships() {
		ArrayList<Scholarship> scholarships = new ArrayList<Scholarship>();
		try{
            PreparedStatement ps =con.prepareStatement("select * from scholarship");

            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            	// create a scholarship object using values in specific columns of this row
            	// row corresponds to a scholarship in database
            	// ID, name, GPA, faculty, academicLevel, award
            	Scholarship schol = new Scholarship(rs.getInt(),rs.getString(),rs.getDouble(),rs.getString(),rs.getString(),rs.getInt());
            	scholarships.add(schol);
            }

		}
		catch(Exception e)
		{
			System.out.println("Error in getData"+e);
		}
		return scholarships;
	}
	public boolean loginAdmin(String user, String password) {
		try{
            PreparedStatement ps =con.prepareStatement("select * from scholarships");

            ResultSet rs=ps.executeQuery();

		}
		catch(Exception e)
		{
			System.out.println("Error in getData"+e);
		}
		if (password.equals("swordfish")) return true;
		else return false;
	}
	public boolean loginStudent(String user, String password) {
		try{
            PreparedStatement ps =con.prepareStatement("select * from scholarships");

            ResultSet rs=ps.executeQuery();

		}
		catch(Exception e)
		{
			System.out.println("Error in getData"+e);
		}
		if (password.equals("swordfish")) return true;
		else return false;
	}
	public void addStudent(String user, double GPA, String faculty, String level, String password) {
		try {
			 //ID, username, password, student name, level, scholarship owned, scholarship offered, scholarships accepted, GPA, Faculty
			String query = "INSERT INTO student VALUES (DEFAULT, '"
					+ user
					+ "', '"
					+ password
					+ "', NULL, '"
					+ level
					+ "', NULL, NULL, NULL, "
					+ String.valueOf(GPA)
					+ ", '"
					+ faculty
					+ "')";
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