import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.ServletConfig;

public class redirect extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	String uname = req.getParameter("uname");
	String pass = req.getParameter("pass");
if(pass.equals("Admin"))
	{
		res.sendRedirect("redirect1");
	}
	else
	{
		res.sendRedirect("redirect2.html");
	}
	}
}