public class Scholarship {
	private double minGPA;
	private String name;
	private String faculty;
	private String academicLevel;
	private int id;
	private int award;


	public Scholarship(int id, String name, double minGPA, String faculty, String academicLevel, int award) {
		this.id = id;
		this.name = name;
		this.minGPA = minGPA;
		this.faculty = faculty;
		this.academicLevel = academicLevel;
		// Gives a unique Identifier for any Scholarship type except for duplicates
		this.award = award;
	}
	// getters and setters
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