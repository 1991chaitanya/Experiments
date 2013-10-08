

import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Result extends HttpServlet
{
	Connection conn;
	Statement stmt;
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		int st0=Integer.parseInt(request.getParameter("rno"));
		int st1=Integer.parseInt(request.getParameter("sub1"));
		int st2=Integer.parseInt(request.getParameter("sub2"));
		int st3=Integer.parseInt(request.getParameter("sub3"));
		int st4=Integer.parseInt(request.getParameter("sub4"));
		response.setContentType("text/html");
         PrintWriter out=response.getWriter();
         try
         {
        	 Class.forName("com.mysql.jdbc.Driver");
        	 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
                System.out.println("successss!");
                stmt=conn.createStatement();
                stmt.executeUpdate("insert into result values("+st0+","+st1+","+st2+","+st3+","+st4+")");
         }
         catch(ClassNotFoundException e1)
         {
        	 
         }
         catch(SQLException e2)
         {
        	 
         }
         out.println("<html>");
         out.println("<head>");
         out.println("<img src=\"C:\\Users\\pankaj\\Downloads\\images\\icon1.jpg\">");
     	out.println("</img>");
     	out.println("<h2>data added succesfully</h2>"); 
     	out.println("</head>");
         out.println("<body bgcolor\"skyblue\">");
         //out.println("<br>");
  	       out.println("<a href=\"http://localhost:8080/StudentDatabase/NewLogin.html\" >");
  	       out.println("Home</a>");
  		   out.println("</body>");
            out.println("</html>");
        
	}

}
