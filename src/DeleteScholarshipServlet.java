import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteScholarshipServlet
 */
@WebServlet("/DeleteScholarshipServlet")
// Handles scholarship deletion
public class DeleteScholarshipServlet extends HttpServlet {

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
		int ID = Integer.parseInt(request.getParameter("scholID"));
		// Delete the scholarship from the database
		connect.deleteScholarship(ID);
		
		response.sendRedirect("http://localhost:8080/Scholarship-System/AdminPortalServlet");
	}
}
