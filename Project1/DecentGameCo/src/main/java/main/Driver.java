package main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import beans.Credentials;
import beans.Employee;
import beans.Reimbursement;
import dao.*;
import util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) throws ParseException {
//		EmployeeDAO listEmployee = new EmployeeDAOImpl();
//		List<Employee> employees = listEmployee.getEmployees();
//		for (Employee e : employees) {
//			System.out.println(e);
//		}
//		CredentialsDAO listCredentials = new CredentialsDAOImpl();
//		List<Credentials> credentials = listCredentials.getCredentials();
//		for (Credentials c : credentials) {
//			System.out.println(c);
//		}
//		CredentialsDAO listUsernameCredentials = new CredentialsDAOImpl();
//		List<Credentials> userCredentials = listUsernameCredentials.getUsernames();
//		for(Credentials c : userCredentials) {
//			System.out.println(c);
//		}
		EmployeeDAO employee = new EmployeeDAOImpl();
		Employee e = employee.getEmployee(10061);
		System.out.println(e);
//		CredentialsDAO addNewCredentials = new CredentialsDAOImpl();
//		addNewCredentials.addNewCredentials("JerBjer", "12345", 10061);
//		
//		CredentialsDAO deleteCredentials = new CredentialsDAOImpl();
//		deleteCredentials.deleteCredentials(10087);
//		
//		CredentialsDAO updateCredentials = new CredentialsDAOImpl();
//		updateCredentials.updateCredentials("USERNAME", "Jackstuff", 10087);
//		
//		CredentialsDAO login = new CredentialsDAOImpl();
//		Credentials login1 = login.login("JerBjer", "12345");
//		System.out.println(login1);
//		
//		ReimbursementDAO listReimbursements = new ReimbursementDAOImpl();
//		List<Reimbursement> reimbursements = listReimbursements.getReimbursements();
//		for(Reimbursement r : reimbursements) {
//			System.out.println(r);
//		}
//		ReimbursementDAO insertReimbursement = new ReimbursementDAOImpl();
//		insertReimbursement.addNewReimbursement(10022, "Purchase", "I bought Stuff", null, 109.93);
//		ReimbursementDAO checkReimbursement = new ReimbursementDAOImpl();
//		
//		ReimbursementDAO approveReimbursement = new ReimbursementDAOImpl();
//		approveReimbursement.approveReimbursement(1);
//		
//		ReimbursementDAO checkReimbursement = new ReimbursementDAOImpl();
//		checkReimbursement.checkReimbursementStatus(1);
//		
//		ReimbursementDAO deleteReimbursement = new ReimbursementDAOImpl();
//		deleteReimbursement.deleteReimbursement(1);
//		
//		ReimbursementDAO updateReimbursement = new ReimbursementDAOImpl();
//		updateReimbursement.updateReimbursement(employeeId, type, description, image, amount);
//		
//		EmployeeDAO addEmployee = new EmployeeDAOImpl();
//		addEmployee.addNewEmployee("Jake", "Stephanson", "L", "Designer", 10085, "10-OCT-00", "5678 Potato Ave", 33610, "jakdes@company.com", "(851)-837-2103");
//		
//		EmployeeDAO updateEmployee = new EmployeeDAOImpl();
//		updateEmployee.updateEmployee(10087, "Jake", "Stephanson", "W", "Designer", "5678 Potato Ave", 33610, "jakdes@company.com", "(851)-837-2103");
//		
//		EmployeeDAO deleteEmployee = new EmployeeDAOImpl();
//		deleteEmployee.deleteEmployee(10087);

	}

	static void init() {
		try {
			Connection con = ConnectionUtil.getConnection("Connection.Properties");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
