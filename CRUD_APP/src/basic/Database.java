package basic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Database {
	public void CrudOperations() {	
		
		try {
			//Class.forName("com.mysql.cj.jdbc.Drive");
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","rootMySQL");
			//Statement statment = connection.createStatement();
			
			String continuedata = "";
			System.out.println("Welcome");
			//String connectionUrl = "jdbc:sqlserver://localhost: 3306;" + "database=user;" + "user=root" + "password=rootMySQL;";
			
			
			do
			{
				System.out.println("Select option:");
				System.out.println("Press 1 = SELECT \nPress 2 = INSERT \nPress 3 = DELETE \nPress 4 = UPDATE");
				Scanner sc = new Scanner(System.in);
				var DataInput = sc.nextLine();
				switch(DataInput)
				{
					case "1":
						ResultSet resultSet = null;
						try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","rootMySQL"); 
								Statement statment = connection.createStatement();) {
							String selectSql = "SELECT * from testdb.users";
							resultSet = statment.executeQuery(selectSql);
							
							while (resultSet.next()) {
								var str=String.format("%s %s", resultSet.getString(1),resultSet.getString(2));
								System.out.println(str);
							}
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						break;
					case "2":
						try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","rootMySQL");
								Statement statment = connection.createStatement();) {
							System.out.println("Enter first name:");
							var fname = sc.nextLine();
							System.out.println(fname);
							System.out.println("Enter last name:");
							var lname = sc.nextLine();
							System.out.println(lname);
							System.out.println("Enter classroom:");
							var cl = sc.nextLine();
							System.out.println(cl);
							System.out.println("Enter subject:");
							var subj = sc.nextLine();
							System.out.println(subj);
							System.out.println("Enter marks:");
							var marks = sc.nextLine();
							System.out.println(marks);
							System.out.println("Enter email:");
							var email = sc.nextLine();
							System.out.println(email);
							
							PreparedStatement stmt=connection.prepareStatement("insert into users (FIRST_NAME,LAST_NAME,classroom,marks,subject,EMAIL) values (?,?,?,?,?,?)");
							stmt.setString(1,fname);  
							stmt.setString(2,lname);  
							stmt.setString(3,cl);  
							stmt.setString(4,marks);  
							stmt.setString(5,subj);  
							stmt.setString(6,email);
							stmt.executeUpdate();
							System.out.println("Successfully entered.");
							
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						break;
					case "3":
						try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","rootMySQL"); 
								Statement statment = connection.createStatement();) {
							System.out.println("Enter ID you want to delete:");
							var ID = sc.nextLine();
							PreparedStatement stmt=connection.prepareStatement("delete from users where id = " + ID);
							stmt.executeUpdate();
							System.out.println("Successfully deleted.");
							
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						break;
					case "4":
						try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","rootMySQL");
								Statement statment = connection.createStatement();) {
							System.out.println("Enter the ID of the student to be updated :");
							var id = sc.nextLine();
							System.out.println(id);
							System.out.println("Enter first name:");
							var fname = sc.nextLine();
							System.out.println(fname);
							System.out.println("Enter last name:");
							var lname = sc.nextLine();
							System.out.println(lname);
							System.out.println("Enter classroom:");
							var cl = sc.nextLine();
							System.out.println(cl);
							System.out.println("Enter subject:");
							var subj = sc.nextLine();
							System.out.println(subj);
							System.out.println("Enter marks:");
							var marks = sc.nextLine();
							System.out.println(marks);
							System.out.println("Enter email:");
							var email = sc.nextLine();
							System.out.println(email);
							
							PreparedStatement stmt=connection.prepareStatement("update users set FIRST_NAME = ?,LAST_NAME=?,classroom=?,marks=?,subject=?,EMAIL=? where id=?");
							stmt.setString(1,fname);  
							stmt.setString(2,lname);  
							stmt.setString(3,cl);  
							stmt.setString(4,marks);  
							stmt.setString(5,subj);  
							stmt.setString(6,email);
							stmt.setString(7,id);
							stmt.executeUpdate();
							System.out.println("Successfully updated.");
							
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
						break;
						
						default:
						System.out.println("You have selected wrong input");
						break;
				}
				System.out.println("Enter y to continue; Enter any key to exit.");
				continuedata = sc.nextLine();
				if(continuedata.equals("y"))
					System.out.println("You have selected to continue.");
			}
			while (continuedata.equals("y"));
			System.out.println("you have selected to exit.");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
