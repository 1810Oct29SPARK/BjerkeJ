package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Employee;

@WebServlet("/session")
public class Session extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// grab current session, if it exists
		response.setContentType("application/json");
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("firstname") != null) {
			try {
				int userId = Integer.parseInt(session.getAttribute("employeeId").toString());
				String firstname = session.getAttribute("firstname").toString();
				String lastname = session.getAttribute("lastname").toString();
				String email = session.getAttribute("email").toString();
				Employee e = new Employee(userId, firstname, lastname, email);
				response.getWriter().write((new ObjectMapper()).writeValueAsString(e));
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
		}
	}

}