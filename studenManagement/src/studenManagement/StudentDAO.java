package studenManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	//Method for Adding the student 
	public static boolean insertStudent(StudentClass s) {
		boolean f=false;
		Connection con=ConnectionProvider.connectionClass();
		String query="INSERT INTO students(sname,sphone,scity)  VALUES (?,?,?)";
		try {
			PreparedStatement stm=con.prepareStatement(query);
			stm.setString(1, s.getStudentName());
			stm.setString(2,s.getStudentPhone());
			stm.setString(3,s.getStudentCity());
			stm.executeUpdate();
			f=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	//Method for Deleting the student
	public static boolean deleteStudent(int userId) {
		boolean f=false;
		Connection con=ConnectionProvider.connectionClass();
		String query="delete from students where sid=? ";
		try {
			PreparedStatement stm=con.prepareStatement(query);
			stm.setInt(1, userId);
			stm.executeUpdate();
			f=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
	}
	//Method for Displaying the student
	public static void show() {
		
		Connection con=ConnectionProvider.connectionClass();
		String query="select *from students";
		try {
			Statement stm=con.createStatement();
			ResultSet r=stm.executeQuery(query);
			while(r.next()) {
				int id=r.getInt(1);
				String name=r.getString(2);
				String phone=r.getString(3);
				String city=r.getString(4);
				System.out.println("ID "+id);
				System.out.println("name "+name);
				System.out.println("phone"+phone);
				System.out.println("city "+city);
				System.out.println("------------");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
