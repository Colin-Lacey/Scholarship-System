import java.util.*;
public class Distributor {
	
	public void scholarshipDistributor(ArrayList<Scholarship> scholarships, ArrayList<Student> students) {
		for(Scholarship sch : scholarships) {
			for(Student stu : students) {
				if(sch.getFaculty().equals(stu.getFaculty())) {
					if(sch.getAcademicLevel().contentEquals(stu.getAcademicLevel())) {
						if(stu.getGPA() >= sch.getGPA()) {
							stu.addScholarships(sch);
					    }
					}
				}
			}
		}
	}
}
