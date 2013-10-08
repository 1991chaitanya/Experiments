

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.sql.*;


public class SearchAttendance extends HttpServlet 
{
	  ResultSet rs;  
	     Connection conn;
	     Statement stmt;
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
          response.setContentType("text/html");
          PrintWriter out=response.getWriter();
         int i= Integer.parseInt(request.getParameter("num"));
       
	     try
	       {
	    	   
	    	   Class.forName("com.mysql.jdbc.Driver");
	    	   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
	    	   System.out.println("congratz");
	    	    stmt=conn.createStatement();
	    	   rs=stmt.executeQuery("select month1,month2,month3,month4,average from attendance where Rollno="+i+"");
	    
	    	  while(rs.next())
	      	   {
	      		   out.println("<html>");
	      		   out.println("<body bgcolor=\"skyblue\">");
	      		   out.println("<table border=1>");
	      		   out.println("<tr>");
	      		   out.println("<td>month no 1</td>");
	      		   out.println("<td>"+rs.getInt("month1")+"</td>");
	      		   out.println("</tr>");
	      		   out.println("<tr>");
	      		   out.println("<td>month no 2</td>");
	      		   out.println("<td>"+rs.getInt("month2")+"</td>");
	      		   out.println("</tr>");
	      		   out.println("<tr>");
	      		   out.println("<td>month no 3</td>");
	      		   out.println("<td>"+rs.getInt("month3")+"</td>");
	      		   out.println("</tr>");
	      		   out.println("<tr>");
	      		   out.println("<td>month no 4</td>");
	      		   out.println("<td>"+rs.getInt("month4")+"</td>");
	      		   out.println("</tr>");
	      		   out.println("<tr>");
	      		   out.println("<td>average</td>");
	      		   out.println("<td>"+rs.getInt("average")+"</td>");
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
