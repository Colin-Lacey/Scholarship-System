
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginStudentServlet
 */
@WebServlet("/AdminPortalServlet")
public class AdminPortalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPortalServlet() {
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
	         out.println("<title>Admin Portal</title>\n");
	         out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
	         out.println("<script src=\"https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js\"></script>\n"); 
	         out.println("<link rel = \"stylesheet\" type =\"text/css\" href=\"https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css\">\n");
	         out.println("<script type=\"text/javascript\" src=\"https://cdn.datatables.net/v/dt/dt-1.10.18/sc-2.0.0/sl-1.3.0/datatables.min.js\"></script>");
	         out.println("<body>");
	         out.println("<h1>Admin Portal</h1><h2>All available scholarships</h2><div class=\"container\"><table id=example class=\"display\" style=\"width:100%\"><thead><tr>"
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
	         out.println( 
	         		" 			<p>\r\n" + 
	         		"	<form action=\"DeleteScholarshipServlet\" method = \"POST\">\r\n" + 
	         		"		<input type=\"hidden\"  name = \"scholID\" id=\"scholID\" value=\"\" />\r\n" + 
	         		"		<input type=\"submit\"  value = \"Delete scholarship\"/>\r\n" + 
	         		"	</form>\r\n" + 
	         		"</p>" 			+
	         		"		</p>\n" +
	         		"<form action=\"AddScholarshipServlet\" method=\"POST\">" +
	         		" <h1>Enter new scholarship details:</h1>\n" + 
	         		"				<p>Name\n" + 
	         		"					<input type=\"text\" name=\"name\" />\n" + 
	         		"				</p>\n" + 
	         		"				<p>Minimum GPA\n" + 
	         		"					<input type=\"text\" name=\"gpa\" />\n" + 
	         		"				</p>\n" + 
	         		"				<p>Faculty\n" + 
	         		"					<select name = \"faculty\">\n" + 
	         		"  						<option value=\"Science\">Science</option>\n" + 
	         		"  						<option value=\"Arts\">Arts</option>\n" + 
	         		"  						<option value=\"Medicine\">Medicine</option>\n" + 
	         		"  						<option value=\"Business\">Business</option>\n" + 
	         		"					</select>\n" + 
	         		"				</p>\n" + 
	         		"				<p>Academic Level\n" + 
	         		"					<select name = \"level\">\n" + 
	         		"  						<option value=\"Undergraduate\">Undergraduate</option>\n" + 
	         		"  						<option value=\"Graduate\">Graduate</option>\n" + 
	         		"  						<option value=\"postgrad\">Post-graduate</option>\n" + 
	         		"					</select>\n" + 
	         		"				</p>\n" + 
	         		"				<p>Award Value\n<input type=\"text\" name=\"award\" />\n</p>\n" +
	         		"				<p>Award Quantity\n<input type=\"text\" name=\"awardNum\" />\n</p>\n" +
	         		"				<p>\n" + 
	         		"					<input type=\"submit\" value=\"Add Scholarship\" />\n" + 
	         		"				</p>" +
	         		"</form>" +
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
