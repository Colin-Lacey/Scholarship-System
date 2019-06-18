/* Class is used as a way to store data from the applications
 *database into an arraylist so that the DBConnect class can
 *perform distributeScholarship method.
 */
public class Application {
	private int id;
	private String student;
	private int scholarship;
	// Constructor
	public Application(int id, String student, int scholarship) {
		this.id = id;
		this.student = student;
		this.scholarship = scholarship;
	}
	// Getters
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