package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.AddEmployee;
import services.AuthenticationService;

@WebServlet("/Manager")
public class Manager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AddEmployee addNewEmployee = new AddEmployee();

	public Manager() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && Integer.parseInt(session.getAttribute("authLevel").toString()) > 1) {
			req.getRequestDispatcher("LoggedInHTML/ManagerHome.html").forward(req, resp);
		} else {
			resp.sendRedirect("Home");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String middleInitial = req.getParameter("middleInitial");
		String title = req.getParameter("title");
		int authLevel = Integer.parseInt(req.getParameter("authLevel"));
		int directManager = Integer.parseInt(req.getParameter("directManager"));
		String birthdate = req.getParameter("birthdate");
		String address = req.getParameter("address");
		int zipcode = Integer.parseInt(req.getParameter("zipcode"));
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		addNewEmployee.AddNewEmployee(firstname, lastname, middleInitial, title, authLevel, directManager, birthdate, address, zipcode, email, phone);
		
	}
}
