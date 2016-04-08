//STEP 1. Import required packages
import java.sql.*;

public class CreateTableUserdetails {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";
   static final String DB_URL = "jdbc:postgresql://127.0.0.1:5433/s2d130050131049";

   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "postgres";

   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
	  System.out.println("Enrollno: 130050131049");
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");

      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();

      String sql = "CREATE TABLE userdetails " +
                   "(name VARCHAR(255) not NULL, " +
                   " field VARCHAR(255) not NULL," +
                   " PRIMARY KEY ( name ))";

      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample
