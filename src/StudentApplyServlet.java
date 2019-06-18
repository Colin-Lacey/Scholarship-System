
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

@WebServlet("/StudentApplyServlet")
// Handles students registration
public class StudentApplyServlet extends HttpServlet {

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
		String scholarship = request.getParameter("scholID");
		System.out.println("the user is " + user + "\n the scholarship is " + scholarship);
		
		connect.addApplication(user, scholarship);
		
		response.sendRedirect("http://localhost:8080/Scholarship-System/StudentPortalServlet");
	}
}
