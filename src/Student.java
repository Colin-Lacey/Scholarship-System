import java.util.ArrayList;
/* Class is the basic structure of what a student
 * object is in this project. Class is mainly being 
 * called and used by the DBConnect class
 */
public class Student {
	private double GPA;
	private String faculty;
	private String academicLevel;
	private int id;
	private String username;
	public ArrayList<Scholarship> myScholarships;

	public Student(String username, double GPA, String faculty, String academicLevel, int id) {
		this.username = username;
		this.GPA = GPA;
		this.faculty = faculty;
		this.academicLevel = academicLevel;
		this.id = id;
		myScholarships = new ArrayList<Scholarship>();
	}
	public void addScholarships(Scholarship scholarship) {
		this.myScholarships.add(scholarship);
	}
	// getters
	public double getGPA() {
		return this.GPA;
	}
	public String getFaculty() {
		return this.faculty;
	}
	public String getAcademicLevel() {
		return this.academicLevel;
	}
	public String getUsername() {
		return this.username;
	}
	public int getID() {
		return this.id;
	}
	public ArrayList<Scholarship> getMyScholarships() {
		return myScholarships;
	}
}