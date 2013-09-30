package no.hib.dat104.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BetalingsOversiktServlet
 */
@WebServlet("/betalingsoversikt")
public class BetalingsOversiktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession sesjon = request.getSession(false);

	        if (sesjon == null || sesjon.getAttribute("passord") == null) {
	            response.sendRedirect("kassererlogin");
	        } else {
	        	request.getRequestDispatcher("WEB-INF/betalingsoversikt.jsp").forward(request, response);
	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
