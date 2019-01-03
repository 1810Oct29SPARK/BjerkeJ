package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AddEmployee;

@WebServlet("/SubmitEmployee")
public class SubmitEmployee extends HttpServlet {

	AddEmployee addNewEmployee = new AddEmployee();
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
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
		addNewEmployee.AddNewEmployee(firstname, lastname, middleInitial, title, authLevel, directManager, birthdate, address, zipcode, email, phone);
		resp.sendRedirect("Manager");
	}
}
