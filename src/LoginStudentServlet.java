import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginStudentServlet
 */
@WebServlet("/LoginStudentServlet")
public class LoginStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginStudentServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Create database connection
		DBConnect connect = new DBConnect();
		
		String user = request.getParameter("user");
		request.setAttribute("user", user);
		String password = request.getParameter("password");
		// Verify user
		if (connect.loginStudent(user, password) == true) {
			request.getSession().setAttribute("user", user);;
			response.sendRedirect("StudentPortalServlet");
		} else {
			response.sendRedirect("wrong.html");
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	}
}
