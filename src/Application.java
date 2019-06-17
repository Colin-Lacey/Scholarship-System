import java.util.ArrayList;

public class Application {
	private int id;
	private String student;
	private int scholarship;

	public Application(int id, String student, int scholarship) {
		this.id = id;
		this.student = student;
		this.scholarship = scholarship;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getStudent() {
		return this.student;
	}
	
	public int getScholarshipID() {
		return this.scholarship;
	}
	
}