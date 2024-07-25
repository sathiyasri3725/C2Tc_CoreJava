package firstProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JavaToSQLConnection
{
    public static Connection getConnection() throws SQLException
    {
    	String url="jdbc:mysql://localhost:3306/miniproject";
    	String userName="root";
    	String password="root";
    	Connection con=DriverManager.getConnection(url,userName,password);
    	return con;
    }
}  
