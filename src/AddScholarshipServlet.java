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

@WebServlet("/AddScholarshipServlet")
// Handles students registration
public class AddScholarshipServlet extends HttpServlet {

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
		String name = request.getParameter("name");
		double gpa = Double.parseDouble(request.getParameter("gpa"));
		String faculty = request.getParameter("faculty");
		String level = request.getParameter("level");
		int award = Integer.parseInt(request.getParameter("award"));
		// Adds the scholarship to the database
		connect.addScholarship(name, gpa, faculty, level, award);
		
		response.sendRedirect("AdminPortalServlet");
		
		//connect.close();
	}
	
}