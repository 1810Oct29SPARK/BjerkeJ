package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Reimbursement;
import services.ReimbursementService;

@WebServlet("/ReimbursementList")
public class ReimbursementList extends HttpServlet {

	ReimbursementService reimburseService = new ReimbursementService();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
//		HttpSession session = request.getSession(false);
			List<Reimbursement> r = reimburseService.reimbursementList();
			response.getWriter().write((new ObjectMapper()).writeValueAsString(r));

	}
}
