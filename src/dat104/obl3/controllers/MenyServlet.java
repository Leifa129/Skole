package dat104.obl3.controllers;

import dat104.obl3.models.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/meny")
public class MenyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession(true);
		
		// KUN TIL TESTING:
		Spill[] spillTab = new Spill[3];
		spillTab[0] = new Spill(1, "urrang", 3);
		spillTab[1] = new Spill(2, "morten", 4);
		spillTab[2] = new Spill(3, "eirik", 5);
		session.setAttribute("spillTab", spillTab);
		
		// Sjekker om session inneholder attributtet "bruker". Hvis ja er brukeren logget inn og vi forwarder til meny.jsp
		// Hvis nei forwarder vi til loginform.jsp
		if(session.getAttribute("bruker") != null) {
			Bruker bruker = (Bruker) session.getAttribute("bruker");
			request.getRequestDispatcher("WEB-INF/meny.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("WEB-INF/loginform.jsp").forward(request, response);
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
