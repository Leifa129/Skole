package dat104.obl3.controllers;

import dat104.obl3.models.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Opprettet et nytt session dersom det ikke finnes noe fra før. Sender deretter brukeren til loginform.jsp
		session = request.getSession(true);
		request.getRequestDispatcher("WEB-INF/loginform.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(false);
		String brukernavn = (String) request.getParameter("brukernavn");
		String passord = (String) request.getParameter("passord");
		DAO db = new DAO();
		Bruker bruker = db.HentValidertBruker(brukernavn, passord);
		if (bruker != null) {
			session.setAttribute("bruker", bruker);
			response.sendRedirect("meny");
		} else {
			request.getRequestDispatcher("WEB-INF/loginerror.jsp").forward(request, response);
		}
	}

}
