/* Class is the basic structure of what a scholarship
 * object is in this project. Class is mainly being 
 * called and used by the DBConnect class
 */
public class Scholarship {
	private double minGPA;
	private String name;
	private String faculty;
	private String academicLevel;
	private int id;
	private int award;

	// Constructor
	public Scholarship(int id, String name, double minGPA, String faculty, String academicLevel, int award) {
		this.id = id;
		this.name = name;
		this.minGPA = minGPA;
		this.faculty = faculty;
		this.academicLevel = academicLevel;
		this.award = award;
	}
	// Getters and Setters
	public double getGPA() {
		return this.minGPA;
	}

	public void setGPA(double minGPA) {
		this.minGPA = minGPA;
	}

	public String getFaculty() {
		return this.faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getAcademicLevel() {
		return this.academicLevel;
	}
	public void setAcademicLevel(String academicLevel) {
		this.academicLevel = academicLevel;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void setAward(int award) {
		this.award = award;
	}
	public int getAward() {
		return this.award;
	}

	public int getID() {
		return this.id;
	}
}