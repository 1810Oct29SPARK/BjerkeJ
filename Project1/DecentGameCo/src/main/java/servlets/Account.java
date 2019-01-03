package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReimbursementDAO;
import dao.ReimbursementDAOImpl;
import services.SubmitReimbursementService;


@WebServlet("/Account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubmitReimbursementService submitservice = new SubmitReimbursementService();
	ReimbursementDAO r = new ReimbursementDAOImpl();
    public Account() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		PrintWriter pw = response.getWriter();
		if(session != null && session.getAttribute("employeeId") != null) {
			request.getRequestDispatcher("LoggedInHTML/Account.html").forward(request, response);
		} else {
			response.sendRedirect("Home");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String type = request.getParameter("type");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String description = request.getParameter("Description");
		String image = "image";
		submitservice.SubmitReimbursement(employeeId, type, description, image, amount);
		response.sendRedirect("Account");
		
	}

}
