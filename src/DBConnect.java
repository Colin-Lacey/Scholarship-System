import java.sql.*;
import java.util.ArrayList;

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
	public void addScholarship(String name, double GPA, String faculty, String level, int award, int awardNum) {
		try {
			 //ID, name, faculty offered to, quantity offered, academic level offered to, money offered, required GPA
			String query = "INSERT INTO scholarships VALUES (DEFAULT, '"
					+ name
					+ "', '"
					+ faculty
					+ "', "
					+ String.valueOf(awardNum)
					+ ", '"
					+ level
					+ "', "
					+ String.valueOf(award)
					+ ", "
					+ String.valueOf(GPA)
					+ ")";
			System.out.println(query);
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();		
			
		}catch(Exception ex) {
			
			System.out.println(ex);
		}
	}
	public void deleteScholarship(int ID) {
		try {
			 //ID
			String query = "DELETE FROM scholarships WHERE Scholarship_ID = "
					+ Integer.toString(ID);
			System.out.println(query);
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();		
			
		}catch(Exception ex) {
			
			System.out.println(ex);
		}
	}
	public ArrayList<Scholarship> getScholarships() {
		ArrayList<Scholarship> scholarships = new ArrayList<Scholarship>();
		try{
            PreparedStatement ps =con.prepareStatement("select * from scholarships");

            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            	// create a scholarship object using values in specific columns of this row
            	// row corresponds to a scholarship in database
            	// ID, name, GPA, faculty, academicLevel, award
            	Scholarship schol = new Scholarship(rs.getInt(1),rs.getString(2),rs.getDouble(7),rs.getString(3),rs.getString(5),rs.getInt(6));
            	scholarships.add(schol);
            }

		}
		catch(Exception e)
		{
			System.out.println("Error in getData"+e);
		}
		return scholarships;
	}
	public void distributeScholarship() {
		ArrayList<Scholarship> scholarships = new ArrayList<Scholarship>();
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Application> applications = new ArrayList<Application>();
		PreparedStatement ps =con.prepareStatement("select * from scholarships");
		try {
	        ResultSet rs=ps.executeQuery();
	        while(rs.next())
	        {
	        	// create a scholarship object using values in specific columns of this row
	        	// row corresponds to a scholarship in database
	        	// ID, name, GPA, faculty, academicLevel, award
	        	Scholarship schol = new Scholarship(rs.getInt(1),rs.getString(2),rs.getDouble(7),rs.getString(3),rs.getString(5),rs.getInt(6));
	        	scholarships.add(schol);
	        }
	        ps =con.prepareStatement("select * from student");
	
	        rs=ps.executeQuery();
	        while(rs.next())
	        {
	        	// create a scholarship object using values in specific columns of this row
	        	// row corresponds to a scholarship in database
	        	// ID, name, GPA, faculty, academicLevel, award
	        	//public Student(double GPA, String faculty, String academicLevel)
	        	Student student = new Student(rs.getDouble(9),rs.getString(10),rs.getString(7),rs.getInt(1));
	        	students.add(student);
	        }
	        ps =con.prepareStatement("select * from applications");
	    	
	        rs=ps.executeQuery();
	        while(rs.next())
	        {
	        	// create a scholarship object using values in specific columns of this row
	        	// row corresponds to a scholarship in database
	        	// ID, name, GPA, faculty, academicLevel, award
	        	//public Student(double GPA, String faculty, String academicLevel)
	        	Application application = new Application(rs.getInt(1),rs.getString(2),rs.getString(3));
	        	applications.add(application);
	        }
	        
	        // sort students based on highest GPA first, sort scholarships based on highest GPA first
	        for (Scholarship scholarship : scholarships) {
	        	ArrayList<String> applicationsConsidered= new ArrayList<String>();
	        	for (Application application : applications) {
	        		if (application.getScholarshipID() == (scholarship.getID())) {
	        			applicationsConsidered.add(application.getStudent());
	        		}
	        	}
	        	// now compare all the the students and give the scholarship to the one with the highest GPA
	        }
		}catch(Exception e)
			{
				System.out.println("Error in getData"+e);
			}
	    	  
	   }

	
	
	public boolean loginAdmin(String user, String password) {

		String pass = "";
		try{
            PreparedStatement ps =con.prepareStatement("select administrator_password from administrators where administrator_username = '"
            		+ user
            		+ "' and administrator_password = '"
            		+ password
            		+ "'");

            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
            	pass = rs.getString(1);
            }
            
		}
		catch(Exception e)
		{
			System.out.println("Error in getData"+e);
		}
		
		if (password.equals(pass))return true;
		else return false;

	}
	
	public boolean loginStudent(String user, String password) {
		String pass = "";
		try{
            PreparedStatement ps =con.prepareStatement("select Password from student where Username = '"
            		+ user
            		+ "' and Password = '"
            		+ password
            		+ "'");

            ResultSet rs=ps.executeQuery();
            while(rs.next()) {
            	pass = rs.getString(1);
            }
            
		}
		catch(Exception e)
		{
			System.out.println("Error in getData"+e);
		}
		
		if (password.equals(pass))return true;
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
	public void addApplication(String Applicant, String Scholarship) {
		try {
			 //ID, username, password, student name, level, scholarship owned, scholarship offered, scholarships accepted, GPA, Faculty
			String query = "INSERT INTO applications VALUES (DEFAULT, '"
					+ Applicant
					+ "', '"
					+ Scholarship
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