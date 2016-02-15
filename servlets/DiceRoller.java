import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DiceRoller extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		
	PrintWriter out = res.getWriter();
	int d1, d2,total;
	d1= (int)(Math.random()*6)+1;
	d2= (int)(Math.random()*6)+1;
	out.println("<html><body>");
	out.println("<h2>Dice roller</h2><br>");
	out.println("<font size=5>Value of dice 1 = " + d1 + "<br>" +
	"Value of dice 2 = " +d2+"<br>");
	total=d1+d2;
	out.println("total dice value is = "+total);
	out.println("</font></body></html>");
	}
}