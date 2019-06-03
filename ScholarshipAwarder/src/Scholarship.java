
public class Scholarship {
	private int minGPA;
	private String faculty;
	private int academicLevel;
	private String id;


	public Scholarship(int minGPA, String faculty, int academicLevel) {
		this.minGPA = minGPA;
		this.faculty = faculty;
		this.academicLevel = academicLevel;
		// Gives a unique Identifier for any Scholarship type except for duplicates
		this.id = Integer.toString(minGPA) + faculty + Integer.toString(academicLevel);
	}
	// getters and setters
	public int getGPA() {
		return this.minGPA;
	}

	public void setGPA(int minGPA) {
		this.minGPA = minGPA;
	}

	public String getFaculty() {
		return this.faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getAcademicLevel() {
		return this.academicLevel;
	}

	public void setAcademicLevel(int academicLevel) {
		this.academicLevel = academicLevel;
	}
	public String getID() {
		return this.id;
	}
}
