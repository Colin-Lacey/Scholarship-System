import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentApplyServlet
 */
@WebServlet("/StudentApplyServlet")
// Handles student applications
public class StudentApplyServlet extends HttpServlet {

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
		String user = request.getParameter("user");
		String scholarship = request.getParameter("scholID");
		// Add the user into application database with scholarship they registered for
		connect.addApplication(user, scholarship);
		
		response.sendRedirect("http://localhost:8080/Scholarship-System/StudentPortalServlet");
	}
}
