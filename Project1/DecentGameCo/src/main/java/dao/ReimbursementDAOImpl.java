package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;
import beans.Reimbursement;
import util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	private static final String filename = "connection.properties";

	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> e1 = new ArrayList<Reimbursement>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM REIMBURSEMENTS";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENTID");
				int employeeId = rs.getInt("EMPLOYEEID");
				String type = rs.getString("TYPE");
				String description = rs.getString("DESCRIPTION");
				Blob image = rs.getBlob("IMAGE");
				double amount = rs.getDouble("AMOUNT");
				String status = rs.getString("STATUS");

				e1.add(new Reimbursement(reimbursementId, employeeId, type, description, image, amount, status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return e1;
	}
	public List<Reimbursement> MyReimbursements(int x) {
		List<Reimbursement> e1 = new ArrayList<Reimbursement>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMPLOYEEID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, x);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int reimbursementId = rs.getInt("REIMBURSEMENTID");
				String type = rs.getString("TYPE");
				String description = rs.getString("DESCRIPTION");
//				Blob image = rs.getBlob("IMAGE");
				double amount = rs.getDouble("AMOUNT");
				String status = rs.getString("STATUS");

				e1.add(new Reimbursement(reimbursementId, type, description, amount, status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return e1;
	}

	public String checkReimbursementStatus(int x) {
		String r = "";
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT STATUS FROM REIMBURSEMENTS WHERE REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, x);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				r = rs.getString("STATUS");
				System.out.println(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r;
	}

	public void updateReimbursement(int employeeId, String type, String description, String image, Double amount) {
		String location = image;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			File blob = new File(location);
			FileInputStream in = new FileInputStream(blob);
			String sql = "UPDATE REIMBURSEMENTS SET EMPLOYEEID = ?, SET TYPE = ?, DESCRIPTION = ?, SET IMAGE = ?, SET AMOUNT = ? WHERE REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			stmt.setString(2, type);
			stmt.setString(3, description);
			stmt.setBinaryStream(4, in);
			stmt.setDouble(5, amount);
			stmt.executeQuery();
			System.out.println("Successfully updated");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteReimbursement(int x) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "DELETE FROM REIMBURSEMENTS WHERE REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, x);
			stmt.executeQuery();
			System.out.println("Successfully deleted");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void approveReimbursement(int x) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE REIMBURSEMENTS SET STATUS = 'Approved' WHERE REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, x);
			stmt.executeQuery();
			System.out.println("Successfully approved");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void denyReimbursement(int x) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE REIMBURSEMENTS SET STATUS = 'Denied' WHERE REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, x);
			stmt.executeQuery();
			System.out.println("Successfully denied");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addNewReimbursement(int employeeId, String type, String description, String image, double amount) {
		String location = image;
		String pending = "Pending";
		try (Connection con = ConnectionUtil.getConnection(filename)) {
//			File blob = new File(location);
//			FileInputStream in = new FileInputStream(blob);
			String sql = "INSERT INTO REIMBURSEMENTS(EMPLOYEEID, TYPE, DESCRIPTION, AMOUNT, STATUS) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			stmt.setString(2, type);
			stmt.setString(3, description);
//			stmt.setBinaryStream(4, in);
			stmt.setDouble(4, amount);
			stmt.setString(5, pending);
			stmt.executeQuery();
			System.out.println("Successfully added");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
