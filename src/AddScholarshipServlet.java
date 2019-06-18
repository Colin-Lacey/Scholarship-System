import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddScholarshipServlet
 */
@WebServlet("/AddScholarshipServlet")
// Handles students registration
public class AddScholarshipServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set response headers
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create database connection
		DBConnect connect = new DBConnect();
		
		String name = request.getParameter("name");
		double gpa = Double.parseDouble(request.getParameter("gpa"));
		String faculty = request.getParameter("faculty");
		String level = request.getParameter("level");
		int award = Integer.parseInt(request.getParameter("award"));
		int awardNum = Integer.parseInt(request.getParameter("awardNum"));
		// Adds the scholarship to the database
		connect.addScholarship(name, gpa, faculty, level, award, awardNum);
		
		response.sendRedirect("http://localhost:8080/Scholarship-System/AdminPortalServlet/");
	}
}
