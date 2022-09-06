package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnected()
	{
		Connection con = null;;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/billing_software?useSSL=false","root","H@st@1@vist@b@by");
		}
		
		catch(Exception e)
		{
			System.out.print(e);
		}
		return con;
	}
}
