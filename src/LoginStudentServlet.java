

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnect connect = new DBConnect();
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println(password);
		if (connect.loginStudent(user, password) == true) {
			System.out.println("success");
			response.sendRedirect("StudentPortalServlet");
		} else {
			response.sendRedirect("wrong.html");
		}
//		Student student = new Student(gpa, faculty, level);
//		ArrayList<Scholarship> arr = student.getMyScholarships();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
	}

}
