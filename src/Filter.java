import java.util.*;

public class Filter {
	ArrayList<String> approvedScholarships;
	public Filter() {
		approvedScholarships = new ArrayList<String>();
	}

  public void filterLevelFacultyGPA(ArrayList<Scholarship> scholarshipsAppliedFor, Student student) {
    System.out.println("List of available level " + student.getAcademicLevel() + " scholarships in the faculty of "
    +student.getFaculty() +" with your given GPA:" + "\n");
    for(Scholarship str : scholarshipsAppliedFor) {
      if(student.getID().equals(str.getID())) {
        if(student.getGPA() >= str.getGPA()) {
          System.out.println(str.getID());
          approvedScholarships.add(new String(Double.toString(str.getGPA()) + str.getFaculty() + str.getAcademicLevel()));
        }
      } 
    }
  }
  public ArrayList<String> getScholarships() {
	  return approvedScholarships;
  }
}
