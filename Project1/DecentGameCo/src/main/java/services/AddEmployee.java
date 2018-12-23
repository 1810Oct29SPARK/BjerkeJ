package services;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

public class AddEmployee {
	
	EmployeeDAO newEmployee = new EmployeeDAOImpl();
	

	public AddEmployee() {
	}
	
	public void AddNewEmployee(String firstName, String lastName, String middleInitial, String title, int authLevel, int directManager, String birthdate, String address, int zipcode, String email, String phone) {
		newEmployee.addNewEmployee(firstName, lastName, middleInitial, title, authLevel, directManager, birthdate, address, zipcode, email, phone);
	}
}
