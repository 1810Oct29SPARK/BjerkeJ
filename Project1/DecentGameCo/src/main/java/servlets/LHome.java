package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.AuthenticationService;

@WebServlet("/LHome")
public class LHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AuthenticationService authService = new AuthenticationService();

	public LHome() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			req.getRequestDispatcher("LoggedInHTML/LHome.html").forward(req, resp);
		} else {
			resp.sendRedirect("Home");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		HttpSession session = req.getSession();
//		resp.sendRedirect("LoggedInHTML/Home.html");
//		resp.setContentType("text/html");
//
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		Credentials c = new Credentials(username, password);
//		Employee e = authService.isValidUser(c);
//		if (e != null) {
//			session.setAttribute("employeeId", e.getEmployeeId());
//			session.setAttribute("firstname", e.getFirstname());
//			session.setAttribute("lastname", e.getLastname());
//			session.setAttribute("email", e.getEmail());
//			session.setAttribute("problem", null);
//			resp.sendRedirect("HTML/About");
//		} else {
//			session.setAttribute("problem", "invalid credentials");
//			resp.sendRedirect("HTML/Home");
//		}

	}

}
