package utilityClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection { 
	Connection con;
public Connection databaseConnection(){
	try{
		String url="jdbc:mysql://localhost:3306/mydb1";
		String user="root";
		String pass="";
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,user,pass);
	}catch(ClassNotFoundException e){
		
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	return con;
}
}
