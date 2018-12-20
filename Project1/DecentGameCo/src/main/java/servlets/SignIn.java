package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Credentials;
import beans.User;
import services.AuthenticationService;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AuthenticationService authService = new AuthenticationService();

	public SignIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		resp.setContentType("text/html");

		Credentials cred = new Credentials(req.getParameter("username"),req.getParameter("password"));
		User u = authService.isValidUser(cred);
		if(u != null) {
			session.setAttribute("employeeId", u.getEmployeeId());
			session.setAttribute("username", u.getUsername());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("problem", null);
			resp.sendRedirect("home");
		} else {
			session.setAttribute("problem", "invalid credentials");
			resp.sendRedirect("home");
		}
		
		
		
	}

}
