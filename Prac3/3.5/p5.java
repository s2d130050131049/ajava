import java.sql.*;
import java.util.*;
class p5
{
	public static void main(String args[])
	{
		Connection con=null;
		Statement stmt=null;
		String url="jdbc:mysql://localhost:3306/jdbc";
		String un="root";
		String pass="vaishali";
		CallableStatement cstmt=null;
		Scanner sc=new Scanner(System.in);
		ResultSet rs=null;
		
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("driver is loaded");
		con=DriverManager.getConnection(url,un,pass);
		System.out.println("Connection");
		System.out.println("wrapper created");
		System.out.println("Enrollno: 130050131524");
		cstmt=con.prepareCall("{ call student1(?,?,?)}");
		cstmt.setInt(1,1);
		cstmt.registerOutParameter(2, Types.VARCHAR);
		cstmt.registerOutParameter(3, Types.VARCHAR);
		cstmt.execute();

		System.out.println("Selected Data is:");
		System.out.println(cstmt.getString(2)+"  "+cstmt.getString(3));

		
		cstmt.close();
	}
	catch(ClassNotFoundException cnfe)
	{
		System.out.println("driver not loaded"+cnfe.getMessage());
		return;
	}
	catch(SQLException sqle)
	{
		System.out.println("Connection problem"+sqle.getMessage());
		return;
	}
}
	
}

