public class Student {
	private int GPA;
	private String faculty;
	private int academicLevel;
	private String id;

	public Student(int GPA, String faculty, int academicLevel) {
		this.GPA = GPA;
		this.faculty = faculty;
		this.academicLevel = academicLevel;
		// Gives a unique Identifier for any Scholarship type except for duplicates
		this.id = Integer.toString(GPA) + faculty + Integer.toString(academicLevel);
	}
	// getters
	public int getGPA() {
		return this.GPA;
	}
	public String getFaculty() {
		return this.faculty;
	}
	public int getAcademicLevel() {
		return this.academicLevel;
	}
	public String getID() {
		return this.id;
	}
}
