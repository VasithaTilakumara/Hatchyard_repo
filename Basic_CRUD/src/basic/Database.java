package basic;
import java.sql.Connection;
import java.sql.DriverManager;
public class Database {
	public void CrudOperations() {
		Connection connection = null;	
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Drive");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","rootMySQL");
			
			String continuedata = "";
			System.out.println("Welcome");
			String connectionUrl = "jdbc:sqlserver://localhost: 3306;" + "database=user;" + "user=root" + "password=rootMySQL;";
			
			
			do
			{
				System.out.println("Select option:");
				System.out.println("Press 1 = SELECT \nPress 2 = INSERT \nPress 3 = DELETE");
			}
			while (continuedata.equals("y"));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
