

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;

public class GetServlet extends HttpServlet
{
	 Connection conn;
	  Statement stmt;
	  ResultSet rs;
	String array[];
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
//		HttpSession hp=request.getSession(true);
	//      String str=(hp.getAttribute("hpsession").toString()); 
	 
	  //ArrayList<String[]> list= new ArrayList<String[]>();
	  
	  try
	  {
		  Class.forName("com.mysql.jdbc.Driver");
		  conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
		  System.out.println("success bhaiya");
           rs=stmt.executeQuery("select *from comment");
           while(rs.next())
           {
        	   out.println("<html>");
        	   out.println("<head>");
        	   out.println("<h2>");
        	   out.println("NOTIFICATION");
        	   out.println("</h2>");
        	   out.println("</head>");
        	   out.println("<body>");
        	   out.println("notification"+array+"ok!");
        	   out.println("</body>");
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
