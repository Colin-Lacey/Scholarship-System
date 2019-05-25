public class Student {
	private int GPA;
	private int faculty;
	private int academicLevel;
	private int[] scholarshipsAppliedFor;
	
	
	public Student(int GPA, int faculty, int academicLevel, int[] scholarshipsAppliedFor) {
		this.GPA = GPA;
		this.faculty = faculty;
		this.academicLevel = academicLevel;
		this.scholarshipsAppliedFor = scholarshipsAppliedFor;
	}
	
	public int getGPA() {
		return this.GPA;
	}
	public int getFaculty() {
		return this.faculty;
	}
	public int getAcademicLevel() {
		return this.academicLevel;
	}
	public int getScholarshipsAppliedFor() {
		return this.scholarshipAppliedFor;
	}
}
