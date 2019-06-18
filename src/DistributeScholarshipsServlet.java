import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DistributeScholarshipServlet
 */
@WebServlet("/DistributeScholarshipsServlet")
// Handles distribution of scholarships
public class DistributeScholarshipsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set response headers
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnect connect = new DBConnect();
		try {
			// Distribute the scholarships
			connect.distributeScholarship();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("http://localhost:8080/Scholarship-System/AdminPortalServlet/");
	}
}