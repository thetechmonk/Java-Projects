package studenManagement;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Test {
	public static void main(String[]args)throws IOException {
		System.out.println("Welcome to the Student Management System:");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to DELETE student");
			System.out.println("PRESS 3 to DISPLAY student");
			System.out.println("PRESS 4 to EXIT student");
			int choice=Integer.parseInt(br.readLine());
			if(choice==1) {
				//need to write the logic for add student.
				System.out.println("Enter the user name:");
				String name=br.readLine();
				System.out.println("Enter the phone number:");
				String phone=br.readLine();
				System.out.println("Enter the city:");
				String city=br.readLine();
				
				//creating student objects  
				StudentClass s=new StudentClass(name,phone,city);
				boolean ans=StudentDAO.insertStudent(s);
				if(ans==true) {
					System.out.println("Data Added successfully:");
				}
				else {
					System.out.println("something went Wrong");
				}
			}
			else if(choice==2) {
				//need to write the logic for delete
				System.out.println("Enter student id to delete:");
				int userId=Integer.parseInt(br.readLine());
				boolean ans=StudentDAO.deleteStudent(userId);
				if(ans==true) {
					System.out.println("Data Deleted successfully:");
				}
				else {
					System.out.println("something went Wrong");
				}
			}
			else if(choice==3) {
				//need to write the logic for display
				StudentDAO.show();
			}
			else if(choice==4) {
				//need to write the logic for exiting
				break;
			}
			else {
				break;
			}
		}
		System.out.println("Thank you for using our app");
	}

}
