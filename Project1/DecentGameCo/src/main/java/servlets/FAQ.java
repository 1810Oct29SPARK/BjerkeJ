package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Credentials;
import beans.Employee;
import services.AuthenticationService;

@WebServlet("/FAQ")
public class FAQ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AuthenticationService authService = new AuthenticationService();

	public FAQ() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session == null) {
			req.getRequestDispatcher("HTML/FAQ.html").forward(req,resp);
		} else {
			resp.sendRedirect("LFAQ");
		}
		

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Credentials cred = new Credentials(username, password);
		Employee e = authService.isValidUser(cred);
		if (e != null) {
			session.setAttribute("employeeId", e.getEmployeeId());
			session.setAttribute("firstname", e.getFirstname());
			session.setAttribute("lastname", e.getLastname());
			session.setAttribute("middleInitial", e.getMiddleInitial());
			session.setAttribute("title", e.getTitle());
			session.setAttribute("authLevel", e.getAuthLevel());
			session.setAttribute("directManager", e.getDirectManager());
			session.setAttribute("birthdate", e.getBirthdate());
			session.setAttribute("address", e.getAddress());
			session.setAttribute("zipcode", e.getZipcode());
			session.setAttribute("email", e.getEmail());
			session.setAttribute("phone", e.getPhone());
			resp.sendRedirect("FAQ");
		} else {
			session.invalidate();
			resp.sendRedirect("FAQ");
		}

	}

}
