import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

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
	public void distributeScholarship() throws SQLException {
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
	        Comparator<Scholarship> compareByAward = new Comparator<Scholarship>() {
	        	@Override
	        	public int compare(Scholarship s1, Scholarship s2) {
	        		return Double.compare(s1.getGPA(), s2.getGPA());
	        	}
	        };
	        // sorts scholarships in descending order of award
	        Collections.sort(scholarships,Collections.reverseOrder(compareByAward));
	        
	        ps =con.prepareStatement("select * from applications");
	        
	        ps =con.prepareStatement("select * from student");
	
	        rs=ps.executeQuery();
	        while(rs.next())
	        {
	        	// create a scholarship object using values in specific columns of this row
	        	// row corresponds to a scholarship in database
	        	// ID, name, GPA, faculty, academicLevel, award
	        	
	        	//public Student(String username, double GPA, String faculty, String academicLevel, int id)
	        	Student student = new Student(rs.getString(2),rs.getDouble(9),rs.getString(10),rs.getString(5),rs.getInt(1));
	        	students.add(student);
	        }
	        Comparator<Student> compareByGPA = new Comparator<Student>() {
	        	@Override
	        	public int compare(Student s1, Student s2) {
	        		return Double.compare(s1.getGPA(), s2.getGPA());
	        	}
	        };
	        // sorts Students in descending order of GPA
	        Collections.sort(students,Collections.reverseOrder(compareByGPA));
	        
	        ps =con.prepareStatement("select * from applications");
	    	
	        rs=ps.executeQuery();
	        while(rs.next())
	        {
	        	// create a scholarship object using values in specific columns of this row
	        	// row corresponds to a scholarship in database
	        	// ID, name, GPA, faculty, academicLevel, award
	        	//public Application(int ID, String student, int scholarship)
	        	Application application = new Application(rs.getInt(1),rs.getString(2),rs.getInt(3));
	        	applications.add(application);
	        }
	        
	        
	        
	        for (Scholarship scholarship : scholarships) {
	        	ArrayList<Application> applicationsConsidered= new ArrayList<Application>();
	        	for (Application application : applications) {
	        		if (application.getScholarshipID() == (scholarship.getID())) {
	        			applicationsConsidered.add(application);
	        		}
	        	}
	        	// now compare all the the students and give the scholarship to the one with the highest GPA
	        	Iterator<Application> ap = applicationsConsidered.iterator();
	        	while (ap.hasNext()) {
	        		Application applicant = ap.next();
	        		Iterator<Student> st = students.iterator();
	        		while (st.hasNext()) {
	        			Student student = st.next();
	        			if(student.getUsername().equals(applicant.getStudent())) { 
	        				if(student.getAcademicLevel().equals(scholarship.getAcademicLevel())) {
	        					if(student.getGPA() >= scholarship.getGPA()) {
	        						try {
	        							 //ID
	        							String query = "UPDATE student SET ScholarShip_Owned = '"
	        									+ scholarship.getName()
	        									+ "' WHERE Student_ID = "
	        									+ student.getID();
	        							System.out.println(query);
	        							PreparedStatement preparedStmt = con.prepareStatement(query);
	        							preparedStmt.executeUpdate();		
	        							st.remove();
	        							ap.remove();
	        							query = "DELETE FROM applications "
	        									+ "WHERE Applicant = '"
	        									+ student.getUsername()
	        									+ "'";
	        							System.out.println(query);
	        							preparedStmt = con.prepareStatement(query);
	        							preparedStmt.executeUpdate();
	        							
	        						}catch(Exception ex) {
	        							
	        							System.out.println(ex);
	        						}
	      
	        					}
	        				}
	        			}
	        		}
	        	}
	        }
		}catch(SQLException e)
			{
				System.out.println("Error in getData"+e.getMessage());
				
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