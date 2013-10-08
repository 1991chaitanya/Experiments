

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
	
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
{
  int str1=Integer.parseInt(req.getParameter("mon1"));
  int str2=Integer.parseInt(req.getParameter("mon2"));
  int str3=Integer.parseInt(req.getParameter("mon3"));
  int str4=Integer.parseInt(req.getParameter("mon4"));
  int str5=Integer.parseInt(req.getParameter("roll"));
  int avg=(str1+str2+str3+str4)/4;
  PrintWriter out=res.getWriter();
  res.setContentType("text/html");
  try
  {
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
        System.out.println("success dude");	
	  Statement stmt=conn.createStatement();
	  stmt.executeUpdate("insert into attendance values("+str1+","+str2+","+str3+","+str4+","+avg+","+str5+")");
   }
  catch(ClassNotFoundException e1)
  {
	  
  }
  catch(SQLException e2)
  {
	  
  }
  out.println("<html>");
  out.println("<head>");
  out.println("<h2>");
  out.println("<img src=\"C:\\Users\\pankaj\\Downloads\\images\\icon1.jpg\">");
out.println("</img>");
out.println("DATA ENTERED SUCCESSFULL");
out.println("</h2>");
  out.println("</head>");
  out.println("<br>");
  out.println("<a href=\"http://localhost:8080/StudentDatabase/NewLogin.html\" >");
  out.println("Home</a>");
  out.println("</html>");
  
  
}

}
