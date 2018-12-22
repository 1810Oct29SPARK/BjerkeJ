package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.AuthenticationService;

@WebServlet("/LStore")
public class LStore extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AuthenticationService authService = new AuthenticationService();

	public LStore() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null) {
			req.getRequestDispatcher("LoggedInHTML/LStore.html").forward(req, resp);
		} else {
			resp.sendRedirect("Store");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
