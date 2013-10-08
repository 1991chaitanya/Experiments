

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.sql.*;

public class InsertServlet extends HttpServlet 
{
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
	String s1=req.getParameter("name");
	int i=Integer.parseInt(req.getParameter("rollno"));
	String s2=req.getParameter("class");
	String s3=req.getParameter("dept");
	res.setContentType("text/html");
	PrintWriter out=res.getWriter();
	Connection conn;
	Statement stmt;
	try
	{
	Class.forName("com.mysql.jdbc.Driver");	
 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");	
System.out.println("connection successsful again");	
 stmt=conn.createStatement();
	stmt.executeUpdate("insert into std values('"+s1+"',"+i+",'"+s2+"','"+s3+"')");
	}
	catch(SQLException e1)
	{
		
	}
  catch(ClassNotFoundException e2)
  {
	  
  }
	out.println("<html>");
	out.println("<head>");
	out.println("<h3>");
	out.println("<img src=\"C:\\Users\\pankaj\\Downloads\\images\\icon1.jpg\">");
	out.println("</img>");
	out.println("INSERTED SUCCESSFULLY");
	out.println("</h3>");
	
	out.println("</head>");
	out.println("<body>"); 
	out.println("<br>");
	   out.println("<a href=\"http://localhost:8080/StudentDatabase/NewLogin.html\" >");
	   out.println("Home</a>");
	   out.println("</body>");
	   out.println("</html>");
	}
}