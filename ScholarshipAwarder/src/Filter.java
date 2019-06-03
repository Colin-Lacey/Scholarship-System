import java.util.*;

public class Filter {

  public void filterLevel(ArrayList<Scholarship> scholarshipsAppliedFor, Student student) {
    System.out.println("List of available level " + student.getAcademicLevel() + " scholarships:" + "\n");
    for(Scholarship str : scholarshipsAppliedFor) {
      if(student.getAcademicLevel() == str.getAcademicLevel()) {
        System.out.println(str.getID());
      }
    }
  }
  public void filterFaculty(ArrayList<Scholarship> scholarshipsAppliedFor, Student student) {
    System.out.println("List of available " + student.getFaculty() + " scholarships:" + "\n");
    for(Scholarship str : scholarshipsAppliedFor) {
      if(student.getFaculty().equals(str.getFaculty())) {
        System.out.println(str.getID());
      }
    }
  }
  public void filterGPA(ArrayList<Scholarship> scholarshipsAppliedFor, Student student) {
    System.out.println("List of available scholarships for your given GPA:" + "\n");
    for(Scholarship str : scholarshipsAppliedFor) {
      if(student.getGPA() >= str.getGPA()) {
        System.out.println(str.getID());
      }
    }
  }
  public void filterLevelFaculty(ArrayList<Scholarship> scholarshipsAppliedFor, Student student) {
    System.out.println("List of available level " + student.getAcademicLevel() + " scholarships in the faculty of "
    +student.getFaculty() +":" + "\n");
    for(Scholarship str : scholarshipsAppliedFor) {
      if(student.getID().equals(str.getID())) {
        System.out.println(str.getID());
      }
    }
  }
  public void filterLevelFacultyGPA(ArrayList<Scholarship> scholarshipsAppliedFor, Student student) {
    System.out.println("List of available level " + student.getAcademicLevel() + " scholarships in the faculty of "
    +student.getFaculty() +" with your given GPA:" + "\n");
    for(Scholarship str : scholarshipsAppliedFor) {
      if(student.getID().equals(str.getID())) {
        if(student.getGPA() >= str.getGPA()) {
          System.out.println(str.getID());
        }
      }
    }
  }
}
