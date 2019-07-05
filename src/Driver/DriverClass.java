package Driver;

import java.sql.SQLException;

import utilityClasses.MyException;
import BeanClass.StudentBean;
import DAO.StudentInfo;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
StudentInfo student = new StudentInfo();
try {
	student.recordData();
} catch (SQLException | MyException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
StudentBean bean;
try {
	bean = student.readData();
	System.out.println("Roll NO.: "+bean.getRoll()+
			"\nName: "+bean.getName()+
			"\nPercent: "+bean.getPercent()+
			"\nResult: "+bean.getResult());

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

}
