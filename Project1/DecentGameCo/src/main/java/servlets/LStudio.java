package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.AuthenticationService;

@WebServlet("/LStudios")
public class LStudio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AuthenticationService authService = new AuthenticationService();

	public LStudio() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			req.getRequestDispatcher("LoggedInHTML/LStudios.html").forward(req, resp);
		} else {
			resp.sendRedirect("Studios");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
