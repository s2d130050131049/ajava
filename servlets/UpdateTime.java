import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.ServletConfig;

public class UpdateTime extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	
	res.addHeader("Refresh","1");
        String time = new Date().toString();
	out.println("CURRENT TIME:  " +time);
	
	
	}
}