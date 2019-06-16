
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginStudentServlet
 */
@WebServlet("/StudentPortalServlet")
public class StudentPortalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentPortalServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	      DBConnect connect = new DBConnect();
	 
	      // Write the response message, in an HTML page
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Student Portal</title>\n");
	         out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
	         out.println("<script src=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js\"></script>\n"); 
	         out.println("<link rel = \"stylesheet\" type =\"text/css\" href=\"https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css\">\n");
	         out.println("<script type=\"text/javascript\" src=\"https://cdn.datatables.net/v/dt/dt-1.10.18/sc-2.0.0/sl-1.3.0/datatables.min.js\"></script>");
	         out.println("<body>");
	         out.println("<h1>Student Portal</h1><h2>All available scholarships</h2><div class=\"container\"><table id=example class=\"display\" style=\"width:100%\"><thead><tr>"
	     	                +"<th>ID</th>"
	     	                +"<th>Name</th>"
	     	                +"<th>Academic Level</th>"
	     	                +"<th>Faculty</th>"
	     	                +"<th>Minimum GPA</th>"
	     	                +"<th>Award</th>"
	     	            +"</tr>"
	     	        +"</thead>"
	     	        +"<tbody>");
	         // dynamically update table from mySQl
	         Scholarship scholarships[] = connect.getScholarships();
	         for (Scholarship schol : scholarships) {
	         	//Scholarship schol = new Scholarship(1,"myScholarship",3.3,"Science","Undergraduate",1000);
	         	out.println("<tr>");
	         	out.println("<td>");
	         	out.println(schol.getID());
	         	out.println("</td>");
	         	out.println("<td>");
	         	out.println(schol.getName());
	         	out.println("</td>");
	         	out.println("<td>");
	         	out.println(schol.getAcademicLevel());
	         	out.println("</td>");
	         	out.println("<td>");
	         	out.println(schol.getFaculty());
	         	out.println("</td>");
	         	out.println("<td>");
	         	out.println(schol.getGPA());
	         	out.println("</td>");
	         	out.println("<td>");
	         	out.println(schol.getAward());
	         	out.println("</td>");
	         	out.println("</tr>");
	         }
	         out.println("</tbody></table>");
	         out.println("<p>\n" + 
	         		"			<input type=\"submit\" value=\"Apply for scholarship(s)\" />\n" + 
	         		"		</p>\n" + 
	         		"  	</div>\n" + 
	         		"    <script>\n" + 
	         		"	    $(document).ready(function() {\n" + 
	         		"	        var table = $('#example').DataTable();\n" + 
	         		"	     \n" + 
	         		"	        $('#example tbody').on( 'click', 'tr', function () {\n" + 
	         		"	            $(this).toggleClass('selected');\n" + 
	         		"	        } );\n" + 
	         		"	     \n" + 
	         		"	        $('#button').click( function () {\n" + 
	         		"	            alert( table.rows('.selected').data().length +' row(s) selected' );\n" + 
	         		"	        } );\n" + 
	         		"	    } );\n" + 
	         		"	</script>");
	         out.println("<p>Request URI: " + request.getRequestURI() + "</p>");
	         out.println("<p>Protocol: " + request.getProtocol() + "</p>");
	         out.println("<p>PathInfo: " + request.getPathInfo() + "</p>");
	         out.println("<p>Remote Address: " + request.getRemoteAddr() + "</p>");
	         // Generate a random number upon each request
	         out.println("<p>A Random Number: <strong>" + Math.random() + "</strong></p>");
	         out.println("</body>");
	         out.println("</html>");
	      } finally {
	         out.close();  // Always close the output writer
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
