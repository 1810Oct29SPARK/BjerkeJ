package services;

import beans.Credentials;
import beans.Employee;
import dao.CredentialsDAO;
import dao.CredentialsDAOImpl;
import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;

public class AuthenticationService {

	CredentialsDAO c = new CredentialsDAOImpl();
	EmployeeDAO e = new EmployeeDAOImpl();

	public AuthenticationService() {
	}

	public Employee isValidUser(Credentials credentials) {
		String username = credentials.getUsername();
		String password = credentials.getPassword();
		Credentials cl = c.login(username, password);
		int id = cl.getEmployeeId();
		System.out.println(id);
		Employee empl = null;
		if (username != null && password != null) {
			if (username.equals(cl.getUsername()) && password.equals(cl.getPassword())) {
				empl =  e.getEmployee(id);
				System.out.println(empl);
			}
		}
		return empl;
	}
}
