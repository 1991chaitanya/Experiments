

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//port javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet
{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		String str1=req.getParameter("id");
		String str2=req.getParameter("pass");
		 ResultSet rs;
		 Connection conn;
		 Statement stmt;
		PrintWriter out=res.getWriter();
	       res.setContentType("text/html");
	       try
	       {
	    	   
	    	   Class.forName("com.mysql.jdbc.Driver");
	    	   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
	    	   System.out.println("connection success");
	    	    stmt=conn.createStatement();
	    	   rs=stmt.executeQuery("select *from login1 where id='"+str1+"' and password='"+str2+"' ");
	    	   if(rs.next()==true)
	           {
	    	   out.println("<html>");
	    	   out.println("<head>");
	    	   out.println("<h3>");
	    	   out.println("LOGGED IN SUCCESSFULLY");
	    	   out.println("<h3>");
	    	   out.println("</head>");
	    	   out.println("<body  background=\"C:\\Users\\pankaj\\Downloads\\images\\students.jpg\">");
	    	   out.println("<form method=\"post\" action=\"http://localhost:8080/StudentDatabase/Add.html\">");
	    	   out.println("<input type=\"submit\" value=\"ADD STUDENT\">");
               out.println("</form>");
	    	   out.println("<br><br>"); 
	    	   out.println("<form method=\"post\" action=\"http://localhost:8080/StudentDatabase/attend.html\">");
	    	   out.println("<input type=\"submit\" value=\" STUDENT ATTENDANCE\">");
	    	   out.println("</form>");
	    	   out.println("<br><br>");
	    	   out.println("<form method=\"post\" action=\"http://localhost:8080/StudentDatabase/result.html\">");
	    	   out.println("<input type=\"submit\" value=\" STUDENT RESULTS\">");
	    	   out.println("</form>");
	    	   out.println("<br><br>");
	    	   out.println("<form method=\"post\" action=\"http://localhost:8080/StudentDatabase/comments.html\">");
	    	   out.println("<input type=\"submit\" value=\" ADD NOTIFICATIONS\">");
	    	   out.println("</form>");
	    	   out.println("</body>");
	    	   out.println("</html>");
	    	   }
	    	   else
	    	   {
	    		   out.println("<html>");
		    	   out.println("<head>");
		    	   out.println("<h3>");
		    	   out.println("INVALID ID OR PASSWORD");
		    	   out.println("</h3>");
		    	   out.println("</head>");
		    	   out.println("</html>");
	    		   
	    	   }
	    	}
	       catch(SQLException e1)
	       {
	    	   
	       }
	       catch(ClassNotFoundException e2)
	       {
	    	   
	       }
	      
	}
	
}
