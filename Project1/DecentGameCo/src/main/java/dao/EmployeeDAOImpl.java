package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static final String filename = "connection.properties";

	public List<Employee> getEmployees() {
		List<Employee> e1 = new ArrayList<Employee>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM EMPLOYEE";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int employeeId = rs.getInt("EMPLOYEEID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String middleInitial = rs.getString("MIDDLEINITIAL");
				String title = rs.getString("TITLE");
				int authLevel = rs.getInt("AUTHLEVEL");
				int directManager = rs.getInt("DIRECTMANAGER");
				String birthdate = rs.getString("BIRTHDATE");
				String address = rs.getString("ADDRESS");
				int zipcode = rs.getInt("ZIPCODE");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				e1.add(new Employee(employeeId, firstname, lastname, middleInitial, title, authLevel, directManager, birthdate,
						address, zipcode, email, phone));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return e1;
	}
	
	public Employee getEmployee(int employeeId) {
		Employee e1 = new Employee();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("EMPLOYEEID");
				String firstname = rs.getString("FIRSTNAME");
				String lastname = rs.getString("LASTNAME");
				String middleInitial = rs.getString("MIDDLEINITIAL");
				String title = rs.getString("TITLE");
				int authLevel = rs.getInt("AUTHLEVEL");
				int directManager = rs.getInt("DIRECTMANAGER");
				String birthdate = rs.getString("BIRTHDATE");
				String address = rs.getString("ADDRESS");
				int zipcode = rs.getInt("ZIPCODE");
				String email = rs.getString("EMAIL");
				String phone = rs.getString("PHONE");
				e1 = new Employee(id, firstname, lastname, middleInitial, title, authLevel, directManager, birthdate,
						address, zipcode, email, phone);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return e1;
	}

	public void updateEmployee(int x, String firstName, String lastName, String middleInitial, String title,
			String address, int zipcode, String email, String phone) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE EMPLOYEE SET " + "FIRSTNAME = ?, " + "LASTNAME = ?, " + "MIDDLEINITIAL = ?, "
					+ "TITLE = ?, " + "ADDRESS = ?, " + "ZIPCODE = ?, " + "EMAIL = ?, " + "PHONE = ?"
					+ " WHERE EMPLOYEEID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, middleInitial);
			stmt.setString(4, title);
			stmt.setString(5, address);
			stmt.setInt(6, zipcode);
			stmt.setString(7, email);
			stmt.setString(8, phone);
			stmt.setInt(9, x);
			stmt.executeUpdate();
			System.out.println("Successfully updated");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteEmployee(int x) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEEID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, x);
			stmt.executeUpdate();
			System.out.println("Successfully deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addNewEmployee(String firstName, String lastName, String middleInitial, String title, int authLevel, int directManager,
			String birthdate, String address, int zipcode, String email, String phone) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "INSERT INTO EMPLOYEE(FIRSTNAME, LASTNAME, MIDDLEINITIAL, TITLE, DIRECTMANAGER, BIRTHDATE, ADDRESS, ZIPCODE, EMAIL, PHONE) VALUES"
					+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, middleInitial);
			stmt.setString(4, title);
			stmt.setInt(5, authLevel);
			stmt.setInt(6, directManager);
			stmt.setString(7, birthdate);
			stmt.setString(8, address);
			stmt.setInt(9, zipcode);
			stmt.setString(10, email);
			stmt.setString(11, phone);
			stmt.executeQuery();
			System.out.println("Successful Insertion");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
