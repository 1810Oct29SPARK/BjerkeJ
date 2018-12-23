package services;

import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;

public class SubmitReimbursementService {
	
	ReimbursementDAO submitReimbursement = new ReimbursementDAOImpl();
	

	public SubmitReimbursementService() {
	}
	
	public void SubmitReimbursement(int employeeId, String type, String description, String image, double amount) {
		submitReimbursement.addNewReimbursement(employeeId, type, description, image, amount);
	}
}
