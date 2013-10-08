

import java.io.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchResult extends HttpServlet
{
	  ResultSet rs;  
	     Connection conn;
	     Statement stmt;
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		 response.setContentType("text/html");
         PrintWriter out=response.getWriter();
        int i= Integer.parseInt(request.getParameter("num1"));
	   
	     try
	       {
	    	   
	    	   Class.forName("com.mysql.jdbc.Driver");
	    	   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
	    	   System.out.println("congratz");
	    	    stmt=conn.createStatement();
	    	   rs=stmt.executeQuery("select subject1,subject2,subject3,subject4 from result where Rollno="+i+"");
	    
	    	  while(rs.next())
	      	   {
	      		   out.println("<html>");
	      		   out.println("<body bgcolor=\"skyblue\">");
	      		   out.println("<table border=1>");
	      		   out.println("<tr>");
	      		   out.println("<td>sub no 1</td>");
	      		   out.println("<td>"+rs.getInt("subject1")+"</td>");
	      		   out.println("</tr>");
	      		   out.println("<tr>");
	      		   out.println("<td>sub no 2</td>");
	      		   out.println("<td>"+rs.getInt("subject2")+"</td>");
	      		   out.println("</tr>");
	      		   out.println("<tr>");
	      		   out.println("<td>sub no 3</td>");
	      		   out.println("<td>"+rs.getInt("subject3")+"</td>");
	      		   out.println("</tr>");
	      		   out.println("<tr>");
	      		   out.println("<td>sub no 4</td>");
	      		   out.println("<td>"+rs.getInt("subject4")+"</td>");
	      		   out.println("</tr>");
	      		   out.println("</table>");
	      	  	   out.println("<br>");
	          	   out.println("<a href=\"http://localhost:8080/StudentDatabase/NewLogin.html\" >");
	          	   out.println("Home</a>");
	      		   out.println("</body>");
	      		   out.println("</html>");
	      		   out.close();
	      		 
	      	   }
	      	   /*else
	      	   {
	      		   out.println("<html>");
	      		   out.println("<head>");
	      		   out.println("<h2>");
	      		   out.println("INVALID ROLL NUMBER");
	      		   out.println("</h2>");
	      		   out.println("</head>");
	      		   out.println("</html>");
	      	  }*/
         
	       }
	       catch(ClassNotFoundException e1)
	       {
	    	   
	       }
	       catch(SQLException e2)
	       {
	    	   
	       }
	}

}
