package services;

import java.util.List;

import beans.Reimbursement;
import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;

public class MyReimbursement {

	ReimbursementDAO r = new ReimbursementDAOImpl();

	public MyReimbursement() {
	}

	public List<Reimbursement> reimbursementList(int x) {
		List<Reimbursement> r1 = r.MyReimbursements(x);
		System.out.println(r1);
		
		return r1;
	}
}
