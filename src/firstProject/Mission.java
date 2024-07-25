package firstProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Mission 
{
	 public static Scanner in;
		public static Connection con;
		static
		{
			in = new Scanner(System.in);
			try 
			{
				con = JavaToSQLConnection.getConnection();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		public static int insert() throws SQLException
		{
			//getting input from user
			String name , location , designation;
			int salary,emp_id;
			System.out.println("----- Inserting ------");
			System.out.println("Emp_id : ");
			emp_id = in.nextInt();
			in.nextLine();
			System.out.println(" Name : ");
			name = in.nextLine();
			System.out.println("Designation : ");
			designation = in.nextLine();
			System.out.println("location ");
			location = in.nextLine();
			System.out.println("Salary : ");
			salary = in.nextInt();
			
			
			//executing query
			String query = "INSERT INTO employee(emp_id,name,designation,location,salary) VALUES (?,?,?,?,?)";
			PreparedStatement pt = con.prepareStatement(query);
			pt.setInt(1, emp_id);
			pt.setString(2, name);
			pt.setString(3,designation);
			pt.setString(4,location);
			pt.setInt(5, salary);
			int rowsAffected = pt.executeUpdate();
			
			return rowsAffected;
		}
		public static int delete() throws SQLException
		{
			System.out.println("----- Delete ------");
			int emp_id , rowsAffected;
			System.out.print("Enter Employee Id : ");
			emp_id = in.nextInt();
		    
			//executing query
			String query = "DELETE FROM employee WHERE emp_id="+emp_id+";";
			Statement st = con.createStatement();
			rowsAffected = st.executeUpdate(query);
			
			return rowsAffected;
		}
		public static void show() throws SQLException
		{
			
			String query = "SELECT * FROM employee;";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			//printing table
			String line = " _______________________________ ";
			line=line.replace("_", "-");
			System.out.printf("%s\n| %-4s | %-30s | %-25s | %-10s | %-10s |\n%s\n",line,"Emp_Id"," Name","Designation","Location","Salary",line);
		    while( rs.next() )
		    	System.out.printf("| %-4d | %-30s | %-25s | %-10s | %-10d |\n%s\n",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),line);
		    
		}
		public static int update() throws SQLException
		{
			//1.get	employee	id
			//2.which column to update
			//3.updated column value
			//4.execute query
			System.out.println("----- Update ------");
			int emp_id , rowsAffected,option;
			String query;
			String[] columns = {"emp_id","name","designation","location","salary"};
			
			//getting employee id
			System.out.print("Enter Emp_id : ");
			emp_id = in.nextInt();
			
			//getting which column to update
			System.out.println("Choose which column to update : \n1.Emp_id\n2.name\n3.designation\n4.Location\n5.Salary");
			option = in.nextInt();
			if(option > 5 || option < 1) {
			    System.out.println("Invalid Column!");
			    return 0;
			}

			// updated value
			System.out.print("Enter " + columns[option - 1] + " updated value : ");
			String query1;
			if(option != 5) {
			    in.nextLine();  // consume the leftover newline
			    String val = in.nextLine();
			    query1 = "UPDATE employee SET " + columns[option - 1] + "='" + val + "' WHERE emp_id=" + emp_id;
			} else {
			    int val = in.nextInt();
			    query1 = "UPDATE employee SET " + columns[option - 1] + "=" + val + " WHERE emp_id=" + emp_id;
			    in.nextLine();  // consume the leftover newline
			}

			// execute query
			Statement st = con.createStatement();
			rowsAffected = st.executeUpdate(query1);
			return rowsAffected;
		}
}
