
public class Student {
	private int GPA;
	private int faculty;
	private int academicLevel;
	
	
	public Student(int GPA, int faculty, int academicLevel) {
		this.GPA = GPA;
		this.faculty = faculty;
		this.academicLevel = academicLevel;
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
}
