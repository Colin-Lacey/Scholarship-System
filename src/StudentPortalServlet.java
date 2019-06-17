
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	    HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute("user");
		System.out.println(user);
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
	         ArrayList<Scholarship> scholarships = connect.getScholarships();
	         // for each scholarship in the databse, format each of its attributes in the table
	         for (Scholarship schol : scholarships) {
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
	         		" <form action=\"StudentApplyServlet\" method = \"POST\">\n  " +
	         		"<input type=\"hidden\"  name = \"scholID\" id=\"scholID\" value=\"\" />\r\n" + 
	         		"	<input type = \"hidden\" name = \"user\" id = \"user\" value="+user+" />" +
	         		"<input type=\"submit\" value=\"Apply for scholarship(s)\" />\n" +
	         		" </form>" +
	         		"		</p>\n" + 
	         		"  	</div>\n" + 
	         		"    <script>\r\n" + 
	         		"	$(document).ready(function (){\r\n" + 
	         		"    var table = $('#example').DataTable();\r\n" + 
	         		"    \r\n" + 
	         		"    $('#example tbody').on( 'click', 'tr', function () {\r\n" + 
	         		"       	if ( $(this).hasClass('selected') ) {\r\n" + 
	         		"          	 $(this).removeClass('selected');\r\n" + 
	         		"       	} else {\r\n" + 
	         		"         	table.$('tr.selected').removeClass('selected');\r\n" + 
	         		"           	$(this).addClass('selected');\r\n" + 
	         		"       }\r\n" + 
	         		"       var data = $('#example').DataTable().row('.selected').data();\r\n" + 
	         		"       var id = data[0];\r\n" + 
	         		"       document.getElementById('scholID').value = id;\r\n" + 
	         		"   }); \r\n" + 
	         		"   }); \r\n" + 
	         		"</script></body></html>");
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
