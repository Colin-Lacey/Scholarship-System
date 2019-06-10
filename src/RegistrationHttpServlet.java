// extensive code taken and modified from 
// https://javatutorial.net/java-servlet-post-example

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RegistrationHttpServlet extends HttpServlet {
	private static final long serialVersionUID = -1641096228274971485L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// set response headers
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String user = request.getParameter("user");
		double gpa = Double.parseDouble(request.getParameter("gpa"));
		String faculty = request.getParameter("faculty");
		String level = request.getParameter("level");
		
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
		if (user != null && !user.trim().isEmpty()) {
			writer.append("	Welcome " + user + ".\r\n");
			writer.append("Your GPA is " + Double.toString(gpa) + ", your faculty is " + faculty + ", and your academic level is " + level +".");
		} else {
			writer.append("	You did not entered a name!\r\n");
		}
		writer.append("		</body>\r\n")
			  .append("</html>\r\n");
	}	
	
}