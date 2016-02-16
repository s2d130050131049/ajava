import java.sql.*;
import java.util.*;
class ex6
{
    public static void main(String args[]){
        PreparedStatement pstmt=null;
        Connection con=null;
        String PhNo;int AcNo;
        String Name,Address;
        Double Balance;
        int i=0;
		Statement stmt=null;
			String url="jdbc:mysql://localhost:3306/jdbc";
			String un="root";
			String pass="vaishali";
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver is loaded");
				con=DriverManager.getConnection(url,un,pass);
				System.out.println("Connection");
				stmt=con.createStatement();
				System.out.println("wrapper created");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		 try{
			System.out.println("Enroll no:130050131524");
            Scanner sc=new Scanner(System.in);
            while(i!=1){
                System.out.println("Enter the operation to be performed:\n1.Insert\n2.Update\n3.Delete\n4.View \n5.Exit");
                int ch=sc.nextInt();
                
                switch(ch){
                   case 1:
                        pstmt=con.prepareStatement("insert into bank values(?,?,?,?,?)");
                        System.out.println("Enter Account No:");
                        AcNo=sc.nextInt();
                        System.out.println("Enter Customer Name:");
                        Name=sc.next();
                        System.out.println("Enter Balance::");
                        Balance=sc.nextDouble();
                        System.out.println("Enter Phone No:");
                        PhNo=sc.next();
                        System.out.println("Enter Address:");
                        Address=sc.next();
                        pstmt.setInt(1,AcNo);
                        pstmt.setString(2,Name);
                        pstmt.setDouble(3,Balance);
                        pstmt.setString(4,PhNo);
                        pstmt.setString(5,Address);
                        pstmt.executeUpdate();
                        System.out.println("Data inserted successfully.");
                        break;
					case 2:
                        pstmt=con.prepareStatement("update bank set Balance=? where AcNo= ?;");  
                        System.out.println("Enter Account No:");
                        AcNo=sc.nextInt();
                        System.out.println("Enter Balance::");
                        Balance=sc.nextDouble();
                        pstmt.setInt(2,AcNo);
                        pstmt.setDouble(1,Balance);
                        pstmt.executeUpdate();
                        System.out.println("Data Updated successfully");
                        break;
                    case 3:
                        pstmt=con.prepareStatement("delete from bank where AcNo=?");
                        System.out.println("Enter Account No:");
                        AcNo=sc.nextInt();
                        pstmt.setInt(1,AcNo);
                        pstmt.executeUpdate();
                        System.out.println("Data Deleted successfully");
                        break;
					case 4:
						pstmt=con.prepareStatement("select * from bank where Balance>?");
						System.out.print("balance greater then:");
						Balance=sc.nextDouble();
						pstmt.setDouble(3,Balance);
						ResultSet r=pstmt.executeQuery();
						while(r.next())
						{
							System.out.println(r.getString("Account No")+"\t"+r.getString("Customer Name")+"\t"+r.getString("Balance")+"\t"+r.getString("Phone No")+"\t"+r.getString("Address"));
						}
						break; 
				 case 5:
                        i=1;
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;      
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }   
    }
}
