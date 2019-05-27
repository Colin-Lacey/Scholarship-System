public class Student {
	private int GPA;
	private String faculty;
	private String academicLevel;
	private String[] scholarshipsAppliedFor;
	
	
	public Student(int GPA, String faculty, String academicLevel, String[] scholarshipsAppliedFor) {
		this.GPA = GPA;
		this.faculty = faculty;
		this.academicLevel = academicLevel;
		this.scholarshipsAppliedFor = scholarshipsAppliedFor;
	}
	
	public int getGPA() {
		return this.GPA;
	}
	public String getFaculty() {
		return this.faculty;
	}
	public String getAcademicLevel() {
		return this.academicLevel;
	}
	public String[] getScholarshipsAppliedFor() {
		return this.scholarshipsAppliedFor;
	}
}
