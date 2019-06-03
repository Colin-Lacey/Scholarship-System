import java.util.*;
public class ScholarshipAwarder {

	public static void main(String[] args) {
		// distribute scholarship objects among student objects
		ArrayList<Scholarship> scholarshipsAppliedFor = new ArrayList<Scholarship>();
		Filter filter = new Filter();
		// List of Scholarships
		scholarshipsAppliedFor.add(new Scholarship(3, "Science", 1));
		scholarshipsAppliedFor.add(new Scholarship(3, "Nursing", 1));
		scholarshipsAppliedFor.add(new Scholarship(3, "Arts", 1));
		scholarshipsAppliedFor.add(new Scholarship(3, "Science", 2));
		scholarshipsAppliedFor.add(new Scholarship(3, "Nursing", 2));
		scholarshipsAppliedFor.add(new Scholarship(3, "Arts", 2));
		scholarshipsAppliedFor.add(new Scholarship(3, "Science", 3));
		scholarshipsAppliedFor.add(new Scholarship(3, "Nursing", 3));
		scholarshipsAppliedFor.add(new Scholarship(3, "Arts", 3));
		scholarshipsAppliedFor.add(new Scholarship(3, "Science", 4));
		scholarshipsAppliedFor.add(new Scholarship(3, "Nursing", 4));
		scholarshipsAppliedFor.add(new Scholarship(3, "Arts", 4));
		scholarshipsAppliedFor.add(new Scholarship(4, "Science", 1));
		scholarshipsAppliedFor.add(new Scholarship(4, "Nursing", 1));
		scholarshipsAppliedFor.add(new Scholarship(4, "Arts", 1));
		scholarshipsAppliedFor.add(new Scholarship(4, "Science", 2));
		scholarshipsAppliedFor.add(new Scholarship(4, "Nursing", 2));
		scholarshipsAppliedFor.add(new Scholarship(4, "Arts", 2));
		scholarshipsAppliedFor.add(new Scholarship(4, "Science", 3));
		scholarshipsAppliedFor.add(new Scholarship(4, "Nursing", 3));
		scholarshipsAppliedFor.add(new Scholarship(4, "Arts", 3));
		scholarshipsAppliedFor.add(new Scholarship(4, "Science", 4));
		scholarshipsAppliedFor.add(new Scholarship(4, "Nursing", 4));
		scholarshipsAppliedFor.add(new Scholarship(4, "Arts", 4));

		// Testing different filters 
		Student student = new Student(4, "Science", 1);
		Student student2 = new Student(3, "Nursing", 3);
		/*filter.filterLevel(scholarshipsAppliedFor, student);
		filter.filterFaculty(scholarshipsAppliedFor, student);
		filter.filterGPA(scholarshipsAppliedFor, student);
		filter.filterLevelFaculty(scholarshipsAppliedFor, student);
		filter.filterLevelFacultyGPA(scholarshipsAppliedFor, student);*/

		filter.filterLevel(scholarshipsAppliedFor, student2);
		filter.filterFaculty(scholarshipsAppliedFor, student2);
		filter.filterGPA(scholarshipsAppliedFor, student2);
		filter.filterLevelFaculty(scholarshipsAppliedFor, student2);
		filter.filterLevelFacultyGPA(scholarshipsAppliedFor, student2);
	}
}
