package services;

import java.util.List;

import beans.Reimbursement;
import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;

public class ReimbursementService {

	ReimbursementDAO r = new ReimbursementDAOImpl();

	public ReimbursementService() {
	}

	public List<Reimbursement> reimbursementList() {
		List<Reimbursement> r1 = r.getReimbursements();
		return r1;
	}
}
