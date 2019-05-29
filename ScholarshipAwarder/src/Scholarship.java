
public class Scholarship {
	private int minGPA;
	private String faculty;
	private int academicLevel;
	private int id;


	public Scholarship(int minGPA, String faculty, int academicLevel) {
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
