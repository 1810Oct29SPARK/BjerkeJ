package dao;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import beans.Reimbursement;

public interface ReimbursementDAO {

	public List<Reimbursement> getReimbursements();
	public void addNewReimbursement(int employeeId, String type, String description, String image, double amount);
	public void approveReimbursement(int x);
	public void denyReimbursement(int x);
	public String checkReimbursementStatus(int x);
	public void updateReimbursement(int employeeId, String type, String description, String image, Double amount);
	public void deleteReimbursement(int x);
	
}
