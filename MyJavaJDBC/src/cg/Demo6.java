package cg; 
import java.sql.*; 
import java.util.*;

public class Demo6 {

public static void main(String[] args) throws SQLException {
	// TODO Auto-generated method stub
	Connection con=null;
	PreparedStatement updateSt=null;
	PreparedStatement selectSt=null;
	
	////Load the driver
	try {
		//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());////java 8 automatically load driver
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="hr";
		String pass="hr";
		
		 con=DriverManager.getConnection(url,user,pass);
		System.out.println("Your are connected");
		
		con.setAutoCommit(false);///tells that do not commit after every statement
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter you Account ID");
		int id=sc.nextInt();
		selectSt=con.prepareStatement("delete from account where aid=?");
		selectSt.setInt(1,id);
		int i=selectSt.executeUpdate();
		System.out.println("Deleted "+i);
		con.commit();
	
	}
	catch(SQLException e) {
		//con.rollback();
		System.out.println(e.getMessage()+""+e.getErrorCode()+""+e.getSQLState());
		e.printStackTrace();
	}
	finally {
		System.out.println("Connection Closed");
		if(con!=null)con.close();
		
	}
	
}
}