

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


public class NotifyServlet extends HttpServlet 
{
	
	  String comm;
	Connection conn;
	Statement stmt;
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException
	{
		int i=0;
           comm=request.getParameter("comments");
            PrintWriter out=response.getWriter();
            response.setContentType("text/html");
            try
            {
            	Class.forName("com.mysql.jdbc.Driver");
            	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
                System.out.println("scucess ervsa");
                stmt.executeUpdate("insert into comment values('"+comm+"')");
            }
            catch(SQLException e1)
            {
            	
            }
            catch(ClassNotFoundException e2)
            {
            	
            }
            
            out.println("<html>");
             out.println("<head>");
             out.println("<h2>");
             out.println("Your notification done!");
             out.println("</h2>");
             out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"http://localhost:8080/StudentDatabase/NewLogin.html\" >");
             out.println("Home</a>");
             out.println("</body>");
             out.println("</html>");
             out.close();
             
	}

}
