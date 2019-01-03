package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Reimbursement;
import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;
import services.AddEmployee;

@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AddEmployee addNewEmployee = new AddEmployee();
	ReimbursementDAO r = new ReimbursementDAOImpl();

	public Manager() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
//		PrintWriter pw = resp.getWriter();
		if (session != null && Integer.parseInt(session.getAttribute("authLevel").toString()) > 1) {
			req.getRequestDispatcher("LoggedInHTML/ManagerHome.html").forward(req, resp);		
		} else {
			resp.sendRedirect("Home");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
