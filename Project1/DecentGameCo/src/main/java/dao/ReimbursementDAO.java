package dao;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import beans.Reimbursement;

public interface ReimbursementDAO {

	public List<Reimbursement> getReimbursements();
	public void addNewReimbursement(int employeeId, String type, String description, Blob image, double amount);
	public void approveReimbursement(int x);
	public Date checkReimbursementStatus(int x);
	public void updateReimbursement(int employeeId, String type, String description, Blob image, Double amount);
	public void deleteReimbursement(int x);
	
}
