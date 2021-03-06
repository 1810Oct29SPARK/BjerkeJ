package dao;

import java.util.List;

import beans.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();
	public Employee getEmployee(int employeeId);
	public void addNewEmployee(String firstName, String lastName, String middleInitial, String title, int authLevel, int directManager, String birthdate, String address, int zipcode, String email, String phone);
	public void updateEmployee(int x, String firstName, String lastName, String middleInitial, String title, String address, int zipcode, String email, String phone);
	public void deleteEmployee(int x);

}
