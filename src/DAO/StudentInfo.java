package DAO;

import java.util.Scanner;
import java.sql.*;

import com.mysql.jdbc.Connection;

import utilityClasses.DataConnection;
import utilityClasses.MyException;
import BeanClass.StudentBean;

public class StudentInfo {
	DataConnection dc= new DataConnection();
Connection con;
	public void recordData() throws SQLException, MyException{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter \n1.Roll No \n2.Name \n3.Percent");
		int roll=sc.nextInt();
		String name= sc.next();
		float percent= sc.nextFloat();
		String result= getResult(percent);
		if(name.equals(null)) throw new MyException();
		if(validate(roll)){
			con=(Connection) dc.databaseConnection();
			
			try {
				PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?,?)");
				pst.setInt(1, roll);
				pst.setString(2, name);
				pst.setFloat(3,percent);
				pst.setString(4, result);
				System.out.println(pst.executeUpdate()+" row(s) added");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con.close();
		}else System.out.println("Data CAN'T be validated");
	}
	
	
	private String getResult(float percent) {
		// TODO Auto-generated method stub
		if(percent<40 ){
			return new String("FAIL");
		}
		else
			return new String("PASS");
	}

	private boolean validate(int roll) {
		if(roll<1)
			return false;
		else
		return true;
	}
	public StudentBean readData() throws SQLException{
		StudentBean sb= new StudentBean();
		con= (Connection) dc.databaseConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from student");
		while(rs.next()){
			
			sb.setRoll(rs.getInt(1));
			sb.setName(rs.getString(2));
			sb.setPercent(rs.getFloat(3));
			sb.setResult(rs.getString(4));
		}
		return sb;
	}
}
