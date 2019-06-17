import java.util.ArrayList;

public class Student {
	private double GPA;
	private String faculty;
	private String academicLevel;
	private int id;
	public ArrayList<Scholarship> myScholarships;

	public Student(double GPA, String faculty, String academicLevel, int id) {
		this.GPA = GPA;
		this.faculty = faculty;
		this.academicLevel = academicLevel;
		// Gives a unique Identifier for any Scholarship type except for duplicates
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
	public int getID() {
		return this.id;
	}
	public ArrayList<Scholarship> getMyScholarships() {
		return myScholarships;
	}
	public String toString() {
		int count = 0;
		for(int i = 0; i < myScholarships.size(); i++) {
			count++;
		}
		return "StudentID: " + this.id + " Number of scholarships granted : " + count;
	}
}