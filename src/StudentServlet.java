// extensive code taken and modified from 
// https://javatutorial.net/java-servlet-post-example

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.*;

@WebServlet("/StudentServlet")
// Handles students registration
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// set response headers
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnect connect = new DBConnect();
		String user = request.getParameter("user");
		double gpa = Double.parseDouble(request.getParameter("gpa"));
		String faculty = request.getParameter("faculty");
		String level = request.getParameter("level");
		String password = request.getParameter("password");
		// Adds the student to the database
		connect.addStudent(user, gpa, faculty, level, password);
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		// create HTML response
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n")
			  .append("<html>\r\n")
			  .append("		<head>\r\n")
			  .append("			<title>Welcome message</title>\r\n")
			  .append("		</head>\r\n")
			  .append("		<body>\r\n");
//		if (user != null && !user.trim().isEmpty()) {
//			writer.append("<p>List of Scholarships you can apply for:\r\n" + "</p>");
//			for(Scholarship str : arr) {
//				if(student.getID().equals(str.getID())) {
//			        if(student.getGPA() >= str.getGPA()) {
//			          System.out.println(str.getID());
//			          writer.append("<p>" + new String(Double.toString(str.getGPA()) + str.getFaculty() + str.getAcademicLevel()) + "</p>");
//			        }
//			      } 
//			}
//		} else {
//			writer.append("	You did not entered a name!\r\n");
//		}
		writer.append("		</body>\r\n")
			  .append("</html>\r\n");
		//connect.close();
	}
	
}
