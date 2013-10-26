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
	
	Database database = new Database();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Opprettet et nytt session dersom det ikke finnes noe fra før. Sender deretter brukeren til loginform.jsp
		session = request.getSession(true);
		request.getRequestDispatcher("WEB-INF/loginform.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean gyldigLogin = true; // SATT TIL TRUE FOR TESTING
		
		session = request.getSession(false);
		String brukernavn = (String) request.getParameter("brukernavn");
		String passord = (String) request.getParameter("passord");
				
		if(database.validerLogin(brukernavn, passord)) {
			Bruker bruker = database.hentBruker(brukernavn);
			session.setAttribute("bruker", bruker);
			response.sendRedirect("meny");
		} else {
			request.getRequestDispatcher("WEB-INF/loginerror.jsp").forward(request, response);
		}
	}

}
