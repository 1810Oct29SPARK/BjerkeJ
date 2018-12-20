package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
				Date dateSubmitted = rs.getDate("DATESUBMITTED");
				Date dateApproved = rs.getDate("DATEAPPROVED");

				e1.add(new Reimbursement(reimbursementId, employeeId, type, description, image, amount, dateSubmitted,
						dateApproved));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return e1;
	}

	public Date checkReimbursementStatus(int x) {
		Date r = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT DATEAPROVED FROM REIMBURSEMENTS WHERE REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, x);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				r = rs.getDate("DATEAPROVED");
			System.out.println(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r;
	}

	public void updateReimbursement(int employeeId, String type, String description, Blob image, Double amount) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE REIMBURSEMENTS SET EMPLOYEEID = ?, SET TYPE = ?, DESCRIPTION = ?, SET IMAGE = ?, SET AMOUNT = ? WHERE REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			stmt.setString(2, type);
			stmt.setString(3, description);
			stmt.setBlob(4, image);
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
		LocalDate today = LocalDate.now();
		String date = today.toString();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE REIMBURSEMENTS SET DATEAPROVED = ? WHERE REIMBURSEMENTID = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, date);
			stmt.setInt(2, x);
			stmt.executeQuery();
			System.out.println("Successfully approved");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addNewReimbursement(int employeeId, String type, String description, Blob image, double amount) {
		LocalDate today = LocalDate.now();
		String date = today.toString();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "INSERT INTO REIMBURSEMENTS(EMPLOYEEID, TYPE, DESCRIPTION, IMAGE, AMOUNT, DATESUBMITTED) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			stmt.setString(2, type);
			stmt.setString(3, description);
			stmt.setBinaryStream(4, (InputStream) image);
			stmt.setDouble(5, amount);
			stmt.setString(6, date);
			stmt.executeQuery();
			System.out.println("Successfully added");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
