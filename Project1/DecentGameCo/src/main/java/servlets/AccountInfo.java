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

@WebServlet("/AccountInfo")
public class AccountInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("firstname") != null) {
			try {
				int employeeId = Integer.parseInt(session.getAttribute("employeeId").toString());
				String firstname = session.getAttribute("firstname").toString();
				String lastname = session.getAttribute("lastname").toString();
				String middleInitial = session.getAttribute("middleInitial").toString();
				String title = session.getAttribute("title").toString();
				int authLevel = Integer.parseInt(session.getAttribute("authLevel").toString());
				int directManager = Integer.parseInt(session.getAttribute("directManager").toString());
				String birthdate = session.getAttribute("birthdate").toString();
				String address = session.getAttribute("address").toString();
				int zipcode = Integer.parseInt(session.getAttribute("zipcode").toString());
				String email = session.getAttribute("email").toString();
				String phone = session.getAttribute("phone").toString();
				Employee e = new Employee(employeeId, firstname, lastname, middleInitial, title, authLevel, directManager, birthdate, address, zipcode, email, phone);
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
