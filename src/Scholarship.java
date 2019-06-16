public class Scholarship {
	private double minGPA;
	private String faculty;
	private String academicLevel;
	private String id;


	public Scholarship(double minGPA, String faculty, String academicLevel) {
		this.minGPA = minGPA;
		this.faculty = faculty;
		this.academicLevel = academicLevel;
		// Gives a unique Identifier for any Scholarship type except for duplicates
		this.id = Double.toString(minGPA) + faculty + academicLevel;
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
	public String getID() {
		return this.id;
	}
}