

import java.io.*;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import  java.sql.*;
public class StudentServlet extends HttpServlet 
{
public void service(ServletRequest request, ServletResponse  response) throws ServletException, IOException 
	{
                   String strng1=request.getParameter("stdid");
                   String strng2=request.getParameter("password");
                   Connection con;
                   Statement stm;
                   ResultSet rs;
                   response.setContentType("text/html");
                   PrintWriter out=response.getWriter();
                   try
                   {
                	   Class.forName("com.mysql.jdbc.Driver");
                	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
                	   stm=con.createStatement();
                	   System.out.println("con succes");
                	   rs=stm.executeQuery("select *from login2 where id='"+strng1+"'and password='"+strng2+"'");
                	   if(rs.next()==true)
                       {
                    	   out.println("<html>");
                    	   out.println("<head>");
                    	   out.println("<h3>");
                    	   out.println("WELCOME STUDENT");
                    	   out.println("</h3>");
                    	   out.println("</head>");
                    	   out.println("<body background=\"C:\\Users\\pankaj\\Downloads\\images\\students.jpg\">");
                    	   out.println("<form method=\"post\" action=\"http://localhost:8080/StudentDatabase/SearchAttendance\">");
                    	   out.println("<input type=\"text\" name=\"num\">");
                    	   out.println("<input type=\"submit\" value=\"search attendance\">");
                    	   out.println("</form>");
                    	   out.println("<br>");
                    	   out.println("<form method=\"post\" action=\"http://localhost:8080/StudentDatabase/SearchResult\">");
                    	   out.println("<input type=\"text\" name=\"num1\">");
                    	   out.println("<input type=\"submit\" value=\"search result\">");
                    	   out.println("</form>");
                     	   out.println("<br>");
                    	   out.println("<a href=\"http://localhost:8080/StudentDatabase/NotifyServlet\" >");
                    	   out.println("Notifications</a>");
                    	   out.println("<br>");
                    	   out.println("<a href=\"http://localhost:8080/StudentDatabase/NewLogin.html\" >");
                    	   out.println("Home</a>");
                    	   out.println("</body>");
                    	   out.println("</html>");
                       }
                       else
                       {
                    	   out.println("<html>");
                    	   out.println("<head>");
                    	   out.println("<h4>");
                    	   out.println("INVALID ID OR PASSWORD");
                    	  out.println("</h4>");
                    	  out.println("</head>");
                    	  out.println("<body>");
                    	  out.println("<br>");
                    	  out.println("<a href=\"http://localhost:8080/StudentDatabase/NewLogin.html\" >");
                    	  out.println("Home</a>");
                    	  out.println("</body>");
                    	  out.println("</html>");
                    	   
                       }
                	}
                   catch(ClassNotFoundException e1)
                   {
                	   
                   }
                   catch(SQLException e2)
                   {
                	   
                   }
                 
                   
	}

}
