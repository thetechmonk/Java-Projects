package studenManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;
	public static Connection connectionClass() {
		
		try{
			String username="User";
			String password="Your_password";
			String url="jdbc:mysql://localhost:3306/Database_name";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		
	}catch(Exception e) {
		System.out.println(e);
	}
		return con;
}
}
