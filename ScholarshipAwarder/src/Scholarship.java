
public class Scholarship {
	private int minGPA;
	private int faculty;
	private int academicLevel;
	private int id;
	
	
	public Scholarship(int minGPA, int faculty, int academicLevel) {
		this.minGPA = minGPA;
		this.faculty = faculty;
		this.academicLevel = academicLevel;
	}
	
	public int getGPA() {
		return this.minGPA;
	}
	public int getFaculty() {
		return this.faculty;
	}
	public int getAcademicLevel() {
		return this.academicLevel;
	}
}
